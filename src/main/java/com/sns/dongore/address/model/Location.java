package com.sns.dongore.address.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data @AllArgsConstructor
public class Location {
    Double longitude;
    Double latitude;
    String placeName;
    String city;
    String county;
    String category;
    Date updated_at;
    Date created_at;
}
