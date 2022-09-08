package com.sns.dongore.address;

import com.sns.dongore.address.model.Location;
import com.sns.dongore.feed.model.PostFeedReq;
import org.springframework.stereotype.Repository;

@Repository
public class LocationRepo {

    //TODO : Location 존재 유무 쿼리 작성.
    public Boolean isLocationIdExist(Long id){
        return null;
    }

    //TODO : Location 조회 쿼리 작성
    public Location findById(Long id){
        return null;
    }


    //TODO : Location 생성 쿼리 작성
    public Long createLocation(PostFeedReq req){
        return null;
    }
}
