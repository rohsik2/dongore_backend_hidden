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
            AppUser user = appUserRepo.getUserByEmail(req.getEmail());
        } catch (Exception e) {
            ;
        }

        Long id = appUserRepo.createUser(req);
        return new PostUserRes(id);
    }


    // 이메일 중복검사
    // 닉네임 중복검사
    // 새로운 유저를 만드세요!
}
