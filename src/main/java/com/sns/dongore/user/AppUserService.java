package com.sns.dongore.user;

import com.sns.dongore.feed.model.PostFeedReq;
import com.sns.dongore.sensedata.SensedataRepo;
import com.sns.dongore.sensedata.SensedataService;
import com.sns.dongore.user.model.GetUserRes;
import com.sns.dongore.user.model.PostUserReq;
import com.sns.dongore.user.model.PostUserRes;
import com.sns.dongore.user.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class AppUserService {

    // connect repository
    private final AppUserRepo appUserRepo;
    private final SensedataRepo sensedataRepo;


    public PostUserRes createUser(PostUserReq req) {
        Long senseId = sensedataRepo.createSensedata(req);
        Long id = appUserRepo.createUser(req, senseId);
        return new PostUserRes(id);
    }

    public Boolean isEmailExist(String email) {
        return appUserRepo.isEmailExist(email);
    }

    public Boolean isNicknameExist(String nickname) {
        return appUserRepo.isNicknameExist(nickname);
    }

    public boolean isIdExist(Long appUserId) {
        return appUserRepo.isIdExist(appUserId);
    }

    public GetUserRes findUserById(Long appUserId) {
        AppUser temp = appUserRepo.findUserById(appUserId);
        return new GetUserRes(temp.getNickname(), temp.getEmail(), temp.getUsername(), temp.getBirth(), temp.getType());
    }

    public AppUser findUserByEmail(String email) {
        AppUser user = appUserRepo.findUserByEmail(email);
        return user;
    }
}
