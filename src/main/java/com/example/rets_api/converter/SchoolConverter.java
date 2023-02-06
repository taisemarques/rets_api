package com.example.rets_api.converter;

import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.SchoolEntity;
import org.springframework.core.convert.converter.Converter;

public class SchoolConverter {
    public static Converter<SchoolDTO, SchoolEntity> schoolDTOToSchoolEntity = in -> {
        SchoolEntity retsEntity = new SchoolEntity();
        retsEntity.setPrimarySchool(in.getPrimary());
        retsEntity.setJrHigh(in.getJrHigh());
        return retsEntity;
    };

    public static Converter<SchoolEntity, SchoolDTO> schoolEntityToSchoolDTO = in ->
            SchoolDTO.builder()
                    .primary(in.getPrimarySchool())
                    .jrHigh(in.getJrHigh())
                    .build();
}
