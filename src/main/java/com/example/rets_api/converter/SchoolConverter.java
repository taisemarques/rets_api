package com.example.rets_api.converter;

import com.example.rets_api.dto.RoomDTO;
import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.RoomEntity;
import com.example.rets_api.entity.SchoolEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<SchoolDTO> listSchoolEntityToListSchoolDTO(List<SchoolEntity> schoolEntityList) {
        return schoolEntityList.stream()
                .map(schoolDTO -> schoolEntityToSchoolDTO.convert(schoolDTO))
                .collect(Collectors.toList());
    }

    public static List<SchoolEntity> listSchoolDTOToListSchoolEntity(List<SchoolDTO> schoolDTOList) {
        return schoolDTOList.stream()
                .map(schoolEntity -> schoolDTOToSchoolEntity.convert(schoolEntity))
                .collect(Collectors.toList());
    }
}


