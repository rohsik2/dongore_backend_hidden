package com.sns.dongore.photo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Photo {
    Long id;
    String url;
    Long feed;
    Date created_at;
}
