package com.example.rets_api.service;

import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.dto.PropertyPatchDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.repository.PropertyRepositoryJPA;
import com.example.rets_api.repository.PropertyRepositoryQuerydsl;
import com.example.rets_api.resource.PropertyFilter;
import com.example.rets_api.utils.FilterUtilsTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.rets_api.converter.PropertyConverterTest.checkAllFields_Property;
import static com.example.rets_api.utils.CompareEntitiesUtilsTest.comparePropertyDTOBasicFields;
import static com.example.rets_api.utils.DtoUtilsTest.createPropertyDTOWithBasicFields;
import static com.example.rets_api.utils.DtoUtilsTest.createPropertyPatchDTOWithBasicFields;
import static com.example.rets_api.utils.EntityUtilsTest.*;
import static com.example.rets_api.utils.FilterUtilsTest.createPropertyFilterAgeBedroomBathRoom;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PropertyServiceTest {

    @Mock
    private PropertyRepositoryJPA propertyRepositoryJPA;

    @Mock
    private PropertyRepositoryQuerydsl propertyRepositoryQuerydsl;

    @InjectMocks
    private PropertyService propertyService = new PropertyService(propertyRepositoryJPA, propertyRepositoryQuerydsl);

    @Test
    public void shouldCreateProperty_createProperty() {
        //Creating objects
        PropertyDTO propertyDTORequest = createPropertyDTOWithBasicFields();
        PropertyEntity propertyEntityResponse = createPropertyEntityResponseAndID(Long.valueOf(123456789));

        //Mocking calls
        when(propertyRepositoryJPA.saveAndFlush(any())).thenReturn(propertyEntityResponse);

        //Request
        Long id = propertyService.createProperty(propertyDTORequest);

        //Validation
        assertEquals(id, propertyEntityResponse.getPropertyId());
    }

    @Test
    public void shouldGetEmptyProperty_getPropertyById() {

        //Request
        PropertyDTO propertyDTOResponse = propertyService.getPropertyById(Long.valueOf(123456789));

        //Validation
        assertNull(propertyDTOResponse);
    }

    @Test
    public void shouldGetPropertyById_getPropertyById() {
        //Creating objects
        PropertyEntity propertyEntity = createPropertyEntityResponseAndID(Long.valueOf(123456789));

        //Mocking calls
        when(propertyRepositoryJPA.findById(any())).thenReturn(Optional.of(propertyEntity));

        //Request
        PropertyDTO propertyDTOResponse = propertyService.getPropertyById(Long.valueOf(123456789));

        //Validation
        checkAllFields_Property(propertyEntity, propertyDTOResponse);
    }

    @Test
    public void shouldGetEmptyPropertyList_getPropertyByParam() {
        //Creating objects
        PropertyFilter propertyFilter = FilterUtilsTest.createPropertyFilterAgeBedroomBathRoom();
        List<PropertyDTO> emptyArray = new ArrayList<>();

        //Request
        List<PropertyDTO> propertyDTOResponse = propertyService.getPropertiesByParams(propertyFilter);

        //Validation
        assertEquals(emptyArray, propertyDTOResponse);
    }

    @Test
    public void shouldGetPropertyByParams_getPropertiesByParams() {
        //Creating objects
        PropertyFilter propertyFilter = createPropertyFilterAgeBedroomBathRoom();
        PropertyEntity propertyEntity = createPropertyEntityResponseAndID(Long.valueOf(123456789));

        //Mocking calls
        when(propertyRepositoryQuerydsl.fetchAll(any())).thenReturn(asList(propertyEntity));

        //Request
        List<PropertyDTO> propertyDTOListResponse = propertyService.getPropertiesByParams(propertyFilter);

        //Validation
        checkAllFields_Property(propertyEntity, propertyDTOListResponse.get(0));
    }

    @Test
    public void shouldGetEmptyPropertyList_getAllProperty() {
        //Creating objects
        List<PropertyDTO> emptyArray = new ArrayList<>();

        //Request
        List<PropertyDTO> propertyDTOResponse = propertyService.getPropertiesByParams(new PropertyFilter());

        //Validation
        assertEquals(emptyArray, propertyDTOResponse);
    }

    @Test
    public void shouldGetPropertyList_getAllProperties() {

        //Creating objects
        PropertyEntity propertyEntity = createPropertyEntityResponseAndID(Long.valueOf(123456789));

        //Mocking calls
        when(propertyRepositoryQuerydsl.fetchAll(any())).thenReturn(asList(propertyEntity));

        //Request
        List<PropertyDTO> propertyDTOListResponse = propertyService.getPropertiesByParams(new PropertyFilter());

        //Validation
        checkAllFields_Property(propertyEntity, propertyDTOListResponse.get(0));
    }


    @Test
    public void shouldDeletePropertyById_deletePropertyById() {

        //Creating objects
        PropertyEntity propertyEntity = createPropertyEntityResponseAndID(Long.valueOf(123456789));

        //Mocking calls
        when(propertyRepositoryJPA.findById(any())).thenReturn(Optional.of(propertyEntity));
        doNothing().when(propertyRepositoryJPA).delete(any());

        //Request
        PropertyDTO propertyDTOResponse = propertyService.deletePropertyById(Long.valueOf(123456789));

        //Validation
        checkAllFields_Property(propertyEntity, propertyDTOResponse);
        verify(propertyRepositoryJPA, times(1)).delete(propertyEntity);
    }

    @Test
    public void shouldPatchProperty_patchProperty(){
        //Creating objects
        PropertyPatchDTO propertyPatchDTO = createPropertyPatchDTOWithBasicFields();
        PropertyEntity propertyEntity = createPropertyEntityResponseAndID(Long.valueOf(123456789));

        //Mocking calls
        when(propertyRepositoryJPA.findById(any())).thenReturn(Optional.of(propertyEntity));
        when(propertyRepositoryJPA.saveAndFlush(any())).thenReturn(propertyEntity);

        //Request
        PropertyDTO propertyResponse = propertyService.patchProperty(Long.valueOf(123456789),propertyPatchDTO);

        //Validation
        comparePropertyDTOBasicFields(propertyResponse, propertyPatchDTO);
    }

    @Test
    public void shouldReturnNull_patchProperty(){
        //Creating objects
        PropertyPatchDTO propertyPatchDTO = createPropertyPatchDTOWithBasicFields();

        //Request
        PropertyDTO propertyResponse = propertyService.patchProperty(Long.valueOf(123456789),propertyPatchDTO);

        //Validation
        assertNull(propertyResponse);

    }

}
