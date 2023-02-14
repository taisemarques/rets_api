package com.example.rets_api.repository;

import com.example.rets_api.entity.PropertyEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static com.example.rets_api.repository.UtilsTest.createRoomEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static com.example.rets_api.resource.Enums.RoomType;
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
    public void should_store_a_PropertyAndSchoolAndRoom() {
        //Creating
        PropertyEntity propertyToSave = UtilsTest.createPropertyEntityWithBasicFields();

        propertyToSave.setSchoolList(Arrays.asList(UtilsTest.createSchoolEntity("primarySchool", "jrHighSchool")));
        propertyToSave.setRoomList(Arrays.asList(createRoomEntity(RoomType.LIVING_ROOM), createRoomEntity(RoomType.MAIN_FLOOR_BEDROOM)));
        propertyToSave.setLotData(UtilsTest.createLotDataEntity());

        propertyToSave.setBedroomsQty(1);

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);

        assertNotNull(propertySaved.getSchoolList());
        assertEquals(propertySaved.getSchoolList().size(), propertyToSave.getSchoolList().size());
        assertEquals(propertySaved.getSchoolList().get(0).getPrimarySchool(), propertyToSave.getSchoolList().get(0).getPrimarySchool());
        assertEquals(propertySaved.getSchoolList().get(0).getJrHigh(), propertyToSave.getSchoolList().get(0).getJrHigh());

        assertNotNull(propertySaved.getRoomList());
        assertEquals(propertySaved.getRoomList().size(), propertyToSave.getRoomList().size());
        assertEquals(propertySaved.getRoomList().get(0).getRoomType(), propertyToSave.getRoomList().get(0).getRoomType());
        assertEquals(propertySaved.getRoomList().get(1).getRoomType(), propertyToSave.getRoomList().get(1).getRoomType());

        assertNotNull(propertySaved.getLotData());
        assertEquals(propertySaved.getLotData(), propertyToSave.getLotData());

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

}
