package com.example.rets_api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PropertyDTO {

    private String description;
    private Long price;
    private SchoolDTO schoolDTO;
    private List<RoomDTO> roomDTOList;

}
