package com.sns.dongore.address;

import com.sns.dongore.exceptions.BaseResponse;
import com.sns.dongore.exceptions.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequiredArgsConstructor @RequestMapping(value = "/api/location")
public class LocationController {
    private final LocationRepo locationRepo;

    @GetMapping("/{locationId}")
    public BaseResponse<?> getLocationById(@PathVariable Long locationId){
        if(locationRepo.isLocationIdExist(locationId)){
            return new BaseResponse<>(BaseResponseStatus.LOCATION_ID_NOT_FOUND);
        }
        return new BaseResponse<>(locationRepo.findById(locationId));
    }

}
