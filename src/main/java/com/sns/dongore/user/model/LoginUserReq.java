package com.sns.dongore.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class LoginUserReq {
    String email;
    String password;
}
