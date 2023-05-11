package com.hkemal.simpleinsuraceapp.service.serviceImpl;

import com.hkemal.simpleinsuraceapp.entity.Campaign;
import com.hkemal.simpleinsuraceapp.repository.CampaignRepository;
import com.hkemal.simpleinsuraceapp.service.dto.CampaignInputDTO;
import com.hkemal.simpleinsuraceapp.service.dto.CampaignResultDTO;
import com.hkemal.simpleinsuraceapp.service.enums.CampaignCategoryEnum;
import com.hkemal.simpleinsuraceapp.service.enums.CampaignStateEnum;
import com.hkemal.simpleinsuraceapp.service.mapper.CampaignMapper;
import com.hkemal.simpleinsuraceapp.service.service.CampaignService;
import com.hkemal.simpleinsuraceapp.service.vm.CampaignInfoVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignMapper campaignMapper;

    @Override
    public CampaignResultDTO save(CampaignInputDTO campaignInputDTO) {
        Campaign campaign = campaignMapper.toEntity(campaignInputDTO);
        this.setCampaignState(campaignInputDTO, campaign);
        campaign = campaignRepository.save(campaign);
        CampaignResultDTO result = campaignMapper.toDto(campaign);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CampaignResultDTO> getAll() {
        List<Campaign> campaigns = campaignRepository.findAll();
        return campaignMapper.toDto(campaigns);
    }

    @Override
    @Transactional(readOnly = true)
    public CampaignResultDTO getOne(Long id) throws Exception {
        Optional<Campaign> campaign = campaignRepository.findById(id);
        if (campaign.isPresent()) {
            return campaignMapper.toDto(campaign.get());
        } else {
            throw new Exception();
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        this.getOne(id);
        campaignRepository.deleteById(id);
    }

    @Override
    public CampaignResultDTO approveCampaign(Long id) throws Exception {
        Optional<Campaign> campaign = campaignRepository.findById(id);
        if (campaign.isPresent()) {
            if (CampaignStateEnum.PENDING.equals(campaign.get().getCampaignState())) {
                campaign.get().setCampaignState(CampaignStateEnum.ACTIVE);
            }
            Campaign updatedCampaign = campaignRepository.save(campaign.get());
            return campaignMapper.toDto(updatedCampaign);
        } else {
            return null;
        }
    }

    @Override
    public CampaignResultDTO deactivateCampaign(Long id) throws Exception {
        Optional<Campaign> campaign = campaignRepository.findById(id);
        if (campaign.isPresent()) {
            if (CampaignStateEnum.PENDING.equals(campaign.get().getCampaignState()) || CampaignStateEnum.ACTIVE.equals(campaign.get().getCampaignState())) {
                campaign.get().setCampaignState(CampaignStateEnum.NOT_ACTIVE);
            }
            Campaign updatedCampaign = campaignRepository.save(campaign.get());
            return campaignMapper.toDto(updatedCampaign);
        } else {
            return null;
        }
    }

    @Override
    public List<CampaignInfoVM> getClassifiedStats() {
        List<CampaignInfoVM> campaignStats = campaignRepository.countByCampaignState();
        return campaignStats;
    }

    private void setCampaignState(CampaignInputDTO campaignInputDTO, Campaign campaign) {
        Optional<Campaign> campaignControl = campaignRepository.findFirstByCampaignCategoryAndNameAndDescription(campaignInputDTO.getCampaignCategory(), campaignInputDTO.getName(), campaignInputDTO.getDescription());
        if (campaignControl.isPresent()) {
            campaign.setCampaignState(CampaignStateEnum.REPETITIVE);
        } else {
            if (campaignInputDTO.getCampaignCategory().equals(CampaignCategoryEnum.HS)) {
                campaign.setCampaignState(CampaignStateEnum.ACTIVE);
            } else {
                campaign.setCampaignState(CampaignStateEnum.PENDING);
            }
        }
    }
}
