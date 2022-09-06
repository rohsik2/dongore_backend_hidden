package com.sns.dongore.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data @AllArgsConstructor
public class GetUserRes {
    String nickname;
    String email;
    String username;
    Date birthday;
    String type;

}
