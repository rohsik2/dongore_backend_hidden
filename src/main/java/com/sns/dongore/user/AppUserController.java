package com.sns.dongore.user;


import com.sns.dongore.exceptions.BaseResponse;
import com.sns.dongore.exceptions.BaseResponseStatus;
import com.sns.dongore.user.model.AppUser;
import com.sns.dongore.user.model.PostUserReq;
import com.sns.dongore.user.model.PostUserRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/user") @RequiredArgsConstructor
public class AppUserController {

    private final AppUserService service;

    // GEt POST Patch Delete
    // Read Create Update Delte

    // Restful Api
    // 명사에 해당하는거. <- URL
    // 동사에 해당하는거. <- HttpMethod

    //Controller는 Req의 형태를 정하고, validation -> Service
    @RequestMapping(value = "", method = RequestMethod.POST)
    BaseResponse<?> createUser(PostUserReq req){

        // Email Validation
        if(!AppUserUtility.isValidEmail(req.getEmail()))
            return new BaseResponse<>(BaseResponseStatus.EMAIL_TYPE_WRONG);
        if(service.isEmailExist(req.getEmail()))
            return new BaseResponse<>(BaseResponseStatus.EMAIL_DUPLICATED);

        // nickname Validation
        if(service.isNicknameExist(req.getNickname()))
            return new BaseResponse<>(BaseResponseStatus.NICKNAME_EXIST);

        // Password Validation
        if(!AppUserUtility.isValidPassword(req.getPassword()))
            return new BaseResponse<>(BaseResponseStatus.PASSWORD_TYPE_WRONG);

        PostUserRes res = service.createUser(req);
        return new BaseResponse<>(res);
    }
}
