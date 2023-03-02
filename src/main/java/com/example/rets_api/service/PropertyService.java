package com.example.rets_api.service;

import com.example.rets_api.converter.PropertyConverter;
import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.resource.PropertyFilter;
import com.example.rets_api.repository.PropertyRepositoryJPA;
import com.example.rets_api.repository.PropertyRepositoryQuerydsl;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    private PropertyRepositoryJPA propertyRepositoryJPA;
    private PropertyRepositoryQuerydsl propertyRepositoryQuerydsl;

    public PropertyService(PropertyRepositoryJPA propertyRepositoryJPA, PropertyRepositoryQuerydsl propertyRepositoryQuerydsl){
        this.propertyRepositoryJPA = propertyRepositoryJPA;
        this.propertyRepositoryQuerydsl = propertyRepositoryQuerydsl;
    }

    public Long createProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = PropertyConverter.propertyDTOToPropertyEntity.convert(propertyDTO);
        PropertyEntity propertyResponse = propertyRepositoryJPA.saveAndFlush(propertyEntity);
        return propertyResponse.getPropertyId();
    }

    public PropertyDTO getPropertyById(Long propertyId) {
        Optional<PropertyEntity> propertyResponse = propertyRepositoryJPA.findById(propertyId);
        PropertyDTO response = propertyResponse.isPresent()?
                PropertyConverter.propertyEntityToPropertyDTO.convert(propertyResponse.get()):
                null;
        return response;
    }

    public List<PropertyDTO> getPropertiesByParams(PropertyFilter propertyFilter){
        List<PropertyEntity> propertyEntities = propertyRepositoryQuerydsl.fetchAll(propertyFilter);
        List<PropertyDTO> propertiesDTO = PropertyConverter.listPropertiesEntityToListPropertiesDTO(propertyEntities);
        return propertiesDTO;
    }

}
