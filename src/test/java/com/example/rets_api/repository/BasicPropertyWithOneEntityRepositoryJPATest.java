package com.example.rets_api.repository;


import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.resource.Enums;
import com.example.rets_api.utils.EntityUtilsTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.rets_api.utils.EntityUtilsTest.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BasicPropertyWithOneEntityRepositoryJPATest{

    BaseTests baseTests = new BaseTests();
    @Autowired
    PropertyRepositoryJPA propertyRepository;

    @Test
    public void should_store_a_PropertyAndFinancialData(){
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFields();
        propertyToSave.setFinancialData(createFinancialDataEntity());
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithAllNestedFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getFinancialData());
        assertTrue(baseTests.compareFinancialData(propertySaved.getFinancialData(), propertyEntityToCompare.getFinancialData()));
        assertNotNull(propertySaved.getFinancialData().getFinancialDataId());
    }

    @Test
    public void should_store_a_PropertyAndRoom() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFields();
        propertyToSave.setRoomList(asList(createRoomEntity(Enums.RoomType.LIVING_ROOM), createRoomEntity((Enums.RoomType.MAIN_FLOOR_BEDROOM))));
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithAllNestedFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getRoomList());
        assertEquals(propertySaved.getRoomList().size(), propertyEntityToCompare.getRoomList().size());
        assertTrue(baseTests.compareRoom(propertySaved.getRoomList().get(0), propertyEntityToCompare.getRoomList().get(0)));
        assertTrue(baseTests.compareRoom(propertySaved.getRoomList().get(1), propertyEntityToCompare.getRoomList().get(1)));
        assertNotNull(propertySaved.getRoomList().get(0).getRoomId());
        assertNotNull(propertySaved.getRoomList().get(1).getRoomId());
    }

    @Test
    public void should_store_a_PropertyAndSchool() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFields();
        propertyToSave.setSchoolList(asList(createSchoolEntity("primary", "jrHigh")));
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithAllNestedFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getSchoolList());
        assertEquals(propertySaved.getSchoolList().size(), propertyEntityToCompare.getSchoolList().size());
        assertTrue(baseTests.compareSchool(propertySaved.getSchoolList().get(0), propertyEntityToCompare.getSchoolList().get(0)));
        assertNotNull(propertySaved.getSchoolList().get(0).getSchoolId());
    }

    @Test
    public void should_store_a_PropertyAndCommunity() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFields();
        propertyToSave.setCommunity(createCommunityEntity());
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithAllNestedFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getCommunity());
        assertEquals(propertySaved.getCommunity(), propertyToSave.getCommunity());
        assertNotNull(propertySaved.getCommunity().getCommunityId());
        assertTrue(baseTests.compareCommunity(propertySaved.getCommunity(), propertyEntityToCompare.getCommunity()));
        assertNotNull(propertySaved.getCommunity().getCommunityId());
    }

    @Test
    public void should_store_a_PropertyAndViewData() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFields();
        propertyToSave.setViewData(createViewDataEntity());
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithAllNestedFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getViewData());
        assertTrue(baseTests.compareViewData(propertySaved.getViewData(), propertyEntityToCompare.getViewData()));
        assertNotNull(propertySaved.getViewData().getViewDataId());
    }

    @Test
    public void should_store_a_PropertyAndAnimalPolicy() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFields();
        propertyToSave.setAnimalPolicy(createAnimalPolicy("permitted"));
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithAllNestedFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getAnimalPolicy());
        assertTrue(baseTests.compareAnimalPolicy(propertySaved.getAnimalPolicy(), propertyEntityToCompare.getAnimalPolicy()));
        assertNotNull(propertySaved.getAnimalPolicy().getAnimalPolicyId());
    }

    @Test
    public void should_store_a_PropertyAndLotData() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFields();
        propertyToSave.setLotData(createLotDataEntity());
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithAllNestedFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getLotData());
        assertTrue(baseTests.compareLotData(propertySaved.getLotData(), propertyEntityToCompare.getLotData()));
        assertNotNull(propertySaved.getLotData().getLotDataId());
    }

    @Test
    public void should_store_a_PropertyAndContactInformation() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFields();
        propertyToSave.setContactInformation(createContactInformationEntity());
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithAllNestedFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getContactInformation());
        assertNotNull(propertySaved.getContactInformation().getContactInformationId());
        assertTrue(baseTests.compareContactInformation(propertySaved.getContactInformation(), propertyEntityToCompare.getContactInformation()));
        assertNotNull(propertySaved.getContactInformation().getContactInformationId());
    }

    protected void checkAllBasicFieldsFromProperty(PropertyEntity property){
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

}
