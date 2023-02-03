package com.example.rets_api.dto;

import com.example.rets_api.entity.RoomEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDTO {

    private RoomEntity.RoomType type;
    private float width;
    private float length;
    private float area;

}
