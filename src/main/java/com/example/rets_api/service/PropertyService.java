package com.example.rets_api.service;

import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.repository.PropertyFilter;
import com.example.rets_api.repository.PropertyRepositoryJPA;
import com.example.rets_api.repository.PropertyRepositoryQuerydsl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        retsEntity.setDescription(in.getDescription());
        retsEntity.setPrice(in.getPrice());
        retsEntity.setSchoolEntity(in.getSchoolEntity());
        return retsEntity;
    };

    private Converter<PropertyEntity, PropertyDTO> propertyEntityToPropertyDTO = in ->
            PropertyDTO.builder()
            .description(in.getDescription())
            .price(in.getPrice())
            .schoolEntity(in.getSchoolEntity())
            .build();

    private List<PropertyDTO> listPropertiesEntityToListPropertiesDTO(List<PropertyEntity> propertiesEntity){
        return propertiesEntity.stream()
                .map(propertyDTO -> propertyEntityToPropertyDTO.convert(propertyDTO))
                .collect(Collectors.toList());
    }

    public Long createProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntry = propertyDTOToPropertyEntity.convert(propertyDTO);
        PropertyEntity propertyResponse = propertyRepositoryJPA.save(propertyEntry);
        return propertyResponse.getPropertyId();
    }

    public PropertyDTO getPropertyById(Long idBook) {
        Optional<PropertyEntity> propertyResponse = propertyRepositoryJPA.findById(idBook);
        PropertyDTO response = propertyResponse.isPresent()?
                propertyEntityToPropertyDTO.convert(propertyResponse.get()):
                PropertyDTO.builder().build();
        return response;
    }

    public List<PropertyDTO> getPropertiesByParams(PropertyFilter propertyFilter){
        List<PropertyEntity> propertyEntities = propertyRepositoryQuerydsl.fetchAll(propertyFilter);
        List<PropertyDTO> book = listPropertiesEntityToListPropertiesDTO(propertyEntities);
        return book;
    }

}
