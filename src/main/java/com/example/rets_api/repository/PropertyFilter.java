package com.example.rets_api.repository;

import com.example.rets_api.entity.SchoolEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PropertyFilter {
    private Long price = null;
    private String description = null;
    private SchoolEntity schoolEntity = null;
}
