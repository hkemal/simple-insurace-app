package com.hkemal.simpleinsuraceapp.service.dto;

import com.hkemal.simpleinsuraceapp.service.enums.CampaignCategoryEnum;
import com.hkemal.simpleinsuraceapp.service.enums.CampaignStateEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CampaignInputDTO {
    @NotNull
    @Size(min = 10, max = 50)
    @Column(unique = true)
    @Pattern(regexp = "^2567[78].*$", message = "must be start number")
    private String name;

    @NotNull
    @Size(min = 20, max = 200)
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CampaignCategoryEnum campaignCategory;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CampaignStateEnum campaignState;

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
