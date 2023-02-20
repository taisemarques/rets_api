package com.example.rets_api.converter;

import com.example.rets_api.dto.CommunityDTO;
import com.example.rets_api.entity.CommunityEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class CommunityConverter {

    public static Converter<CommunityDTO, CommunityEntity> communityDTOToCommunityEntity = in -> {
        if(isNull(in)) return null;
        CommunityEntity communityEntity = new CommunityEntity();
        communityEntity.setClubHouse(in.getClubHouse());
        communityEntity.setClubHouseIndicator(in.getClubHouseIndicator());
        communityEntity.setExerciseArea(in.getExerciseArea());
        communityEntity.setExerciseAreaIndicator(in.getExerciseAreaIndicator());
        communityEntity.setGolf(in.getGolf());
        communityEntity.setGolfIndicator(in.getGolfIndicator());
        communityEntity.setTennis(in.getTennis());
        communityEntity.setTennisIndicator(in.getTennisIndicator());
        communityEntity.setRecreationalFacilities(in.getRecreationalFacilities());
        communityEntity.setRecreationalFacilitiesIndicator(in.getRecreationalFacilitiesIndicator());
        communityEntity.setSeniorCommunity(in.getSeniorCommunity());
        communityEntity.setSeniorCommunityIndicator(in.getSeniorCommunityIndicator());
        communityEntity.setSecurityFeatures(in.getSecurityFeatures());
        communityEntity.setSecurityFeaturesIndicator(in.getSecurityFeaturesIndicator());
        communityEntity.setHotTub(in.getHotTub());
        communityEntity.setHotTubIndicator(in.getHotTubIndicator());
        communityEntity.setPool(in.getPool());
        communityEntity.setPoolIndicator(in.getPoolIndicator());
        communityEntity.setBoatFacilities(in.getBoatFacilities());
        communityEntity.setBoatFacilitiesIndicator(in.getBoatFacilitiesIndicator());
        communityEntity.setHorseFacilities(in.getHorseFacilities());
        communityEntity.setHorseFacilitiesIndicator(in.getHorseFacilitiesIndicator());
        communityEntity.setCommunityPark(in.getCommunityPark());
        communityEntity.setCommunityParkIndicator(in.getCommunityParkIndicator());
        return communityEntity;
    };

    public static Converter<CommunityEntity, CommunityDTO> communityEntityToCommunityDTO = in -> {
        if (isNull(in)) return null;
        return CommunityDTO.builder()
                .clubHouse(in.getClubHouse())
                .clubHouseIndicator(in.getClubHouseIndicator())
                .exerciseArea(in.getExerciseArea())
                .exerciseAreaIndicator(in.getExerciseAreaIndicator())
                .golf(in.getGolf())
                .golfIndicator(in.getGolfIndicator())
                .tennis(in.getTennis())
                .tennisIndicator(in.getTennisIndicator())
                .recreationalFacilities(in.getRecreationalFacilities())
                .recreationalFacilitiesIndicator(in.getRecreationalFacilitiesIndicator())
                .securityFeatures(in.getSecurityFeatures())
                .securityFeaturesIndicator(in.getSecurityFeaturesIndicator())
                .seniorCommunity(in.getSeniorCommunity())
                .seniorCommunityIndicator(in.getSeniorCommunityIndicator())
                .hotTub(in.getHotTub())
                .hotTubIndicator(in.getHotTubIndicator())
                .pool(in.getPool())
                .poolIndicator(in.getPoolIndicator())
                .boatFacilities(in.getBoatFacilities())
                .boatFacilitiesIndicator(in.getBoatFacilitiesIndicator())
                .horseFacilities(in.getHorseFacilities())
                .horseFacilitiesIndicator(in.getHorseFacilitiesIndicator())
                .communityPark(in.getCommunityPark())
                .communityParkIndicator(in.getCommunityParkIndicator())
                .build();
    };
}
