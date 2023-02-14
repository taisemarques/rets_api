package com.example.rets_api.converter;

import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.repository.UtilsTest;
import org.junit.Test;

import static com.example.rets_api.converter.AnimalPolicyConverterTest.checkAllFields_AnimalPolicy;
import static com.example.rets_api.converter.FinancialDataConverterTest.checkAllFields_FinancialData;
import static com.example.rets_api.converter.RoomConverterTest.checkAllFields_Room;
import static com.example.rets_api.converter.SchoolConverterTest.checkAllFields_School;
import static com.example.rets_api.converter.LotDataConverterTest.checkAllFields_LotData;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PropertyConverterTest {

    //DTO To Entity

    @Test
    public void dtoTOEntity_NullPropertyConverter_ShouldReturnNull(){
        PropertyEntity propertyEntity = PropertyConverter.propertyDTOToPropertyEntity.convert(null);
        assertNull(propertyEntity);
    }

    @Test
    public void dtoTOEntity_EmptyPropertyConverter_ShouldReturnEmpty(){
        PropertyDTO propertyDTO = PropertyDTO.builder().build();
        PropertyEntity propertyEntity = PropertyConverter.propertyDTOToPropertyEntity.convert(propertyDTO);
        checkNullAllFields_PropertyEntity(propertyEntity);
    }

    @Test
    public void dtoTOEntity_PropertyConverter_ShouldReturnCompleteObject(){
        PropertyDTO propertyDTO = UtilsTest.createPropertyDTOWithBasicFields();
        PropertyEntity propertyEntity = PropertyConverter.propertyDTOToPropertyEntity.convert(propertyDTO);
        checkAllFields_Property(propertyEntity, propertyDTO);
        checkAllFields_Room(propertyEntity.getRoomList().get(0), propertyDTO.getRoomList().get(0));
        checkAllFields_School(propertyEntity.getSchoolList().get(0), propertyDTO.getSchoolList().get(0));
        checkAllFields_FinancialData(propertyEntity.getFinancialData(), propertyDTO.getFinancialData());
        checkAllFields_LotData(propertyEntity.getLotData(), propertyDTO.getLotData());
        checkAllFields_AnimalPolicy(propertyEntity.getAnimalPolicy(), propertyDTO.getAnimalPolicy());
    }

    //Entity To DTO

    @Test
    public void entityToDTO_NullPropertyConverter_ShouldReturnNull(){
        PropertyDTO propertyDTO = PropertyConverter.propertyEntityToPropertyDTO.convert(null);
        assertNull(propertyDTO);
    }

    @Test
    public void entityToDTO_EmptyRoomConverter_ShouldReturnEmpty(){
        PropertyEntity propertyEntity = new PropertyEntity();
        PropertyDTO propertyDTO = PropertyConverter.propertyEntityToPropertyDTO.convert(propertyEntity);
        checkNullAllFields_PropertyDTO(propertyDTO);
    }

    @Test
    public void entityToDTO_PropertyConverter_ShouldReturnCompleteObject(){
        PropertyEntity propertyEntity = UtilsTest.createPropertyEntityWithBasicFields();
        PropertyDTO propertyDTO = PropertyConverter.propertyEntityToPropertyDTO.convert(propertyEntity);
        checkAllFields_Property(propertyEntity, propertyDTO);
        checkAllFields_Room(propertyEntity.getRoomList().get(0), propertyDTO.getRoomList().get(0));
        checkAllFields_School(propertyEntity.getSchoolList().get(0), propertyDTO.getSchoolList().get(0));
        checkAllFields_FinancialData(propertyEntity.getFinancialData(), propertyDTO.getFinancialData());
        checkAllFields_LotData(propertyEntity.getLotData(), propertyDTO.getLotData());
        checkAllFields_AnimalPolicy(propertyEntity.getAnimalPolicy(), propertyDTO.getAnimalPolicy());
    }

    private void checkNullAllFields_PropertyEntity(PropertyEntity propertyEntity){
        assertEquals(propertyEntity.getAge(), 0);
        assertNull(propertyEntity.getHorseFacilities());
        assertNull(propertyEntity.getHorseFacilitiesIndicator());
        assertNull(propertyEntity.getHotTub());
        assertNull(propertyEntity.getHotTubIndicator());
        assertNull(propertyEntity.getTennisCourt());
        assertNull(propertyEntity.getTennisCourtIndicator());
        assertNull(propertyEntity.getInclusions());
        assertNull(propertyEntity.getEnergyInformation());
        assertNull(propertyEntity.getConstructionMaterial());
        assertNull(propertyEntity.getDisabilityFeatures());
        assertNull(propertyEntity.getDisabilityFeaturesIndicator());
        assertNull(propertyEntity.getSecurityFeatures());
        assertNull(propertyEntity.getSecurityFeaturesIndicator());
        assertNull(propertyEntity.getPropertyTypeFarm());
        assertNull(propertyEntity.getPropertyTypeRental());
        assertNull(propertyEntity.getPropertyTypeCondo());
        assertNull(propertyEntity.getPropertyTypeTownHouse());
    }

    private void checkNullAllFields_PropertyDTO(PropertyDTO propertyDTO){
        assertEquals(propertyDTO.getAge(),0);
        assertNull(propertyDTO.getHorseFacilities());
        assertNull(propertyDTO.getHorseFacilitiesIndicator());
        assertNull(propertyDTO.getHotTub());
        assertNull(propertyDTO.getHotTubIndicator());
        assertNull(propertyDTO.getTennisCourt());
        assertNull(propertyDTO.getTennisCourtIndicator());
        assertNull(propertyDTO.getInclusions());
        assertNull(propertyDTO.getEnergyInformation());
        assertNull(propertyDTO.getConstructionMaterial());
        assertNull(propertyDTO.getDisabilityFeatures());
        assertNull(propertyDTO.getDisabilityFeaturesIndicator());
        assertNull(propertyDTO.getSecurityFeatures());
        assertNull(propertyDTO.getSecurityFeaturesIndicator());
        assertNull(propertyDTO.getPropertyTypeFarm());
        assertNull(propertyDTO.getPropertyTypeRental());
        assertNull(propertyDTO.getPropertyTypeCondo());
        assertNull(propertyDTO.getPropertyTypeTownHouse());
    }

    public static void checkAllFields_Property(PropertyEntity propertyEntity, PropertyDTO propertyDTO) {
        assertEquals(propertyEntity.getAge(), propertyDTO.getAge());
        assertEquals(propertyEntity.getHorseFacilities(), propertyDTO.getHorseFacilities());
        assertEquals(propertyEntity.getHorseFacilitiesIndicator(), propertyDTO.getHorseFacilitiesIndicator());
        assertEquals(propertyEntity.getHotTub(), propertyDTO.getHotTub());
        assertEquals(propertyEntity.getHotTubIndicator(), propertyDTO.getHotTubIndicator());
        assertEquals(propertyEntity.getTennisCourt(), propertyDTO.getTennisCourt());
        assertEquals(propertyEntity.getTennisCourtIndicator(), propertyDTO.getTennisCourtIndicator());
        assertEquals(propertyEntity.getInclusions(), propertyDTO.getInclusions());
        assertEquals(propertyEntity.getEnergyInformation(), propertyDTO.getEnergyInformation());
        assertEquals(propertyEntity.getConstructionMaterial(), propertyDTO.getConstructionMaterial());
        assertEquals(propertyEntity.getDisabilityFeatures(), propertyDTO.getDisabilityFeatures());
        assertEquals(propertyEntity.getDisabilityFeaturesIndicator(), propertyDTO.getDisabilityFeaturesIndicator());
        assertEquals(propertyEntity.getSecurityFeatures(), propertyDTO.getSecurityFeatures());
        assertEquals(propertyEntity.getSecurityFeaturesIndicator(), propertyDTO.getSecurityFeaturesIndicator());
        assertEquals(propertyEntity.getPropertyTypeFarm(), propertyDTO.getPropertyTypeFarm());
        assertEquals(propertyEntity.getPropertyTypeRental(), propertyDTO.getPropertyTypeRental());
        assertEquals(propertyEntity.getPropertyTypeCondo(), propertyDTO.getPropertyTypeCondo());
        assertEquals(propertyEntity.getPropertyTypeTownHouse(), propertyDTO.getPropertyTypeTownHouse());
    }
}
