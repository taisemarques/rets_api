package com.example.rets_api.resource;


import com.example.rets_api.converter.PropertyConverter;
import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.dto.PropertyPatchDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.utils.DtoUtilsTest;
import org.junit.Test;

import static com.example.rets_api.resource.PatchUtils.updatePropertyFieldsWhenChanged;
import static com.example.rets_api.utils.CompareEntitiesUtilsTest.comparePropertyPatchDTOBasicFields;

public class PatchUtilsTest {


    @Test
    public void updatePropertyFieldsWhenChanged_shouldReturnTheUpdatedProperty(){
        PropertyDTO propertyDTO = DtoUtilsTest.createPropertyDTOWithAllFields();
        PropertyEntity propertyEntity = PropertyConverter.propertyDTOToPropertyEntity.convert(propertyDTO);
        PropertyPatchDTO propertyPatchDTO = DtoUtilsTest.createPropertyPatchDTO();

        PropertyEntity responseEntity = updatePropertyFieldsWhenChanged(propertyEntity, propertyPatchDTO);
        PropertyPatchDTO responseEntityToCompare = PropertyConverter.propertyEntityToPropertyPatchDTO.convert(responseEntity);

        comparePropertyPatchDTOBasicFields(responseEntityToCompare, propertyPatchDTO);

    }
}
