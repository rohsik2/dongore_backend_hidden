package com.sns.dongore.photo;

import com.sns.dongore.photo.model.Photo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service @AllArgsConstructor @Slf4j
public class PhotoService {

    private final PhotoRepo photoRepo;
    private final AmazonService amazonService;

    public Long createPhoto(MultipartFile photo, Long feedId){
        String url = amazonService.uploadImageToAWSS3(photo);
        return photoRepo.createPhoto(url, feedId);
    }

    public Photo findPhotoById(Long photoId){
        return photoRepo.findPhotoById(photoId);
    }

    public Boolean isPhotoExist(Long photoId){
        return photoRepo.isPhotoIdExist(photoId);
    }
}
