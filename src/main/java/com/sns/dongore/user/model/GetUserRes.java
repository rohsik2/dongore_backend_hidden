package com.sns.dongore.user.model;

import com.sns.dongore.sensedata.model.Sensedata;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data @AllArgsConstructor
public class GetUserRes {
    Long userId;
    String nickname;
    String email;
    String username;
    Date birthday;
    String type;
    Sensedata userSense;
}
