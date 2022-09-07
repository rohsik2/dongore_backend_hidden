package com.sns.dongore.feed.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@ApiModel(value = "Feed 정보", description = "새 피드를 작성하기 위한 Description 입니다.")
public class PostFeedReq {

    @ApiModelProperty(value="appUserId")
    Long writerId;
    String text;
    String title;
    @ApiModelProperty(value="photos[0], photos[1]과 같은 이름으로 multipart-Form에 넣어주세요. 최대 크기는 1048576 byte입니다.")
    MultipartFile[] photos;
    @ApiModelProperty(value="'#안녕 #만나서 #반가워'와 같이 여러 해시태그를 긴 문자열로 넣어주세요.")
    String hashTags;

    Double longitude;
    Double latitude;
    String placeName;
    @ApiModelProperty(value="주소중에 큰거. 경기도/충청북도 등등")
    String city; // 시군구
    @ApiModelProperty(value="주소중에 세부, 수원시/~~동 등등")
    String county; //읍면동


    @ApiModelProperty(value="청각 0이 자극 없음 100이 자극강함. 상관없어 보이는 경우 0을 입력.")
    Float auditory;   // 청각
    @ApiModelProperty(value="시각")
    Float visual;     // 시각
    @ApiModelProperty(value="전정계 - 평형감각, 이동감각")
    Float vestibular; // 전정계 - 평형감각, 이동감각
    @ApiModelProperty(value="촉각")
    Float tactile;    // 촉감
    @ApiModelProperty(value="고유수용감각 - 근육 힘줄 및 관절내에 위치한 기계감각")
    Float proprioceptive; // 고유수용감각 - 근육 힘줄 및 관절내에 위치한 기계감각
    @ApiModelProperty(value="맛, 식감")
    Float oral;       // 맛, 식감
}
