package com.example.rets_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertySchoolDTO {

    private Long propertyId;
    private Long schoolId;
}
