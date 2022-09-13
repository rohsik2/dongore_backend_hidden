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
    @ApiModelProperty(value="사용안함 지금은, 비워두세요.", example = "")
    Date birthday;

    @ApiModelProperty(value="disabled, guardian, teacher, etc 중에서 하나를 입력하세요.")
    String type;
    String city;
    String county;

    @ApiModelProperty(value="청각의 역치 0 = 버티기 힘들어함. 100 = 굉장히 잘 버팀.", example="100")
    Short sense_auditory;
    @ApiModelProperty(value="시각 ", example="100")
    Short sense_visual;
    @ApiModelProperty(value="전정계 - 평형감각, 이동감각", example="100")
    Short sense_vestibular;
    @ApiModelProperty(value="촉각", example="100")
    Short sense_tactile;
    @ApiModelProperty(value="고유수용감각 - 근육 힘줄 및 관절내에 위치한 기계감각", example="100")
    Short sense_proprioceptive;
    @ApiModelProperty(value="맛, 식감", example="100")
    Short sense_oral;
}

// DTO - DAta Transfer Object
