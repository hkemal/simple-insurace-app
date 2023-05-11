package com.hkemal.simpleinsuraceapp.repository;

import com.hkemal.simpleinsuraceapp.entity.Campaign;
import com.hkemal.simpleinsuraceapp.service.enums.CampaignCategoryEnum;
import com.hkemal.simpleinsuraceapp.service.vm.CampaignInfoVM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    Optional<Campaign> findFirstByCampaignCategoryAndNameAndDescription(CampaignCategoryEnum campaignCategory, String name, String description);

    @Query("select " +
            " count(C.id) as count," +
            " C.campaignState as campaignState " +
            " from  Campaign as C" +
            " group by C.campaignState")
    List<CampaignInfoVM> countByCampaignState();
}
