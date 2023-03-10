package com.example.rets_api.resource;


import com.example.rets_api.converter.PropertyConverter;
import com.example.rets_api.converter.ViewDataConverter;
import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.dto.PropertyPatchDTO;
import com.example.rets_api.dto.ViewDataDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.utils.DtoUtilsTest;
import org.junit.Test;

import static com.example.rets_api.resource.PatchUtils.updatePropertyFieldsWhenChanged;
import static com.example.rets_api.resource.PatchUtils.updateWhenViewDataChanged;
import static com.example.rets_api.utils.CompareEntitiesUtilsTest.comparePropertyPatchDTOBasicFields;
import static com.example.rets_api.utils.CompareEntitiesUtilsTest.compareViewData;

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

    @Test
    public void updateWhenViewDataChanged_shouldReturnTheUpdatedProperty(){
        PropertyDTO propertyDTO = DtoUtilsTest.createPropertyDTOWithAllFields();
        PropertyEntity propertyEntity = PropertyConverter.propertyDTOToPropertyEntity.convert(propertyDTO);
        ViewDataDTO patchViewDataDTO = DtoUtilsTest.createPatchViewDataDTO();

        PropertyEntity responseEntity = updateWhenViewDataChanged(propertyEntity, patchViewDataDTO);

        compareViewData(responseEntity.getViewData(), ViewDataConverter.viewDataDTOToViewDataEntity.convert(patchViewDataDTO));
    }

}
