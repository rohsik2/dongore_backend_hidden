package com.sns.dongore.user;


import com.sns.dongore.exceptions.BaseResponse;
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
        PostUserRes res = new PostUserRes();
        return new BaseResponse<>(res);
    }
}
