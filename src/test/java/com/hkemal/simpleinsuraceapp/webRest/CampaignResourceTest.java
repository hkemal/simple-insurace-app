package com.hkemal.simpleinsuraceapp.webRest;

import com.hkemal.simpleinsuraceapp.entity.Campaign;
import com.hkemal.simpleinsuraceapp.repository.CampaignRepository;
import com.hkemal.simpleinsuraceapp.service.dto.CampaignResultDTO;
import com.hkemal.simpleinsuraceapp.service.enums.CampaignCategoryEnum;
import com.hkemal.simpleinsuraceapp.service.enums.CampaignStateEnum;
import com.hkemal.simpleinsuraceapp.service.mapper.CampaignMapper;
import com.hkemal.simpleinsuraceapp.service.serviceImpl.CampaignServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CampaignResourceTest {

    @Mock
    private CampaignMapper campaignMapper;

    @Mock
    private CampaignRepository campaignRepository;

    @InjectMocks
    private CampaignServiceImpl campaignService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        Campaign campaign1 = new Campaign();
        campaign1.setId(12345L);
        campaign1.setName("1-Test Name");
        campaign1.setDescription("1-Test Description qwerty");
        campaign1.setCampaignCategory(CampaignCategoryEnum.OSS);
        campaign1.setCampaignState(CampaignStateEnum.ACTIVE);
        Campaign campaign2 = new Campaign();
        campaign2.setId(22345L);
        campaign2.setName("2-Test Name");
        campaign2.setDescription("2-Test Description qwerty");
        campaign2.setCampaignCategory(CampaignCategoryEnum.OSS);
        campaign2.setCampaignState(CampaignStateEnum.ACTIVE);
        List<Campaign> campaignList = Arrays.asList(campaign1, campaign2);
        when(campaignRepository.findAll()).thenReturn(campaignList);

        CampaignResultDTO resultDTO1 = new CampaignResultDTO();
        CampaignResultDTO resultDTO2 = new CampaignResultDTO();
        List<CampaignResultDTO> expectedResult = Arrays.asList(resultDTO1, resultDTO2);
        when(campaignMapper.toDto(campaignList)).thenReturn(expectedResult);

        List<CampaignResultDTO> actualResult = campaignService.getAll();
        verify(campaignRepository).findAll();
        verify(campaignMapper).toDto(campaignList);
        assertEquals(expectedResult, actualResult);
    }
}
