package com.hkemal.simpleinsuraceapp.service.dto;

import com.hkemal.simpleinsuraceapp.service.enums.CampaignCategoryEnum;
import com.hkemal.simpleinsuraceapp.service.enums.CampaignStateEnum;

public class CampaignResultDTO {

    private Long id;

    private String name;

    private String description;

    private CampaignCategoryEnum campaignCategory;

    private CampaignStateEnum campaignState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CampaignCategoryEnum getCampaignCategory() {
        return campaignCategory;
    }

    public void setCampaignCategory(CampaignCategoryEnum campaignCategory) {
        this.campaignCategory = campaignCategory;
    }

    public CampaignStateEnum getCampaignState() {
        return campaignState;
    }

    public void setCampaignState(CampaignStateEnum campaignState) {
        this.campaignState = campaignState;
    }
}
