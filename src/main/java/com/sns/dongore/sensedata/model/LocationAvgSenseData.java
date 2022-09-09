package com.sns.dongore.sensedata.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class LocationAvgSenseData {
    Long locationId;
    Short auditory;
    Short visual;
    Short vestibular;
    Short tactile;
    Short proprioceptive;
    Short oral;
}
