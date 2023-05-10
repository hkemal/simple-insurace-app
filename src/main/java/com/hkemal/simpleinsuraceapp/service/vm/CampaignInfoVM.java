package com.hkemal.simpleinsuraceapp.service.vm;

import com.hkemal.simpleinsuraceapp.service.enums.CampaignStateEnum;

public interface CampaignInfoVM {

    Long getCount();

    CampaignStateEnum getCampaignState();
}
