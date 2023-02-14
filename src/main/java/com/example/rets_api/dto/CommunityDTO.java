package com.example.rets_api.dto;

import com.example.rets_api.resource.Enums.CommunityType;
import com.example.rets_api.resource.Enums.Indicator;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommunityDTO {
    private String name;
    private Indicator indicator;
    private CommunityType type;

}
