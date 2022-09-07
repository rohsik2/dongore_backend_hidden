package com.sns.dongore.feed;

import com.sns.dongore.feed.model.*;
import com.sns.dongore.photo.PhotoRepo;
import com.sns.dongore.photo.model.Photo;
import com.sns.dongore.sensedata.SensedataRepo;
import com.sns.dongore.sensedata.model.Sensedata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional
public class FeedService {

    private final FeedRepo feedRepo;
    private final SensedataRepo sensedataRepo;
    private final PhotoRepo photoRepo;

    public PostFeedRes createNewFeed(PostFeedReq req) {
        Long feedId = feedRepo.createNewFeed(req);
        return new PostFeedRes(feedId);
    }

    public boolean isFeedIdExist(Long feedId) {
        return feedRepo.isFeedIdExsit(feedId);
    }


    //TODO : 성능 문제가 있을경우 아래 동작을 하나의 쿼리로 만들면 됨. subquery사용해서 ㅋ.
    public GetFeedDetailRes getFeedDetail(Long feedId) {
        Feed feed = feedRepo.findByFeedId(feedId);
        Sensedata sensedata = sensedataRepo.findById(feed.getSensedata());
        GetFeedDetailRes res = new GetFeedDetailRes(feed, sensedata);
        List<Photo> photos = photoRepo.searchByFeedId(feedId);
        for(Photo photo : photos){
            res.getPhotoUrls().add(photo.getUrl());
        }
        return res;

    }

    //TODO : 여기서부터
    public SearchFeedRes getFeedAll(Integer pageSize, Integer pageNo) {
        return null;
    }
}
