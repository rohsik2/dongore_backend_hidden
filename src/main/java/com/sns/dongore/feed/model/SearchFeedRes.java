package com.sns.dongore.feed.model;

import com.sns.dongore.address.model.LocationDetail;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data @AllArgsConstructor
public class SearchFeedRes {
    List<LocationDetail> locations;
    List<FeedThumbnail> feedThumbnails;
}
