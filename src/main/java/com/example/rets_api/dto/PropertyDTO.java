package com.example.rets_api.dto;

import com.example.rets_api.resource.Enums.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PropertyDTO {

    private int age;

    private String horseFacilities;

    private Indicator horseFacilitiesIndicator;

    private String hotTub;

    private Indicator hotTubIndicator;

    private String tennisCourt;

    private Indicator tennisCourtIndicator;

    private String inclusions;

    private String energyInformation;

    private String constructionMaterial;

    private String disabilityFeatures;

    private Indicator disabilityFeaturesIndicator;

    private String securityFeatures;

    private Indicator securityFeaturesIndicator;

    private Boolean propertyTypeRental;

    private Boolean propertyTypeFarm;

    private Boolean propertyTypeCondo;

    private Boolean propertyTypeTownHouse;

    private FinancialDataDTO financialData;

    private List<SchoolDTO> schoolList;

    private List<RoomDTO> roomList;

    private AnimalPolicyDTO animalPolicy;

    private List<CommunityDTO> communityDTOList;

    private LotDataDTO lotData;

}
