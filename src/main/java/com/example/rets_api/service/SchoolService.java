package com.example.rets_api.service;

import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.entity.SchoolEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    public Converter<SchoolDTO, SchoolEntity> schoolDTOToSchoolEntity = in -> {
        SchoolEntity retsEntity = new SchoolEntity();
        retsEntity.setPrimarySchool(in.getPrimary());
        retsEntity.setJrHigh(in.getJrHigh());
        return retsEntity;
    };

    public Converter<SchoolEntity, SchoolDTO> schoolEntityToSchoolDTO = in ->
           SchoolDTO.builder()
                    .primary(in.getPrimarySchool())
                    .jrHigh(in.getJrHigh())
                    .build();
}
