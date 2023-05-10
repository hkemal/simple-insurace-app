package com.hkemal.simpleinsuraceapp.entity;

import com.hkemal.simpleinsuraceapp.service.enums.CampaignCategoryEnum;
import com.hkemal.simpleinsuraceapp.service.enums.CampaignStateEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "campaign")
public class Campaign implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 10, max = 50)
    @Column(unique = true, name = "name")
    @Pattern(regexp = "^\\d\\w*$", message = "must be start number")
    private String name;

    @NotNull
    @Size(min = 20, max = 200)
    @Column(name = "description")
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "campaign_category")
    private CampaignCategoryEnum campaignCategory;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "campaign_state")
    private CampaignStateEnum campaignState;

    public Campaign() {
    }

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
