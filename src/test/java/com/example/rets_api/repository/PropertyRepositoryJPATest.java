package com.example.rets_api.repository;

import com.example.rets_api.entity.PropertyEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static com.example.rets_api.repository.UtilsTest.createRoom;
import static org.assertj.core.api.Assertions.assertThat;
import static com.example.rets_api.entity.Enums.RoomType;

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
        assertThat(authors).isEmpty();
    }

    @Test
    public void should_store_a_Property() {
        //Creating Property
        PropertyEntity propertyToSave = UtilsTest.createPropertyEntityWithBasicFields();

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating
        checkAllBasicFieldsFromProperty(propertySaved);
    }

    @Test
    public void should_store_a_PropertyAndSchoolAndRoom() {
        //Creating property
        PropertyEntity propertyToSave = UtilsTest.createPropertyEntityWithBasicFields();

        //Setting school
        propertyToSave.setSchoolList(Arrays.asList(UtilsTest.createSchool("primarySchool", "jrHighSchool")));

        //Setting rooms
        propertyToSave.setRoomList(Arrays.asList(createRoom(RoomType.LIVING_ROOM), createRoom(RoomType.MAIN_FLOOR_BEDROOM)));
        propertyToSave.setBedroomsQty(1);

        //Saving
        PropertyEntity propertySaved = propertyRepository.saveAndFlush(propertyToSave);

        //Validating Property basic fields
        checkAllBasicFieldsFromProperty(propertySaved);

        //Validating School
        assertThat(propertySaved.getSchoolList()).isNotNull();
        assertThat(propertySaved.getSchoolList().size() == propertyToSave.getSchoolList().size());
        assertThat(propertySaved.getSchoolList().get(0).getPrimarySchool() == propertyToSave.getSchoolList().get(0).getPrimarySchool());
        assertThat(propertySaved.getSchoolList().get(0).getJrHigh() == propertyToSave.getSchoolList().get(0).getPrimarySchool());

        //Validating Rooms
        assertThat(propertySaved.getRoomList()).isNotNull();
        assertThat(propertySaved.getRoomList().size() == propertyToSave.getRoomList().size());
        assertThat(propertySaved.getRoomList().get(0).getRoomType() == propertyToSave.getRoomList().get(0).getRoomType());
        assertThat(propertySaved.getRoomList().get(1).getRoomType() == propertyToSave.getRoomList().get(1).getRoomType());

    }

    public void checkAllBasicFieldsFromProperty(PropertyEntity property){
        assertThat(property.getPropertyId()).isNotNull();
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
