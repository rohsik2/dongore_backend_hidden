package com.sns.dongore.address;

import com.sns.dongore.address.model.Location;
import com.sns.dongore.address.model.PostLocationReq;
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
    public Long createLocation(PostLocationReq req){
        return null;
    }

    //TODO : Location 검색 쿼리 작성.
    public Long findByLatLongPlaceName(Double latitude, Double longitude, String placeName) {
        return null;
    }

    //TODO : lat+long+placeName은 Unique Index임. 해당 장소의 존재 여부를 리턴 하는 쿼리 작성.
    public Boolean isPlaceExist(Double latitude, Double longitude, String placeName){
        return null;
    }
}
