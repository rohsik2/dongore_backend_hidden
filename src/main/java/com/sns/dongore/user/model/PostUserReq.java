package com.sns.dongore.user.model;


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

}

// DTO - DAta Transfer Object
