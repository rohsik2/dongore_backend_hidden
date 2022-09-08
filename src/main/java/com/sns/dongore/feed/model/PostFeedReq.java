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

    @ApiModelProperty(value="appUserId", example="0")
    Long writerId; // 2
    String text;   // 제목
    String title;  // 내용
    @ApiModelProperty(value="photos[0], photos[1]과 같은 이름으로 multipart/form-data에 넣어주세요. 최대 크기는 1048576 byte입니다.")
    MultipartFile[] photos; // 해당파트는 swagger에서는 잘 동작하지 않습니다.
    @ApiModelProperty(value="'#안녕 #만나서 #반가워'와 같이 여러 해시태그를 긴 문자열로 넣어주세요.")
    String hashTags; // #안녕 #만나서 #반가워

    Double address_longitude; //37.2401809,
    Double address_latitude;  //127.0770545
    String address_placeName; //대학교 정문
    @ApiModelProperty(value="주소중에 큰거. 경기도/충청북도 등등")
    String address_city;
    @ApiModelProperty(value="주소중에 세부, 수원시/~~동 등등")
    String address_county;


    @ApiModelProperty(value="청각 0이 자극 없음 100이 자극강함. 상관없어 보이는 경우 0을 입력.", example="0")
     Short sense_auditory;
    @ApiModelProperty(value="시각", example="0")
     Short sense_visual;
    @ApiModelProperty(value="전정계 - 평형감각, 이동감각", example="0")
     Short sense_vestibular;
    @ApiModelProperty(value="촉각", example="0")
     Short sense_tactile;
    @ApiModelProperty(value="고유수용감각 - 근육 힘줄 및 관절내에 위치한 기계감각", example="0")
     Short sense_proprioceptive;
    @ApiModelProperty(value="맛, 식감", example="0")
     Short sense_oral;
}
