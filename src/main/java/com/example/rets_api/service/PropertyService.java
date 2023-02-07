package com.example.rets_api.service;

import com.example.rets_api.converter.FinancialDataConverter;
import com.example.rets_api.converter.RoomConverter;
import com.example.rets_api.converter.SchoolConverter;
import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.repository.PropertyFilter;
import com.example.rets_api.repository.PropertyRepositoryJPA;
import com.example.rets_api.repository.PropertyRepositoryQuerydsl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class PropertyService {

    private PropertyRepositoryJPA propertyRepositoryJPA;
    private PropertyRepositoryQuerydsl propertyRepositoryQuerydsl;

    public PropertyService(PropertyRepositoryJPA propertyRepositoryJPA, PropertyRepositoryQuerydsl propertyRepositoryQuerydsl){
        this.propertyRepositoryJPA = propertyRepositoryJPA;
        this.propertyRepositoryQuerydsl = propertyRepositoryQuerydsl;
    }

    private Converter<PropertyDTO, PropertyEntity> propertyDTOToPropertyEntity = in -> {
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
        retsEntity.setSchoolList(SchoolConverter.listSchoolDTOToListSchoolEntity(in.getSchoolDTOList()));
        retsEntity.setRoomList(RoomConverter.listRoomDTOToListRoomEntity(in.getRoomDTOList()));
        return retsEntity;
    };

    private Converter<PropertyEntity, PropertyDTO> propertyEntityToPropertyDTO = in ->
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
                .propertyTypeFarm(in.getPropertyTypeFarm())
                .propertyTypeTownHouse(in.getPropertyTypeTownHouse())
                .financialData(FinancialDataConverter.financialDataEntityToFinancialDataDTO.convert(in.getFinancialData()))
                .schoolDTOList(SchoolConverter.listSchoolEntityToListSchoolDTO(in.getSchoolList()))
                .roomDTOList(RoomConverter.listRoomEntityToListRoomDTO(in.getRoomList()))
                .build();

    private List<PropertyDTO> listPropertiesEntityToListPropertiesDTO(List<PropertyEntity> propertiesEntity){
        return propertiesEntity.stream()
                .map(propertyDTO -> propertyEntityToPropertyDTO.convert(propertyDTO))
                .collect(Collectors.toList());
    }

    public Long createProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = propertyDTOToPropertyEntity.convert(propertyDTO);
        PropertyEntity propertyResponse = propertyRepositoryJPA.saveAndFlush(propertyEntity);
        return propertyResponse.getPropertyId();
    }

    public PropertyDTO getPropertyById(Long idBook) {
        PropertyEntity propertyResponse = propertyRepositoryJPA.getById(idBook);
        PropertyDTO response = isNull(propertyResponse)?
                PropertyDTO.builder().build():
                propertyEntityToPropertyDTO.convert(propertyResponse);
        return response;
    }

    public List<PropertyDTO> getPropertiesByParams(PropertyFilter propertyFilter){
        List<PropertyEntity> propertyEntities = propertyRepositoryQuerydsl.fetchAll(propertyFilter);
        List<PropertyDTO> book = listPropertiesEntityToListPropertiesDTO(propertyEntities);
        return book;
    }

}
