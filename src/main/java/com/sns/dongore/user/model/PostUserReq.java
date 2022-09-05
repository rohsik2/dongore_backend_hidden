package com.sns.dongore.user.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data @AllArgsConstructor
public class PostUserReq {
    String username;
    String email;
    String password;
    Date birthday;
    String type;
}

// DTO - DAta Transfer Object
