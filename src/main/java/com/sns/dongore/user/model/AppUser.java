package com.sns.dongore.user.model;


// Entity -> Table을 그대로 옮겨놓은거.

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.experimental.theories.DataPoints;

import java.sql.Date;

// DTO
@Data
@AllArgsConstructor
public class AppUser {
    Long id;
    String username;
    String password;
    String email;
    Date birth;
    String nickname;
    Long role;
    Date created_at;
    Date updated_at;
    Integer status;
    String type;
    String county;
    String city;

}
