package com.sns.dongore.feed;

import com.sns.dongore.feed.model.Feed;
import com.sns.dongore.feed.model.PostFeedReq;
import org.springframework.stereotype.Repository;

@Repository
public class FeedRepo {

    // TODO : Make SQLS for Feed
    public Long createNewFeed(PostFeedReq req) {
        return null;
    }

    public Boolean isFeedIdExsit(Long feedId) {
        return null;
    }


    public Feed findByFeedId(Long feedId){
        return null;
    }
}
