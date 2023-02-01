package com.example.rets_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertyDTO {

    private String description;
    private Long price;

}
