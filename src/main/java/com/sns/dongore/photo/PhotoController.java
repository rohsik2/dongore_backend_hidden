package com.sns.dongore.photo;

import com.sns.dongore.exceptions.BaseResponse;
import com.sns.dongore.exceptions.BaseResponseStatus;
import com.sns.dongore.photo.model.PostPhotosReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController @RequestMapping("/api/photo") @AllArgsConstructor
@Api(description = "This is test api for bucketeer (AWS S3)")
public class PhotoController {

    private final PhotoService photoService;
    private final AmazonService amazonService;

    @GetMapping(value = "{photoId}")
    BaseResponse<?> getPhotoById(@PathVariable Long photoId){
        if(!photoService.isPhotoExist(photoId)){
            return new BaseResponse<>(BaseResponseStatus.PHOTO_ID_NOT_EXIST);
        }
        return new BaseResponse<>(photoService.findPhotoById(photoId));
    }

    @PostMapping(value = "")
    BaseResponse<?> photoUploadTest(MultipartFile photo){
        return new BaseResponse<>(amazonService.uploadImageToAWSS3(photo));
    }

    @PostMapping(value = "/several")
    BaseResponse<?> photoUploadTest(@RequestParam List<MultipartFile> req){

        return new BaseResponse<>(amazonService.uploadImageToAWSS3(req.get(0)));
    }
}
