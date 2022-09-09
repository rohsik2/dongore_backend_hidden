package com.sns.dongore.sensedata.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sensedata {
    Long id;
    Short auditory;
    Short visual;
    Short vestibular;
    Short tactile;
    Short proprioceptive;
    Short oral;

    public boolean isBiggerThan(Sensedata other){
        return this.auditory > other.auditory &&
                this.visual > other.visual &&
                this.vestibular > other.vestibular &&
                this.tactile > other.tactile &&
                this.proprioceptive > other.proprioceptive &&
                this.oral > other.oral;
    }
}
