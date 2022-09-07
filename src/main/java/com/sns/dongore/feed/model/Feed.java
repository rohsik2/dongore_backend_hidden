package com.sns.dongore.feed.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data @AllArgsConstructor
public class Feed {
    Long id;
    Long writer;
    Date created_at;
    Date updated_at;
    Short status;
    String text;
    String title;
    Long sensedata;
    Long location;
}
