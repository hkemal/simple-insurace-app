package com.hkemal.simpleinsuraceapp.service.dto;

import com.hkemal.simpleinsuraceapp.service.enums.CampaignCategoryEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CampaignInputDTO implements Serializable {

    @NotNull
    @Size(min = 10, max = 50)
    @Column(unique = true)
    @Pattern(regexp = "^\\d\\w*$", message = "must be start number")
    private String name;

    @NotNull
    @Size(min = 20, max = 200)
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CampaignCategoryEnum campaignCategory;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CampaignInputDTO)) return false;

        CampaignInputDTO that = (CampaignInputDTO) o;

        if (!getName().equals(that.getName())) return false;
        if (!getDescription().equals(that.getDescription())) return false;
        return getCampaignCategory() == that.getCampaignCategory();
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getCampaignCategory().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CampaignInputDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", campaignCategory=" + campaignCategory +
                '}';
    }
}
