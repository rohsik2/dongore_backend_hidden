package com.sns.dongore.feed.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

// 아래 클래스는 검색기능 요청을 위한 DTO 클래스 입니다.
@Data @AllArgsConstructor
public class SearchFeedReq {
    String searchKeyWord;
    Long userId;
    Boolean doSenseFilter;
    String hashTag;


    @ApiModelProperty(value="bottom" , example = "0")
    Double ws_latitude;//좌하귀 위도
    @ApiModelProperty(value="left", example = "0")
    Double ws_longitude;//좌하귀 경도

    @ApiModelProperty(value="top", example = "100")
    Double en_latitude;//우상귀 위도
    @ApiModelProperty(value="right", example = "100")
    Double en_longitude;//우상귀 경도
}
