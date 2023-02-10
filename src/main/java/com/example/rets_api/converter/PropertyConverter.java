package com.example.rets_api.converter;

import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.entity.PropertyEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class PropertyConverter {

    public static Converter<PropertyDTO, PropertyEntity> propertyDTOToPropertyEntity = in -> {
        PropertyEntity retsEntity = new PropertyEntity();
        retsEntity.setAge(in.getAge());
        retsEntity.setHorseFacilities(in.getHorseFacilities());
        retsEntity.setHorseFacilitiesIndicator(in.getHorseFacilitiesIndicator());
        retsEntity.setHotTub(in.getHotTub());
        retsEntity.setHotTubIndicator(in.getHotTubIndicator());
        retsEntity.setTennisCourt(in.getTennisCourt());
        retsEntity.setTennisCourtIndicator(in.getTennisCourtIndicator());
        retsEntity.setInclusions(in.getInclusions());
        retsEntity.setEnergyInformation(in.getEnergyInformation());
        retsEntity.setConstructionMaterial(in.getConstructionMaterial());
        retsEntity.setDisabilityFeatures(in.getDisabilityFeatures());
        retsEntity.setDisabilityFeaturesIndicator(in.getDisabilityFeaturesIndicator());
        retsEntity.setSecurityFeatures(in.getSecurityFeatures());
        retsEntity.setSecurityFeaturesIndicator(in.getSecurityFeaturesIndicator());
        retsEntity.setPropertyTypeRental(in.getPropertyTypeRental());
        retsEntity.setPropertyTypeFarm(in.getPropertyTypeFarm());
        retsEntity.setPropertyTypeCondo(in.getPropertyTypeCondo());
        retsEntity.setPropertyTypeTownHouse(in.getPropertyTypeTownHouse());
        retsEntity.setFinancialData(FinancialDataConverter.financialDataDTOToFinancialDataEntity.convert(in.getFinancialData()));
        retsEntity.setSchoolList(SchoolConverter.listSchoolDTOToListSchoolEntity(in.getSchoolList()));
        retsEntity.setRoomList(RoomConverter.listRoomDTOToListRoomEntity(in.getRoomList()));
        return retsEntity;
    };

    public static Converter<PropertyEntity, PropertyDTO> propertyEntityToPropertyDTO = in ->
            PropertyDTO.builder()
                    .age(in.getAge())
                    .horseFacilities(in.getHorseFacilities())
                    .horseFacilitiesIndicator(in.getHorseFacilitiesIndicator())
                    .hotTub(in.getHotTub())
                    .hotTubIndicator(in.getHotTubIndicator())
                    .tennisCourt(in.getTennisCourt())
                    .tennisCourtIndicator(in.getTennisCourtIndicator())
                    .inclusions((in.getInclusions()))
                    .energyInformation(in.getEnergyInformation())
                    .constructionMaterial(in.getConstructionMaterial())
                    .disabilityFeatures(in.getDisabilityFeatures())
                    .disabilityFeaturesIndicator(in.getDisabilityFeaturesIndicator())
                    .securityFeatures(in.getSecurityFeatures())
                    .securityFeaturesIndicator(in.getSecurityFeaturesIndicator())
                    .propertyTypeRental(in.getPropertyTypeRental())
                    .propertyTypeFarm(in.getPropertyTypeFarm())
                    .propertyTypeCondo(in.getPropertyTypeCondo())
                    .propertyTypeTownHouse(in.getPropertyTypeTownHouse())
                    .financialData(FinancialDataConverter.financialDataEntityToFinancialDataDTO.convert(in.getFinancialData()))
                    .schoolList(SchoolConverter.listSchoolEntityToListSchoolDTO(in.getSchoolList()))
                    .roomList(RoomConverter.listRoomEntityToListRoomDTO(in.getRoomList()))
                    .build();

    public static List<PropertyDTO> listPropertiesEntityToListPropertiesDTO(List<PropertyEntity> propertiesEntity){
        return propertiesEntity.stream()
                .map(propertyDTO -> propertyEntityToPropertyDTO.convert(propertyDTO))
                .collect(Collectors.toList());
    }
}