package com.example.rets_api.repository;

import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.SchoolEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class PropertyFilter {
    private int age = 0;
    private String horseFacilities = null;
    private List<SchoolDTO> schoolList = null;
    //TODO: need to add all fields
    private int bedroomsQty = 0;
    private int bathroomsQty = 0;

}
