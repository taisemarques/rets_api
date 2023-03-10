package com.example.rets_api.converter;

import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.SchoolEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class SchoolConverter {
    public static Converter<SchoolDTO, SchoolEntity> schoolDTOToSchoolEntity = in -> {
        if(isNull(in)) return null;
        SchoolEntity retsEntity = new SchoolEntity();
        retsEntity.setSchoolId(in.getSchoolId());
        retsEntity.setPrimarySchool(in.getPrimary());
        retsEntity.setJrHigh(in.getJrHigh());
        return retsEntity;
    };

    public static Converter<SchoolEntity, SchoolDTO> schoolEntityToSchoolDTO = in -> {
        if (isNull(in)) return null;
        return SchoolDTO.builder()
                .schoolId(in.getSchoolId())
                .primary(in.getPrimarySchool())
                .jrHigh(in.getJrHigh())
                .build();
    };

    public static List<SchoolDTO> listSchoolEntityToListSchoolDTO(List<SchoolEntity> schoolEntityList) {
        if (isNull(schoolEntityList)) return null;
        return schoolEntityList.stream()
                .map(schoolDTO -> schoolEntityToSchoolDTO.convert(schoolDTO))
                .collect(Collectors.toList());
    }

    public static List<SchoolEntity> listSchoolDTOToListSchoolEntity(List<SchoolDTO> schoolDTOList) {
        if (isNull(schoolDTOList)) return null;
        return schoolDTOList.stream()
                .map(schoolEntity -> schoolDTOToSchoolEntity.convert(schoolEntity))
                .collect(Collectors.toList());
    }
}


