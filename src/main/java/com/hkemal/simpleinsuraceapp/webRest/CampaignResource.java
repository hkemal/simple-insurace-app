package com.hkemal.simpleinsuraceapp.webRest;

import com.hkemal.simpleinsuraceapp.service.dto.CampaignInputDTO;
import com.hkemal.simpleinsuraceapp.service.dto.CampaignResultDTO;
import com.hkemal.simpleinsuraceapp.service.service.CampaignService;
import com.hkemal.simpleinsuraceapp.service.vm.CampaignInfoVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CampaignResource {

    private final Logger log = LoggerFactory.getLogger(CampaignResource.class);

    @Autowired
    CampaignService campaignService;

    @PostMapping("/campaigns")
    public ResponseEntity<CampaignResultDTO> createCampaign(@Valid @RequestBody CampaignInputDTO campaignInputDTO) throws URISyntaxException {
        log.debug("REST request to save Campaign : {}", campaignInputDTO);
        CampaignResultDTO result = (CampaignResultDTO) campaignService.save(campaignInputDTO);
        return ResponseEntity.created(new URI("/api/campaigns/" + result.getId()))
                .body(result);
    }

    @PatchMapping("/campaigns/{id}/approve")
    public ResponseEntity<CampaignResultDTO> patchUpdateApproveCampaign(@PathVariable Long id) throws Exception {
        log.debug("REST request to patch update to approve campaign : {}", id);
        CampaignResultDTO result = (CampaignResultDTO) campaignService.approveCampaign(id);
        return ResponseEntity.ok().body(result);
    }

    @PatchMapping("/campaigns/{id}/deactivate")
    public ResponseEntity<CampaignResultDTO> patchUpdateDeactivateCampaign(@PathVariable Long id) throws Exception {
        log.debug("REST request to patch update to deactivate campaign : {}", id);
        CampaignResultDTO result = (CampaignResultDTO) campaignService.deactivateCampaign(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/campaigns/classified-stats")
    public ResponseEntity<List<CampaignInfoVM>> getClassifiedStats() throws Exception {
        log.debug("REST request to patch update to approve campaign : {}");
        List<CampaignInfoVM> results = campaignService.getClassifiedStats();
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/campaigns")
    public ResponseEntity<List<CampaignResultDTO>> getAllCampaigns() throws URISyntaxException {
        log.debug("REST request to get all Campaigns");
        List<CampaignResultDTO> results = (List<CampaignResultDTO>) campaignService.getAll();
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/campaigns/{id}")
    public ResponseEntity<CampaignResultDTO> getOneCampaign(@PathVariable Long id) throws Exception {
        log.debug("REST request to get all Campaigns");
        CampaignResultDTO result = (CampaignResultDTO) campaignService.getOne(id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/campaigns/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) throws Exception {
        campaignService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
