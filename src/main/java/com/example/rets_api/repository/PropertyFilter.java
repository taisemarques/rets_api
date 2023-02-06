package com.example.rets_api.repository;

import com.example.rets_api.entity.SchoolEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class PropertyFilter {
    private Long price = null;
    private String description = null;
    private String primarySchool = null;
    private String jrHigh = null;
    private int bedroomsQty = 0;
    private int bathroomsQty = 0;

}
