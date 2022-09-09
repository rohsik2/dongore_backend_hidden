package com.sns.dongore.feed.model;

import com.sns.dongore.address.model.Location;
import com.sns.dongore.sensedata.model.Sensedata;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class GetFeedDetailRes {
    Long feedId;
    Long writerId;
    String writerName;

    String title;
    String text;

    Date created_at;
    Date updated_at;

    List<String> photoUrls;

    Sensedata sensedata;

    Location location;

    public GetFeedDetailRes(Feed feed, Sensedata sense, Location location){
        this.feedId = feed.getId();
        this.writerId = feed.getWriter();
        this.title = feed.getTitle();
        this.text = feed.getTitle();
        this.created_at = feed.getCreated_at();
        this.updated_at = feed.getUpdated_at();
        this.sensedata = sense;
        this.location = location;
        //해당 부분은 Service에서 채워넣습니다.
        this.photoUrls = new ArrayList<>();
    }

}
