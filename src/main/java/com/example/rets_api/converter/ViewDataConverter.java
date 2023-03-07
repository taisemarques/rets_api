package com.example.rets_api.converter;

import com.example.rets_api.dto.ViewDataDTO;
import com.example.rets_api.entity.ViewDataEntity;
import org.springframework.core.convert.converter.Converter;
import static java.util.Objects.isNull;

public class ViewDataConverter {

    public static Converter<ViewDataDTO, ViewDataEntity> viewDataDTOToViewDataEntity = in -> {
        if(isNull(in)) return null;
        ViewDataEntity retsEntity = new ViewDataEntity();
        retsEntity.setCityLight(in.getCityLight());
        retsEntity.setCityLightIndicator(in.getCityLightIndicator());
        retsEntity.setMountain(in.getMountain());
        retsEntity.setMountainIndicator(in.getMountainIndicator());
        retsEntity.setRiver(in.getRiver());
        retsEntity.setRiverIndicator(in.getRiverIndicator());
        retsEntity.setLake(in.getLake());
        retsEntity.setLakeIndicator(in.getLakeIndicator());
        retsEntity.setGolfCourse(in.getGolfCourse());
        retsEntity.setGolfCourseIndicator(in.getGolfCourseIndicator());
        retsEntity.setWater(in.getWater());
        retsEntity.setWaterIndicator(in.getWaterIndicator());
        return retsEntity;
    };

    public static Converter<ViewDataEntity, ViewDataDTO> viewDataEntityToViewDataDTO = in -> {
        if (isNull(in)) return null;
        return ViewDataDTO.builder()
                .cityLight(in.getCityLight())
                .cityLightIndicator(in.getCityLightIndicator())
                .mountain(in.getMountain())
                .mountainIndicator(in.getMountainIndicator())
                .river(in.getRiver())
                .riverIndicator(in.getRiverIndicator())
                .lake(in.getLake())
                .lakeIndicator(in.getLakeIndicator())
                .golfCourse(in.getGolfCourse())
                .golfCourseIndicator(in.getGolfCourseIndicator())
                .water(in.getWater())
                .waterIndicator(in.getWaterIndicator())
                .build();
    };
}
