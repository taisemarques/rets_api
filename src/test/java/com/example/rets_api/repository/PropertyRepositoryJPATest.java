package com.example.rets_api.repository;

import com.example.rets_api.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        List<PropertyEntity> authors = propertyRepository.findAll();

        //Validating
        assertTrue(authors.isEmpty());
    }

    @Test
    public void should_store_a_Property() {
        //Creating
        PropertyEntity propertyToSave = UtilsTest.createPropertyEntityWithBasicFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);
    }

    @Test
    public void should_store_a_PropertyAndSchoolAndRoomAndViewData() {
        //Creating
        PropertyEntity propertyToSave = UtilsTest.createPropertyEntityWithBasicFields();
        PropertyEntity propertyEntityToCompare = UtilsTest.createPropertyEntityWithBasicFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getViewData());
        compareViewData(propertySaved.getViewData(), propertyEntityToCompare.getViewData());

        assertNotNull(propertySaved.getLotData());
        compareLotData(propertySaved.getLotData(), propertyEntityToCompare.getLotData());

        assertNotNull(propertySaved.getSchoolList());
        assertEquals(propertySaved.getSchoolList().size(), propertyEntityToCompare.getSchoolList().size());
        compareSchool(propertySaved.getSchoolList().get(0), propertyEntityToCompare.getSchoolList().get(0));

        assertNotNull(propertySaved.getRoomList());
        assertEquals(propertySaved.getRoomList().size(), propertyEntityToCompare.getRoomList().size());
        compareRoom(propertySaved.getRoomList().get(0), propertyEntityToCompare.getRoomList().get(0));
        compareRoom(propertySaved.getRoomList().get(1), propertyEntityToCompare.getRoomList().get(1));

        assertNotNull(propertySaved.getFinancialData());
        compareFinancialData(propertySaved.getFinancialData(), propertyEntityToCompare.getFinancialData());
        compareFinancialData(propertySaved.getFinancialData(), propertyEntityToCompare.getFinancialData());

    }

    private void checkAllBasicFieldsFromProperty(PropertyEntity property){
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
   }
    public void compareViewData(ViewDataEntity entity1, ViewDataEntity entity2) {
        assertEquals(entity1.getCityLight(), entity2.getCityLight());
        assertEquals(entity1.getCityLightIndicator(), entity2.getCityLightIndicator());
        assertEquals(entity1.getMountain(), entity2.getMountain());
        assertEquals(entity1.getMountainIndicator(), entity2.getMountainIndicator());
        assertEquals(entity1.getRiver(), entity2.getRiver());
        assertEquals(entity1.getRiverIndicator(), entity2.getRiverIndicator());
        assertEquals(entity1.getLake(), entity2.getLake());
        assertEquals(entity1.getLakeIndicator(), entity2.getLakeIndicator());
        assertEquals(entity1.getGolfCourse(), entity2.getGolfCourse());
        assertEquals(entity1.getGolfCourseIndicator(), entity2.getGolfCourseIndicator());
        assertEquals(entity1.getWater(), entity2.getWater());
        assertEquals(entity1.getWaterIndicator(), entity2.getWaterIndicator());
    }

    public void compareLotData(LotDataEntity entity1, LotDataEntity entity2) {
        assertEquals(entity1.getCornerLot(), entity2.getCornerLot());
        assertEquals(entity1.getCornerLotIndicator(), entity2.getCornerLotIndicator());
        assertEquals(entity1.getCuldeSac(), entity2.getCuldeSac());
        assertEquals(entity1.getCuldeSacIndicator(), entity2.getCuldeSacIndicator());
        assertEquals(entity1.getGolfCourseLot(), entity2.getGolfCourseLot());
        assertEquals(entity1.getGolfCourseLotIndicator(), entity2.getGolfCourseLotIndicator());
    }

    public void compareSchool(SchoolEntity entity1, SchoolEntity entity2) {
        assertEquals(entity1.getPrimarySchool(), entity2.getPrimarySchool());
        assertEquals(entity1.getJrHigh(), entity2.getJrHigh());
    }

    public void compareRoom(RoomEntity entity1, RoomEntity entity2) {
        assertEquals(entity1.getRoomType(), entity2.getRoomType());
        assertEquals(entity1.getIndicator(), entity2.getIndicator());
        assertEquals(entity1.getDimensions(), entity2.getDimensions());
        assertEquals(entity1.getLength(), entity2.getLength(),0);
        assertEquals(entity1.getLengthUnit(), entity2.getLengthUnit());
        assertEquals(entity1.getWidth(), entity2.getWidth(),0);
        assertEquals(entity1.getWidthUnit(), entity2.getWidthUnit());
        assertEquals(entity1.getArea(), entity2.getArea(),0);
        assertEquals(entity1.getAreaUnit(), entity2.getAreaUnit());
        assertEquals(entity1.getAreaType(), entity2.getAreaType());
        assertEquals(entity1.getBathSize(), entity2.getBathSize());
    }

    public void compareFinancialData(FinancialDataEntity entity1, FinancialDataEntity entity2) {
        assertEquals(entity1.getLeaseOption(), entity2.getLeaseOption());
        assertEquals(entity1.getLeaseIndicator(), entity2.getLeaseIndicator());
        assertEquals(entity1.getTradeOption(), entity2.getTradeOption());
        assertEquals(entity1.getTradeIndicator(), entity2.getTradeIndicator());
        assertEquals(entity1.getRentalAmount(), entity2.getRentalAmount());
        assertEquals(entity1.getRentalAmountType(), entity2.getRentalAmountType());
        assertEquals(entity1.getRentalAmountCurrencyCode(), entity2.getRentalAmountCurrencyCode());
        assertEquals(entity1.getRentalAmountPeriod(), entity2.getRentalAmountPeriod());
        assertEquals(entity1.getRentalAmountUnit(), entity2.getRentalAmountUnit());
    }
}
