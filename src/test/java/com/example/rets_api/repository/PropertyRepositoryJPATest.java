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
        List<PropertyEntity> properties = propertyRepository.findAll();

        //Validating
        assertTrue(properties.isEmpty());
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
        assertNotNull(propertySaved.getLotData().getLotDataId());
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

        assertNotNull(propertySaved.getAnimalPolicy());
        compareAnimalPolicy(propertySaved.getAnimalPolicy(), propertyEntityToCompare.getAnimalPolicy());

        assertNotNull(propertySaved.getPropertyId());
        assertNotNull(propertySaved.getAnimalPolicy().getAnimalPolicyId());
        assertNotNull(propertySaved.getFinancialData().getFinancialDataId());
        assertNotNull(propertySaved.getLotData().getLotDataId());
        assertNotNull(propertySaved.getRoomList().get(0).getRoomId());
        assertNotNull(propertySaved.getRoomList().get(1).getRoomId());
        assertNotNull(propertySaved.getSchoolList().get(0).getSchoolId());
        assertNotNull(propertySaved.getViewData().getViewDataId());


        assertNotNull(propertySaved.getContactInformation());
        assertNotNull(propertySaved.getContactInformation().getContactInformationId());
        compareContactInformation(propertySaved.getContactInformation(), propertyEntityToCompare.getContactInformation());


        assertNotNull(propertySaved.getCommunity());
        assertEquals(propertySaved.getCommunity(), propertyToSave.getCommunity());
        assertNotNull(propertySaved.getCommunity().getCommunityId());
        compareCommunity(propertySaved.getCommunity(), propertyEntityToCompare.getCommunity());

        assertNotNull(propertySaved.getListingPrice());
        assertNotNull(propertySaved.getListingPrice().getListPriceId());
        compareListPrice(propertySaved.getListingPrice(), propertyEntityToCompare.getListingPrice());

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

    public void compareAnimalPolicy(AnimalPolicyEntity entity1, AnimalPolicyEntity entity2) {
        assertEquals(entity1.getAnimalsPermitted(), entity2.getAnimalsPermitted());
        assertEquals(entity1.getPermittedTypes(), entity2.getPermittedTypes());
        assertEquals(entity1.getWeightLimit(), entity2.getWeightLimit());
        assertEquals(entity1.getWeightUnit(), entity2.getWeightUnit());
    }


    public static void compareContactInformation(ContactInformationEntity entity1, ContactInformationEntity entity2) {
        assertEquals(entity1.getAgentPhone().getPrimaryPhone(), entity2.getAgentPhone().getPrimaryPhone());
        assertEquals(entity1.getAgentPhone().getAlternatePhone(), entity2.getAgentPhone().getAlternatePhone());
        assertEquals(entity1.getListAgentPhone().getPrimaryPhone(), entity2.getListAgentPhone().getPrimaryPhone());
        assertEquals(entity1.getListAgentPhone().getAlternatePhone(), entity2.getListAgentPhone().getAlternatePhone());
        assertEquals(entity1.getSalesAgentPhone().getPrimaryPhone(), entity2.getSalesAgentPhone().getPrimaryPhone());
        assertEquals(entity1.getSalesAgentPhone().getAlternatePhone(), entity2.getSalesAgentPhone().getAlternatePhone());
        assertEquals(entity1.getOfficePhone().getPrimaryPhone(), entity2.getOfficePhone().getPrimaryPhone());
        assertEquals(entity1.getOfficePhone().getAlternatePhone(), entity2.getOfficePhone().getAlternatePhone());
        assertEquals(entity1.getListOfficePhone().getPrimaryPhone(), entity2.getListOfficePhone().getPrimaryPhone());
        assertEquals(entity1.getListOfficePhone().getAlternatePhone(), entity2.getListOfficePhone().getAlternatePhone());
        assertEquals(entity1.getSalesOfficePhone().getPrimaryPhone(), entity2.getSalesOfficePhone().getPrimaryPhone());
        assertEquals(entity1.getSalesOfficePhone().getAlternatePhone(), entity2.getSalesOfficePhone().getAlternatePhone());
    }

    public void compareCommunity(CommunityEntity entity1, CommunityEntity entity2) {
        assertEquals(entity1.getClubHouse(), entity2.getClubHouse());
        assertEquals(entity1.getCommunityParkIndicator(), entity2.getClubHouseIndicator());
        assertEquals(entity1.getExerciseArea(), entity2.getExerciseArea());
        assertEquals(entity1.getExerciseAreaIndicator(), entity2.getExerciseAreaIndicator());
        assertEquals(entity1.getGolf(), entity2.getGolf());
        assertEquals(entity1.getGolfIndicator(), entity2.getGolfIndicator());
        assertEquals(entity1.getTennis(), entity2.getTennis());
        assertEquals(entity1.getTennisIndicator(), entity2.getTennisIndicator());
        assertEquals(entity1.getRecreationalFacilities(), entity2.getRecreationalFacilities());
        assertEquals(entity1.getRecreationalFacilitiesIndicator(), entity2.getRecreationalFacilitiesIndicator());
        assertEquals(entity1.getSecurityFeatures(), entity2.getSecurityFeatures());
        assertEquals(entity1.getSecurityFeaturesIndicator(), entity2.getSecurityFeaturesIndicator());
        assertEquals(entity1.getSeniorCommunity(), entity2.getSeniorCommunity());
        assertEquals(entity1.getSeniorCommunityIndicator(), entity2.getSeniorCommunityIndicator());
        assertEquals(entity1.getHotTub(), entity2.getHotTub());
        assertEquals(entity1.getHotTubIndicator(),entity2.getHotTubIndicator());
        assertEquals(entity1.getPool(), entity2.getPool());
        assertEquals(entity1.getPoolIndicator(), entity2.getPoolIndicator());
        assertEquals(entity1.getBoatFacilities(), entity2.getBoatFacilities());
        assertEquals(entity1.getBoatFacilitiesIndicator(),entity2.getBoatFacilitiesIndicator());
        assertEquals(entity1.getHorseFacilities(), entity2.getHorseFacilities());
        assertEquals(entity1.getHorseFacilitiesIndicator(), entity2.getHorseFacilitiesIndicator());
        assertEquals(entity1.getCommunityPark(), entity2.getCommunityPark());
        assertEquals(entity1.getCommunityParkIndicator(), entity2.getCommunityParkIndicator());

    }

    public void compareListPrice(ListingPriceEntity entity1, ListingPriceEntity entity2){
        assertEquals(entity1.getLowAmount(), entity2.getLowAmount());
        assertEquals(entity1.getHighAmount(), entity2.getHighAmount());
        assertEquals(entity1.getLowAmountType(), entity2.getLowAmountType());
        assertEquals(entity1.getHighAmountType(), entity2.getHighAmountType());
        assertEquals(entity1.getLowAmountCurrencyCode(), entity2.getLowAmountCurrencyCode());
        assertEquals(entity1.getHighAmountCurrencyCode(), entity2.getHighAmountCurrencyCode());
        assertEquals(entity1.getUnits(), entity2.getUnits());
    }

}
