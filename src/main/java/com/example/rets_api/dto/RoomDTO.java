package com.example.rets_api.dto;

import lombok.Builder;
import lombok.Data;

import static com.example.rets_api.resource.Enums.*;

@Data
@Builder
public class RoomDTO {

    private RoomType type;

    private Indicator indicator;

    private String dimensions;

    private float length;

    private LengthWidthUnit lengthUnit;

    private float width;

    private LengthWidthUnit widthUnit;

    private float area;

    private AreaUnit areaUnit;

    private AreaType areaType;

    private BathSize bathSize;

}
