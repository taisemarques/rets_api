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
public class ListingPriceDTO {

    private Long lowAmount;
    private Long highAmount;
    private NumberType lowAmountType;
    private NumberType highAmountType;
    private String lowAmountCurrencyCode;
    private String highAmountCurrencyCode;
    private AreaUnit units;
}
