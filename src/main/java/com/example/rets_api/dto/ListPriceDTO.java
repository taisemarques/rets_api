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
public class ListPriceDTO {

    private NumberType lowAmount;
    private NumberType highAmount;
    private String currencyCode;
    private AreaUnit units;
}
