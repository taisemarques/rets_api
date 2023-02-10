package com.example.rets_api.dto;

import com.example.rets_api.resource.Enums;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LotDataDTO {

    private String CornerLot;
    private Enums.Indicator CornerLotIndicator;

    private String CuldeSac;
    private Enums.Indicator CuldeSacIndicator;

    private String GolfCourseLot;
    private Enums.Indicator GolfCourseLotIndicator;
}
