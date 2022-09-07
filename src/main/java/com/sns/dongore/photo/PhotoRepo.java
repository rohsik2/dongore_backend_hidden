package com.sns.dongore.photo;

import com.sns.dongore.photo.model.Photo;
import org.springframework.stereotype.Repository;

@Repository
public class PhotoRepo {



    //TODO : sql 작성해서 담기. 리턴은 사진 id
    public Long createPhoto(String url, Long feed){
        return null;
    }

    //TODO : sql 작성해서 담기.
    public Photo findPhotoById(Long photoId){
        return null;
    }

    public Boolean isPhotoIdExist(Long photoId){
        return null;
    }
}
