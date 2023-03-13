package com.example.rets_api.service;

import com.example.rets_api.converter.PropertyConverter;
import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.dto.PropertyPatchDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.resource.PropertyFilter;
import com.example.rets_api.repository.PropertyRepositoryJPA;
import com.example.rets_api.repository.PropertyRepositoryQuerydsl;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import static com.example.rets_api.resource.PatchUtils.updatePropertyFieldsWhenChanged;

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

    public PropertyDTO deletePropertyById(Long propertyId) {
        Optional<PropertyEntity> propertyResponse = propertyRepositoryJPA.findById(propertyId);
        if(!propertyResponse.isPresent()) return null;
        propertyRepositoryJPA.delete(propertyResponse.get());
        return PropertyConverter.propertyEntityToPropertyDTO.convert(propertyResponse.get());
    }

    public PropertyPatchDTO patchProperty(Long propertyId, PropertyPatchDTO propertyPatchDTO){
        Optional<PropertyEntity> propertyToPatch = propertyRepositoryJPA.findById(propertyId);
        if(propertyToPatch.isEmpty()){ return null;}
        updatePropertyFieldsWhenChanged(propertyToPatch.get(), propertyPatchDTO);
        PropertyEntity propertyResponse = propertyRepositoryJPA.saveAndFlush(propertyToPatch.get());
        return PropertyConverter.propertyEntityToPropertyPatchDTO.convert(propertyResponse);
    }

}
