package com.sns.dongore.feed.model;

import com.sns.dongore.address.model.Location;
import com.sns.dongore.sensedata.model.Sensedata;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class FeedThumbnail {

    Long feedId;
    Long writerId;

    String title;
    String text;
    String writer;
    String mainPhoto;

    Sensedata sensedata;
    Location location;

}
