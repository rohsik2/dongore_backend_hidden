package com.sns.dongore.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class LoginUserRes {
    Long appUserId;
    String access_token;
    String refresh_token;
}
