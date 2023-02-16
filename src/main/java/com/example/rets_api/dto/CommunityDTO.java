package com.example.rets_api.dto;

import com.example.rets_api.resource.Enums.Indicator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityDTO {

    private String clubHouse;
    private Indicator clubHouseIndicator;

    private String exerciseArea;
    private Indicator exerciseAreaIndicator;

    private String golf;
    private Indicator golfIndicator;

    private String tennis;
    private Indicator tennisIndicator;

    private String recreationalFacilities;
    private Indicator recreationalFacilitiesIndicator;

    private String securityFeatures;
    private Indicator securityFeaturesIndicator;

    private String seniorCommunity;
    private Indicator seniorCommunityIndicator;

    private String hotTub;
    private Indicator hotTubIndicator;

    private String pool;
    private Indicator poolIndicator;

    private String boatFacilities;
    private Indicator boatFacilitiesIndicator;

    private String horseFacilities;
    private Indicator horseFacilitiesIndicator;

    private String communityPark;
    private Indicator communityParkIndicator;
}
