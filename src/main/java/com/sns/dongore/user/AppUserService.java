package com.sns.dongore.user;

import com.sns.dongore.user.model.PostUserReq;
import com.sns.dongore.user.model.PostUserRes;
import com.sns.dongore.user.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class AppUserService {

    // connect repository
    private final AppUserRepo appUserRepo;

    public PostUserRes createUser(PostUserReq req) {
        try {
        } catch (Exception e) {
            ;
        }

        Long id = appUserRepo.createUser(req);
        return new PostUserRes(id);
    }

    public Boolean isEmailExist(String email) {
        return appUserRepo.isEmailExist(email);
    }

    public Boolean isNicknameExist(String nickname) {
        return appUserRepo.isNicknameExist(nickname);
    }
}
