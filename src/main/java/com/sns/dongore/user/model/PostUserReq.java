package com.sns.dongore.user.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data @AllArgsConstructor
public class PostUserReq {
    String username;
    String nickname;
    String email;
    String password;
    Date birthday = new Date();
    String type = "Disabled";
    String city;
    String county;

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

// DTO - DAta Transfer Object
