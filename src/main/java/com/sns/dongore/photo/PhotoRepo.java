package com.sns.dongore.photo;

import com.sns.dongore.photo.model.Photo;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Photo> searchByFeedId(Long feedId) {
        return null;
    }
}
