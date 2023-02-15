package com.example.rets_api.dto;

import com.example.rets_api.resource.Enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialDataDTO {

    private String leaseOption;

    private Indicator leaseIndicator;

    private String tradeOption;

    private Indicator tradeIndicator;

    private Long rentalAmount;

    private NumberType rentalAmountType;

    private String rentalAmountCurrencyCode;

    private RentalPeriod rentalAmountPeriod;

    private AreaUnit rentalAmountUnit;

}
