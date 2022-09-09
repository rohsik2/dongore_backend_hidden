package com.sns.dongore.address.model;

import com.sns.dongore.sensedata.model.LocationAvgSenseData;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class LocationDetail {
    Double longitude;
    Double latitude;
    String placeName;
    String city;
    String county;
    String category;
    Date updated_at;
    Date created_at;

    Short auditory;
    Short visual;
    Short vestibular;
    Short tactile;
    Short proprioceptive;
    Short oral;

    private LocationDetail(Location location, Short auditory, Short visual, Short vestibular, Short tactile, Short proprioceptive, Short oral){
        this.longitude = location.longitude;
        this.latitude = location.latitude;
        this.placeName = location.placeName;
        this.city = location.city;
        this.county = location.county;
        this.category = location.category;
        this.updated_at = location.updated_at;
        this.created_at = location.created_at;

        this.auditory = auditory;
        this.visual = visual;
        this.vestibular = vestibular;
        this.tactile = tactile;
        this.proprioceptive = proprioceptive;
        this.oral = oral;
    }

    public static LocationDetail makeFromLocations(Location location, LocationAvgSenseData avgFromLocation){
        return new LocationDetail(location, avgFromLocation.getAuditory(),
                avgFromLocation.getVisual(),
                avgFromLocation.getVestibular(),
                avgFromLocation.getTactile(),
                avgFromLocation.getProprioceptive(),
                avgFromLocation.getOral());
    }


}

