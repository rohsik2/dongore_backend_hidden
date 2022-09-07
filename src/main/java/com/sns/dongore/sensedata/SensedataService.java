package com.sns.dongore.sensedata;

import com.sns.dongore.feed.model.PostFeedReq;
import com.sns.dongore.sensedata.model.Sensedata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class SensedataService {
    private final SensedataRepo sensedataRepo;

    public Long createSensedata(PostFeedReq req) {
        return sensedataRepo.createSensedata(req);
    }
}
