package com.hkemal.simpleinsuraceapp.service.service;

import com.hkemal.simpleinsuraceapp.service.dto.CampaignInputDTO;
import com.hkemal.simpleinsuraceapp.service.dto.CampaignResultDTO;

import java.util.List;

public interface CampaignService extends SimpleCrudService<CampaignInputDTO, CampaignResultDTO> {
    List<CampaignResultDTO> getAll();

    CampaignResultDTO getOne(Long id) throws Exception;

    void delete(Long id) throws Exception;
}
