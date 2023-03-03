package com.example.rets_api.repository;

import com.example.rets_api.converter.PropertyConverter;
import com.example.rets_api.entity.*;
import com.example.rets_api.utils.EntityUtilsTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static com.example.rets_api.utils.CompareEntitiesUtilsTest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PropertyRepositoryJPATest {

    @Autowired
    PropertyRepositoryJPA propertyRepository;

    @Test
    public void should_find_no_Property_if_repository_is_empty(){
        //Searching
        List<PropertyEntity> properties = propertyRepository.findAll();

        //Validating
        assertTrue(properties.isEmpty());
    }

    @Test
    public void should_store_a_Property() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);
    }

    @Test
    public void should_store_a_Property_With_All_Nested_Fields() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithAllFields();
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithAllFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        assertNotNull(propertySaved.getPropertyId());
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getViewData());
        assertNotNull(propertySaved.getViewData().getViewDataId());
        compareViewData(propertySaved.getViewData(), propertyEntityToCompare.getViewData());

        assertNotNull(propertySaved.getLotData());
        assertNotNull(propertySaved.getLotData().getLotDataId());
        compareLotData(propertySaved.getLotData(), propertyEntityToCompare.getLotData());

        assertNotNull(propertySaved.getSchoolList());
        assertNotNull(propertySaved.getSchoolList().get(0).getSchoolId());
        assertEquals(propertySaved.getSchoolList().size(), propertyEntityToCompare.getSchoolList().size());
        compareSchool(propertySaved.getSchoolList().get(0), propertyEntityToCompare.getSchoolList().get(0));

        assertNotNull(propertySaved.getRoomList());
        assertNotNull(propertySaved.getRoomList().get(0).getRoomId());
        assertNotNull(propertySaved.getRoomList().get(1).getRoomId());
        assertEquals(propertySaved.getRoomList().size(), propertyEntityToCompare.getRoomList().size());
        compareRoom(propertySaved.getRoomList().get(0), propertyEntityToCompare.getRoomList().get(0));
        compareRoom(propertySaved.getRoomList().get(1), propertyEntityToCompare.getRoomList().get(1));

        assertNotNull(propertySaved.getFinancialData());
        assertNotNull(propertySaved.getFinancialData().getFinancialDataId());
        compareFinancialData(propertySaved.getFinancialData(), propertyEntityToCompare.getFinancialData());

        assertNotNull(propertySaved.getAnimalPolicy());
        assertNotNull(propertySaved.getAnimalPolicy().getAnimalPolicyId());
        compareAnimalPolicy(propertySaved.getAnimalPolicy(), propertyEntityToCompare.getAnimalPolicy());

        assertNotNull(propertySaved.getContactInformation());
        assertNotNull(propertySaved.getContactInformation().getContactInformationId());
        compareContactInformation(propertySaved.getContactInformation(), propertyEntityToCompare.getContactInformation());

        assertNotNull(propertySaved.getCommunity());
        assertNotNull(propertySaved.getCommunity().getCommunityId());
        compareCommunity(propertySaved.getCommunity(), propertyEntityToCompare.getCommunity());

        assertNotNull(propertySaved.getListingPrice());
        assertNotNull(propertySaved.getListingPrice().getListingPriceId());
        compareListingPrice(propertySaved.getListingPrice(), propertyEntityToCompare.getListingPrice());
    }

    @Test
    public void should_delete_a_Property() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        //deleting
        propertyRepository.delete(propertySaved);

        //Searching
        List<PropertyEntity> properties = propertyRepository.findAll();

        //Validating
        assertTrue(properties.isEmpty());
    }

    @Test
    public void should_update_a_Property() {
        //Creating
        PropertyEntity propertyToPatch = EntityUtilsTest.createPropertyEntityWithDifferentBasicFields();
        PropertyEntity propertyEntity = EntityUtilsTest.createPropertyEntityWithBasicFields();

        //Saving
        propertyEntity = propertyRepository.saveAndFlush(propertyEntity);

        //Updating
        PropertyEntity propertyToSave = updatePropertyValues(propertyEntity, propertyToPatch);

        //Patching
        PropertyEntity responseEntity = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(responseEntity);
        comparePropertyPatchDTOBasicFields(PropertyConverter.propertyEntityToPropertyPatchDTO.convert(responseEntity), PropertyConverter.propertyEntityToPropertyPatchDTO.convert(propertyToPatch));
    }

    public static void checkAllBasicFieldsFromProperty(PropertyEntity property){

        assertNotNull(property.getPropertyId());
        assertThat(property).hasFieldOrPropertyWithValue("age", property.getAge());
        assertThat(property).hasFieldOrPropertyWithValue("horseFacilities", property.getHorseFacilities());
        assertThat(property).hasFieldOrPropertyWithValue("horseFacilitiesIndicator", property.getHorseFacilitiesIndicator());
        assertThat(property).hasFieldOrPropertyWithValue("hotTub", property.getHotTub());
        assertThat(property).hasFieldOrPropertyWithValue("hotTubIndicator", property.getHotTubIndicator());
        assertThat(property).hasFieldOrPropertyWithValue("tennisCourt", property.getTennisCourt());
        assertThat(property).hasFieldOrPropertyWithValue("tennisCourtIndicator", property.getTennisCourtIndicator());
        assertThat(property).hasFieldOrPropertyWithValue("inclusions", property.getInclusions());
        assertThat(property).hasFieldOrPropertyWithValue("energyInformation", property.getEnergyInformation());
        assertThat(property).hasFieldOrPropertyWithValue("constructionMaterial", property.getConstructionMaterial());
        assertThat(property).hasFieldOrPropertyWithValue("disabilityFeatures", property.getDisabilityFeatures());
        assertThat(property).hasFieldOrPropertyWithValue("disabilityFeaturesIndicator", property.getDisabilityFeaturesIndicator());
        assertThat(property).hasFieldOrPropertyWithValue("securityFeatures", property.getSecurityFeatures());
        assertThat(property).hasFieldOrPropertyWithValue("securityFeaturesIndicator", property.getSecurityFeaturesIndicator());
        assertThat(property).hasFieldOrPropertyWithValue("propertyTypeRental", property.getPropertyTypeRental());
        assertThat(property).hasFieldOrPropertyWithValue("propertyTypeFarm", property.getPropertyTypeFarm());
        assertThat(property).hasFieldOrPropertyWithValue("propertyTypeCondo", property.getPropertyTypeCondo());
        assertThat(property).hasFieldOrPropertyWithValue("propertyTypeTownHouse", property.getPropertyTypeTownHouse());
        assertThat(property).hasFieldOrPropertyWithValue("propertyTypeTownHouse", property.getPropertyTypeTownHouse());
        assertThat(property).hasFieldOrPropertyWithValue("firePlaceFuelType", property.getFirePlaceFuelType());
        assertThat(property).hasFieldOrPropertyWithValue("firePlaceDetails", property.getFirePlaceDetails());
        assertThat(property).hasFieldOrPropertyWithValue("floorsHardwood", property.getFloorsHardwood());
        assertThat(property).hasFieldOrPropertyWithValue("floorsHardwoodIndicator", property.getFloorsHardwoodIndicator());
        assertThat(property).hasFieldOrPropertyWithValue("displayFlagListing", property.getDisplayFlagListing());
        assertThat(property).hasFieldOrPropertyWithValue("displayFlagAddress", property.getDisplayFlagAddress());
        assertThat(property).hasFieldOrPropertyWithValue("lotSizeRange", property.getLotSizeRange());
        assertThat(property).hasFieldOrPropertyWithValue("lotSizeRangeUnits", property.getLotSizeRangeUnits());
        assertThat(property).hasFieldOrPropertyWithValue("lotSizeWidthUnits", property.getLotSizeWidthUnits());
        assertThat(property).hasFieldOrPropertyWithValue("diningRoomWidthUnits", property.getDiningRoomWidthUnits());
        assertThat(property).hasFieldOrPropertyWithValue("familyRoomWidthUnits", property.getFamilyRoomWidthUnits());
        assertThat(property).hasFieldOrPropertyWithValue("livingRoomWidthUnits", property.getLivingRoomWidthUnits());
        assertThat(property).hasFieldOrPropertyWithValue("basementWidthUnits", property.getBasementWidthUnits());
        assertThat(property).hasFieldOrPropertyWithValue("lotSizeLengthUnits", property.getLotSizeLengthUnits());
        assertThat(property).hasFieldOrPropertyWithValue("diningRoomLengthUnits", property.getDiningRoomLengthUnits());
        assertThat(property).hasFieldOrPropertyWithValue("livingRoomLengthUnits", property.getLivingRoomLengthUnits());
        assertThat(property).hasFieldOrPropertyWithValue("familyRoomLengthUnits", property.getFamilyRoomLengthUnits());
        assertThat(property).hasFieldOrPropertyWithValue("basementLengthUnits", property.getBasementLengthUnits());
        assertThat(property).hasFieldOrPropertyWithValue("parkingTotal", property.getParkingTotal());
        assertThat(property).hasFieldOrPropertyWithValue("parkingTotalOperator", property.getParkingTotalOperator());
   }

    public static PropertyEntity updatePropertyValues(PropertyEntity property1, PropertyEntity property2){
        property1.setAge(property2.getAge());
        property1.setHorseFacilities(property2.getHorseFacilities());
        property1.setHorseFacilitiesIndicator(property2.getHorseFacilitiesIndicator());
        property1.setHotTub(property2.getHotTub());
        property1.setHotTubIndicator(property2.getHotTubIndicator());
        property1.setTennisCourt(property2.getTennisCourt());
        property1.setTennisCourtIndicator(property2.getTennisCourtIndicator());
        property1.setInclusions(property2.getInclusions());
        property1.setEnergyInformation(property2.getEnergyInformation());
        property1.setConstructionMaterial(property2.getConstructionMaterial());
        property1.setDisabilityFeatures(property2.getDisabilityFeatures());
        property1.setDisabilityFeaturesIndicator(property2.getDisabilityFeaturesIndicator());
        property1.setSecurityFeatures(property2.getSecurityFeatures());
        property1.setSecurityFeaturesIndicator(property2.getSecurityFeaturesIndicator());
        property1.setPropertyTypeRental(property2.getPropertyTypeRental());
        property1.setPropertyTypeFarm(property2.getPropertyTypeFarm());
        property1.setPropertyTypeCondo(property2.getPropertyTypeCondo());
        property1.setPropertyTypeTownHouse(property2.getPropertyTypeTownHouse());
        property1.setBedroomsQty(property2.getBedroomsQty());
        property1.setFirePlaceFuelType(property2.getFirePlaceFuelType());
        property1.setFirePlaceDetails(property2.getFirePlaceDetails());
        property1.setFloorsHardwood(property2.getFloorsHardwood());
        property1.setFloorsHardwoodIndicator(property2.getFloorsHardwoodIndicator());
        property1.setDisplayFlagListing(property2.getDisplayFlagListing());
        property1.setDisplayFlagAddress(property2.getDisplayFlagAddress());
        property1.setLotSizeRange(property2.getLotSizeRange());
        property1.setLotSizeRangeUnits(property2.getLotSizeRangeUnits());
        property1.setLotSizeWidthUnits(property2.getLotSizeWidthUnits());
        property1.setDiningRoomWidthUnits(property2.getDiningRoomWidthUnits());
        property1.setFamilyRoomWidthUnits(property2.getFamilyRoomWidthUnits());
        property1.setLivingRoomWidthUnits(property2.getLivingRoomWidthUnits());
        property1.setBasementWidthUnits(property2.getBasementWidthUnits());
        property1.setLotSizeLengthUnits(property2.getLotSizeLengthUnits());
        property1.setDiningRoomLengthUnits(property2.getDiningRoomLengthUnits());
        property1.setLivingRoomLengthUnits(property2.getLivingRoomLengthUnits());
        property1.setFamilyRoomLengthUnits(property2.getFamilyRoomLengthUnits());
        property1.setBasementLengthUnits(property2.getBasementLengthUnits());
        property1.setParkingTotal(property2.getParkingTotal());
        property1.setParkingTotalOperator(property2.getParkingTotalOperator());

        return property1;
    }
}
