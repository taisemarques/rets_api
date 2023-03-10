package com.example.rets_api.service;

import com.example.rets_api.converter.PropertyConverter;
import com.example.rets_api.converter.SchoolConverter;
import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.dto.PropertyPatchDTO;
import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.entity.SchoolEntity;
import com.example.rets_api.repository.SchoolRepositoryJPA;
import com.example.rets_api.resource.PropertyFilter;
import com.example.rets_api.repository.PropertyRepositoryJPA;
import com.example.rets_api.repository.PropertyRepositoryQuerydsl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.rets_api.resource.PatchUtils.*;
import static java.util.Objects.isNull;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class PropertyService {

    private SchoolRepositoryJPA schoolRepositoryJPA;
    private PropertyRepositoryJPA propertyRepositoryJPA;
    private PropertyRepositoryQuerydsl propertyRepositoryQuerydsl;

    public PropertyService(PropertyRepositoryJPA propertyRepositoryJPA, SchoolRepositoryJPA schoolRepositoryJPA, PropertyRepositoryQuerydsl propertyRepositoryQuerydsl){
        this.propertyRepositoryJPA = propertyRepositoryJPA;
        this.propertyRepositoryQuerydsl = propertyRepositoryQuerydsl;
        this.schoolRepositoryJPA = schoolRepositoryJPA;
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

    public <T> T patchProperty(Long propertyId, T patch){
        Optional<PropertyEntity> propertyToPatch = propertyRepositoryJPA.findById(propertyId);
        if(!propertyToPatch.isPresent()){ return null;}
        switch (patch.getClass().getSimpleName()) {
            case "PropertyPatchDTO":
                return (T) patchPropertyBasicFields(propertyToPatch.get(), (PropertyPatchDTO)patch);
            case "ArrayList":
                List<T> listToPatch = (ArrayList)patch;
                if(isEmpty(listToPatch)) return null;
                switch (listToPatch.get(0).getClass().getSimpleName()){
                    case "SchoolDTO":
                        return (T) patchSchoolList(propertyToPatch.get(), (List<SchoolDTO>)patch);
                    default:
                        return null;
                }
            default:
                return null;
        }
    }

    private PropertyPatchDTO patchPropertyBasicFields(PropertyEntity propertyToPatch, PropertyPatchDTO propertyPatchDTO){
        updatePropertyFieldsWhenChanged(propertyToPatch, propertyPatchDTO);
        PropertyEntity propertyResponse = propertyRepositoryJPA.saveAndFlush(propertyToPatch);
        return PropertyConverter.propertyEntityToPropertyPatchDTO.convert(propertyResponse);
    }

    private List<SchoolDTO> patchSchoolList(PropertyEntity propertyToPatch, List<SchoolDTO> schoolListToPatch){

        propertyToPatch.getSchoolList().forEach(school -> school.getPropertyList().clear());


        propertyToPatch.setSchoolList(SchoolConverter.listSchoolDTOToListSchoolEntity(schoolListToPatch));
        PropertyEntity propertyResponse = propertyRepositoryJPA.saveAndFlush(propertyToPatch);

        return SchoolConverter.listSchoolEntityToListSchoolDTO(propertyResponse.getSchoolList());
    }


    public SchoolDTO patchSchool(Long propertyId, Long schoolId, SchoolDTO patch){

        Optional<PropertyEntity> propertyEntity = propertyRepositoryJPA.findById(propertyId);
        if(!propertyEntity.isPresent()) return null;

        Optional<SchoolEntity> schoolEntity = schoolRepositoryJPA.findById(schoolId);
        if(!schoolEntity.isPresent()) return null;

        Optional<SchoolEntity> schoolToPatch = propertyEntity.get().getSchoolList().stream().filter(school -> school.getSchoolId() == schoolId).findFirst();
        updateSchoolFieldsWhenChanged(schoolToPatch.get(), patch);
        SchoolEntity schoolResponse = schoolRepositoryJPA.saveAndFlush(schoolToPatch.get());
        return SchoolConverter.schoolEntityToSchoolDTO.convert(schoolResponse);

    }

}
