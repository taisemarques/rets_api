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
public class AnimalPolicyDTO {

    private Indicator animalsPermitted;

    private String permittedTypes;

    private Long weightLimit;

    private WeightUnit weightUnit;

}
