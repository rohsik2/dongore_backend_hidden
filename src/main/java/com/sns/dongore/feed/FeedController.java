package com.sns.dongore.feed;

import com.sns.dongore.exceptions.BaseResponse;
import com.sns.dongore.exceptions.BaseResponseStatus;
import com.sns.dongore.feed.model.GetFeedDetailRes;
import com.sns.dongore.feed.model.PostFeedReq;
import com.sns.dongore.feed.model.PostFeedRes;
import com.sns.dongore.feed.model.SearchFeedRes;
import com.sns.dongore.photo.PhotoService;
import com.sns.dongore.user.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController @RequestMapping(value = "/api/feed") @RequiredArgsConstructor @Slf4j
public class FeedController {
    private final AppUserService userService;
    private final PhotoService photoService;
    private final FeedService feedService;

    @PostMapping("")
    BaseResponse<?> createNewFeed(PostFeedReq req){
        if(!userService.isIdExist(req.getWriterId()))
            return new BaseResponse<>(BaseResponseStatus.USER_NOT_FOUND);

        PostFeedRes res = feedService.createNewFeed(req);
        try {
            for (MultipartFile photo : req.getPhotos()) {
                photoService.createPhoto(photo, res.getFeedId());
            }
        }
        catch(Exception e){
            log.error("Error while uploading photo", e.getMessage());
            return new BaseResponse<>(BaseResponseStatus.PHOTO_UPLOAD_FAIL);
        }
        return new BaseResponse<>(res);
    }

    @GetMapping(value = "/detail/{:feedId}")
    BaseResponse<?> getFeedDetail(@PathVariable Long feedId){
        if(!feedService.isFeedIdExist(feedId)){
            return new BaseResponse<>(BaseResponseStatus.FEED_NOT_FOUND);
        }
        GetFeedDetailRes res = feedService.getFeedDetail(feedId);
        return new BaseResponse<>(res);
    }

    @GetMapping(value = "")
    BaseResponse<?> getFeeds(@RequestParam(required = false) Integer pageSize, @RequestParam(required = false) Integer pageNo){
        if(pageSize == null)
            pageSize = 15;
        if(pageNo == null)
            pageNo = 0;
        SearchFeedRes res = feedService.getFeedAll(pageSize, pageNo);
        return new BaseResponse<>(res);
    }

}
