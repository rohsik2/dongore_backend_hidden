package com.sns.dongore.feed.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class PostFeedRes {
    Long feedId;
    String url;

    public PostFeedRes(Long feedId){
        this.feedId = feedId;
        this.url = "/api/feed/detail/" + String.valueOf(feedId);
    }
}
