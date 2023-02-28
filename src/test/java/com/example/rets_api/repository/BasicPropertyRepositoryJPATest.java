package com.example.rets_api.repository;

import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.utils.EntityUtilsTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BasicPropertyRepositoryJPATest{
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
    public void should_store_a_Property_With_Basic_Fields() {
        //Creating
        PropertyEntity propertyToSave = EntityUtilsTest.createPropertyEntityWithBasicFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        assertNotNull(propertySaved.getPropertyId());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("age", propertySaved.getAge());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("horseFacilities", propertySaved.getHorseFacilities());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("horseFacilitiesIndicator", propertySaved.getHorseFacilitiesIndicator());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("hotTub", propertySaved.getHotTub());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("hotTubIndicator", propertySaved.getHotTubIndicator());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("tennisCourt", propertySaved.getTennisCourt());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("tennisCourtIndicator", propertySaved.getTennisCourtIndicator());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("inclusions", propertySaved.getInclusions());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("energyInformation", propertySaved.getEnergyInformation());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("constructionMaterial", propertySaved.getConstructionMaterial());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("disabilityFeatures", propertySaved.getDisabilityFeatures());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("disabilityFeaturesIndicator", propertySaved.getDisabilityFeaturesIndicator());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("securityFeatures", propertySaved.getSecurityFeatures());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("securityFeaturesIndicator", propertySaved.getSecurityFeaturesIndicator());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("propertyTypeRental", propertySaved.getPropertyTypeRental());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("propertyTypeFarm", propertySaved.getPropertyTypeFarm());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("propertyTypeCondo", propertySaved.getPropertyTypeCondo());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("propertyTypeTownHouse", propertySaved.getPropertyTypeTownHouse());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("propertyTypeTownHouse", propertySaved.getPropertyTypeTownHouse());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("firePlaceFuelType", propertySaved.getFirePlaceFuelType());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("firePlaceDetails", propertySaved.getFirePlaceDetails());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("floorsHardwood", propertySaved.getFloorsHardwood());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("floorsHardwoodIndicator", propertySaved.getFloorsHardwoodIndicator());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("displayFlagListing", propertySaved.getDisplayFlagListing());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("displayFlagAddress", propertySaved.getDisplayFlagAddress());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("lotSizeRange", propertySaved.getLotSizeRange());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("lotSizeRangeUnits", propertySaved.getLotSizeRangeUnits());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("lotSizeWidthUnits", propertySaved.getLotSizeWidthUnits());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("diningRoomWidthUnits", propertySaved.getDiningRoomWidthUnits());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("familyRoomWidthUnits", propertySaved.getFamilyRoomWidthUnits());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("livingRoomWidthUnits", propertySaved.getLivingRoomWidthUnits());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("basementWidthUnits", propertySaved.getBasementWidthUnits());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("lotSizeLengthUnits", propertySaved.getLotSizeLengthUnits());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("diningRoomLengthUnits", propertySaved.getDiningRoomLengthUnits());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("livingRoomLengthUnits", propertySaved.getLivingRoomLengthUnits());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("familyRoomLengthUnits", propertySaved.getFamilyRoomLengthUnits());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("basementLengthUnits", propertySaved.getBasementLengthUnits());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("parkingTotal", propertySaved.getParkingTotal());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("parkingTotalOperator", propertySaved.getParkingTotalOperator());

    }

}
