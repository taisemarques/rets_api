package com.example.rets_api.dto;

import com.example.rets_api.resource.Enums.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LotDataDTO {

    private String cornerLot;
    private Indicator cornerLotIndicator;

    private String culdeSac;
    private Indicator culdeSacIndicator;

    private String golfCourseLot;
    private Indicator golfCourseLotIndicator;
}
