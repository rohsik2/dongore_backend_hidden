package com.sns.dongore.feed;

import com.sns.dongore.address.LocationRepo;
import com.sns.dongore.address.model.Location;
import com.sns.dongore.address.model.LocationDetail;
import com.sns.dongore.exceptions.BaseResponse;
import com.sns.dongore.exceptions.BaseResponseStatus;
import com.sns.dongore.feed.model.*;
import com.sns.dongore.photo.PhotoRepo;
import com.sns.dongore.photo.model.Photo;
import com.sns.dongore.sensedata.SensedataRepo;
import com.sns.dongore.sensedata.SensedataService;
import com.sns.dongore.sensedata.model.LocationAvgSenseData;
import com.sns.dongore.sensedata.model.Sensedata;
import com.sns.dongore.user.AppUserRepo;
import com.sns.dongore.user.model.AppUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class FeedService {

    private final FeedRepo feedRepo;
    private final SensedataRepo sensedataRepo;
    private final PhotoRepo photoRepo;
    private final LocationRepo locationRepo;
    private final AppUserRepo userRepo;
    private final SensedataService sensedataService;


    public PostFeedRes createNewFeed(PostFeedReq req, Long sensedata, Long placeId) {
        Long feedId = feedRepo.createNewFeed(req, sensedata, placeId);
        return new PostFeedRes(feedId);
    }

    public boolean isFeedIdExist(Long feedId) {
        return feedRepo.isFeedIdExsit(feedId);
    }


    public GetFeedDetailRes getFeedDetail(Long feedId) {
        Feed feed = feedRepo.findByFeedId(feedId);
        Sensedata sensedata = sensedataRepo.findById(feed.getSensedata());
        Location location = null;
        try {
            location = locationRepo.findById(feed.getLocation());
        }
        catch(Exception e){
            log.info("This feed {} doesn't hvae location", feedId);
        }
        GetFeedDetailRes res = new GetFeedDetailRes(feed, sensedata, location);
        List<Photo> photos = photoRepo.searchByFeedId(feedId);
        for(Photo photo : photos){
            res.getPhotoUrls().add(photo.getUrl());
        }
        return res;

    }

    public SearchFeedRes getFeedAll(Integer pageSize, Integer pageNo) {
        List<Feed> feeds = feedRepo.getFeedAll(pageSize, pageNo);
        List<FeedThumbnail> feedThumbnails = getThumbnailsFromFeed(feeds);
        return new SearchFeedRes(null, feedThumbnails);
    }


    public SearchFeedRes searchFeedByCoordinate(SearchFeedReq req) {
        List<Feed> feeds = feedRepo.searchFeedByCoordinate(req.getEn_latitude(), req.getWs_latitude(),req.getEn_longitude(), req.getWs_longitude());


        // SearchKeyWord로 핸들링
        if(req.getSearchKeyWord() != null && !req.getSearchKeyWord().equals("")){
            feeds.removeIf(feed ->
                !feed.getText().contains(req.getSearchKeyWord()) &&
                !feed.getTitle().contains(req.getSearchKeyWord()));
        }

        Set<Long> locationIds = new HashSet<>();
        for(Feed feed : feeds){
            locationIds.add(feed.getLocation());
        }



        List<FeedThumbnail> feedThumbnails = getThumbnailsFromFeed(feeds);
        List<LocationDetail> locationDetails = getLocationDetailFromIds(locationIds);

        if(req.getDoSenseFilter()) {
            AppUser user = userRepo.findUserById(req.getUserId());
            Sensedata userSense = sensedataService.getById(user.getSensedata());
            feedThumbnails.removeIf(feedThumbnail ->
                    feedThumbnail.getSensedata().isBiggerThan(userSense));
            locationDetails.removeIf(locationDetail ->
                    locationDetail.getSensedata().isBiggerThan(userSense));
        }
        SearchFeedRes res = new SearchFeedRes(locationDetails, feedThumbnails);
        return res;
    }


    public List<LocationDetail> getLocationDetailFromIds(Set<Long> locationIds){
        List<LocationDetail> locationDetails = new ArrayList<>();
        for(Long locationId : locationIds){
            LocationAvgSenseData avgFromLocation = sensedataRepo.getAvgFromLocation(locationId);
            LocationDetail locationDetail = LocationDetail.makeFromLocations(locationRepo.findById(locationId), avgFromLocation);
            locationDetails.add(locationDetail);
        }
        return locationDetails;
    }

    public List<FeedThumbnail> getThumbnailsFromFeed(List<Feed> feeds){
        List<FeedThumbnail> thumbnails = new ArrayList<>();
        for(Feed feed : feeds){
            String writername = userRepo.findUserById(feed.getWriter()).getNickname();
            List<Photo> photos = photoRepo.searchByFeedId(feed.getId());
            String mainphoto = null;
            if(photos.size() > 0)
                mainphoto = photos.get(0).getUrl();
            Sensedata sensedata = sensedataRepo.findById(feed.getSensedata());
            thumbnails.add(new FeedThumbnail(
                    feed.getId(), feed.getWriter(), feed.getTitle(), feed.getText(), writername, mainphoto, sensedata, locationRepo.findById(feed.getLocation())
            ));
        }
        return thumbnails;
    }
}
