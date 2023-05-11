package com.hkemal.simpleinsuraceapp.service.service;

import com.hkemal.simpleinsuraceapp.service.dto.CampaignInputDTO;
import com.hkemal.simpleinsuraceapp.service.dto.CampaignResultDTO;
import com.hkemal.simpleinsuraceapp.service.vm.CampaignInfoVM;

import java.util.List;

public interface CampaignService {

    CampaignResultDTO save(CampaignInputDTO campaignInputDTO);

    List<CampaignResultDTO> getAll();

    CampaignResultDTO getOne(Long id) throws Exception;

    void delete(Long id) throws Exception;

    CampaignResultDTO approveCampaign(Long id) throws Exception;

    CampaignResultDTO deactivateCampaign(Long id) throws Exception;

    List<CampaignInfoVM> getClassifiedStats();
}
