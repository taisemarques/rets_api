package com.example.rets_api.repository;


import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.resource.Enums;
import com.example.rets_api.utils.CompareEntitiesTest;
import com.example.rets_api.utils.EntityUtilsTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.rets_api.repository.PropertyRepositoryJPATest.checkAllBasicFieldsFromProperty;
import static com.example.rets_api.utils.EntityUtilsTest.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BasicPropertyWithOneEntityRepositoryJPATest{
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
        assertTrue(CompareEntitiesTest.compareFinancialData(propertySaved.getFinancialData(), propertyEntityToCompare.getFinancialData()));
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
        assertTrue(CompareEntitiesTest.compareRoom(propertySaved.getRoomList().get(0), propertyEntityToCompare.getRoomList().get(0)));
        assertTrue(CompareEntitiesTest.compareRoom(propertySaved.getRoomList().get(1), propertyEntityToCompare.getRoomList().get(1)));
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
        assertTrue(CompareEntitiesTest.compareSchool(propertySaved.getSchoolList().get(0), propertyEntityToCompare.getSchoolList().get(0)));
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
        assertTrue(CompareEntitiesTest.compareCommunity(propertySaved.getCommunity(), propertyEntityToCompare.getCommunity()));
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
        assertTrue(CompareEntitiesTest.compareViewData(propertySaved.getViewData(), propertyEntityToCompare.getViewData()));
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
        assertTrue(CompareEntitiesTest.compareAnimalPolicy(propertySaved.getAnimalPolicy(), propertyEntityToCompare.getAnimalPolicy()));
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
        assertTrue(CompareEntitiesTest.compareLotData(propertySaved.getLotData(), propertyEntityToCompare.getLotData()));
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
        assertTrue(CompareEntitiesTest.compareContactInformation(propertySaved.getContactInformation(), propertyEntityToCompare.getContactInformation()));
        assertNotNull(propertySaved.getContactInformation().getContactInformationId());
    }

    @Test
    public void should_store_a_PropertyAndListingPrice() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFields();
        propertyToSave.setListingPrice(createListingPriceEntity());
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithAllNestedFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getListingPrice());
        assertTrue(CompareEntitiesTest.compareListingPrice(propertySaved.getListingPrice(), propertyEntityToCompare.getListingPrice()));
        assertNotNull(propertySaved.getListingPrice().getListingPriceId());
    }


}
