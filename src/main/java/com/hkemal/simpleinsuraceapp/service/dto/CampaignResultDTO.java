package com.hkemal.simpleinsuraceapp.service.dto;

import com.hkemal.simpleinsuraceapp.service.enums.CampaignCategoryEnum;
import com.hkemal.simpleinsuraceapp.service.enums.CampaignStateEnum;

import java.io.Serializable;

public class CampaignResultDTO implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CampaignResultDTO)) return false;

        CampaignResultDTO that = (CampaignResultDTO) o;

        if (!getId().equals(that.getId())) return false;
        if (!getName().equals(that.getName())) return false;
        if (!getDescription().equals(that.getDescription())) return false;
        if (getCampaignCategory() != that.getCampaignCategory()) return false;
        return getCampaignState() == that.getCampaignState();
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getCampaignCategory().hashCode();
        result = 31 * result + getCampaignState().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CampaignResultDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", campaignCategory=" + campaignCategory +
                ", campaignState=" + campaignState +
                '}';
    }
}
