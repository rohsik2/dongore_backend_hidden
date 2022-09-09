package com.sns.dongore.address;

import com.sns.dongore.address.model.PostLocationReq;
import com.sns.dongore.feed.model.PostFeedReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class LocationService {

    private final LocationRepo locationRepo;

    public Long createLocation(PostFeedReq req){
        PostLocationReq pl_req = new PostLocationReq(
                req.getAddress_longitude(),
                req.getAddress_latitude(),
                req.getAddress_placeName(),
                req.getAddress_city(),
                req.getAddress_county(),
                req.getAddress_category()
        );
        return createLocation(pl_req);
    }

    public Long createLocation(PostLocationReq req){
        return locationRepo.createLocation(req);
    }

    public Long findByLatLongPlaceName(Double latitude, Double longitude, String placeName){
        return locationRepo.findByLatLongPlaceName(latitude, longitude, placeName);
    }

    public Boolean isPlaceExist(Double latitude, Double longitude, String placeName){
        return locationRepo.isPlaceExist(latitude, longitude, placeName);
    }
}
