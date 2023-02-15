package com.example.rets_api.dto;

import com.example.rets_api.resource.Enums.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AnimalPolicyDTO {

    private Indicator animalsPermitted;

    private String permittedTypes;

    private Long weightLimit;

    private WeightUnit weightUnit;

}
