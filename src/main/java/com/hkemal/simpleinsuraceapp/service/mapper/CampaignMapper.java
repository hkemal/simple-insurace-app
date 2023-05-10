package com.hkemal.simpleinsuraceapp.service.mapper;

import com.hkemal.simpleinsuraceapp.entity.Campaign;
import com.hkemal.simpleinsuraceapp.service.dto.CampaignInputDTO;
import com.hkemal.simpleinsuraceapp.service.dto.CampaignResultDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CampaignMapper extends EntityMapper<CampaignResultDTO, Campaign> {

    CampaignResultDTO toDto(Campaign campaign);

    Campaign toEntity(CampaignInputDTO campaignInput);

    default Campaign fromId(Long id) {
        if (id == null) {
            return null;
        }
        Campaign country = new Campaign();
        country.setId(id);
        return country;
    }
}
