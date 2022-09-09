package com.sns.dongore.address.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data @AllArgsConstructor
public class PostLocationReq {
    Double longitude;
    Double latitude;
    String placeName;
    String city;
    String county;
    String category;
}
