package com.example.rets_api.repository;

import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.utils.CompareEntitiesUtilsTest;
import com.example.rets_api.utils.EntityUtilsTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static com.example.rets_api.repository.PropertyRepositoryJPATest.checkAllBasicFieldsFromProperty;
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
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndFinancialData();
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndFinancialData();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getFinancialData());
        assertTrue(CompareEntitiesUtilsTest.compareFinancialData(propertySaved.getFinancialData(), propertyEntityToCompare.getFinancialData()));
        assertNotNull(propertySaved.getFinancialData().getFinancialDataId());
    }

    @Test
    public void should_store_a_PropertyAndRoom() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndRoom();
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndRoom();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getRoomList());
        assertEquals(propertySaved.getRoomList().size(), propertyEntityToCompare.getRoomList().size());
        assertTrue(CompareEntitiesUtilsTest.compareRoom(propertySaved.getRoomList().get(0), propertyEntityToCompare.getRoomList().get(0)));
        assertTrue(CompareEntitiesUtilsTest.compareRoom(propertySaved.getRoomList().get(1), propertyEntityToCompare.getRoomList().get(1)));
        assertNotNull(propertySaved.getRoomList().get(0).getRoomId());
        assertNotNull(propertySaved.getRoomList().get(1).getRoomId());
    }

    @Test
    public void should_store_a_PropertyAndSchool() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndSchool();
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndSchool();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getSchoolList());
        assertEquals(propertySaved.getSchoolList().size(), propertyEntityToCompare.getSchoolList().size());
        assertTrue(CompareEntitiesUtilsTest.compareSchool(propertySaved.getSchoolList().get(0), propertyEntityToCompare.getSchoolList().get(0)));
        assertNotNull(propertySaved.getSchoolList().get(0).getSchoolId());
    }

    @Test
    public void should_store_a_PropertyAndCommunity() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndCommunity();
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndCommunity();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getCommunity());
        assertNotNull(propertySaved.getCommunity().getCommunityId());
        assertTrue(CompareEntitiesUtilsTest.compareCommunity(propertySaved.getCommunity(), propertyEntityToCompare.getCommunity()));
    }

    @Test
    public void should_store_a_PropertyAndViewData() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndViewData();
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndViewData();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getViewData());
        assertTrue(CompareEntitiesUtilsTest.compareViewData(propertySaved.getViewData(), propertyEntityToCompare.getViewData()));
        assertNotNull(propertySaved.getViewData().getViewDataId());
    }

    @Test
    public void should_store_a_PropertyAndAnimalPolicy() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndAnimalPolicy();
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndAnimalPolicy();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getAnimalPolicy());
        assertTrue(CompareEntitiesUtilsTest.compareAnimalPolicy(propertySaved.getAnimalPolicy(), propertyEntityToCompare.getAnimalPolicy()));
        assertNotNull(propertySaved.getAnimalPolicy().getAnimalPolicyId());
    }

    @Test
    public void should_store_a_PropertyAndLotData() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndLotData();
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndLotData();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getLotData());
        assertTrue(CompareEntitiesUtilsTest.compareLotData(propertySaved.getLotData(), propertyEntityToCompare.getLotData()));
        assertNotNull(propertySaved.getLotData().getLotDataId());
    }

    @Test
    public void should_store_a_PropertyAndContactInformation() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndContactInformation();
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndContactInformation();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getContactInformation());
        assertNotNull(propertySaved.getContactInformation().getContactInformationId());
        assertTrue(CompareEntitiesUtilsTest.compareContactInformation(propertySaved.getContactInformation(), propertyEntityToCompare.getContactInformation()));
    }

    @Test
    public void should_store_a_PropertyAndListingPrice() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndListingPrice();
        PropertyEntity propertyEntityToCompare = EntityUtilsTest.createPropertyEntityWithBasicFieldsAndListingPrice();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getListingPrice());
        assertTrue(CompareEntitiesUtilsTest.compareListingPrice(propertySaved.getListingPrice(), propertyEntityToCompare.getListingPrice()));
        assertNotNull(propertySaved.getListingPrice().getListingPriceId());
    }


}
