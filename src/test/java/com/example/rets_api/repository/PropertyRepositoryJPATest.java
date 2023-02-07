package com.example.rets_api.repository;

import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.entity.RoomEntity;
import com.example.rets_api.entity.SchoolEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PropertyRepositoryJPATest {

    @Autowired
    PropertyRepositoryJPA propertyRepository;

    @Test
    public void should_find_no_Property_if_repository_is_empty(){
        List<PropertyEntity> authors = propertyRepository.findAll();
        assertThat(authors).isEmpty();
    }

    @Test
    public void should_store_a_Property() {
        PropertyEntity propertyToSave = new PropertyEntity();
        propertyToSave.setDescription("Description");
        propertyToSave.setPrice(valueOf(460000));
        PropertyEntity propertySaved = propertyRepository.save(propertyToSave);
        assertThat(propertySaved.getPropertyId()).isNotNull();
        assertThat(propertySaved).hasFieldOrPropertyWithValue("description", propertyToSave.getDescription());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("price", propertyToSave.getPrice());
    }

    @Test
    public void should_store_a_PropertyAndSchool() {
        PropertyEntity propertyToSave = new PropertyEntity();
        propertyToSave.setDescription("Description");
        propertyToSave.setPrice(valueOf(460000));

        SchoolEntity schoolEntity = new SchoolEntity();
        schoolEntity.setPrimarySchool("primarySchool");
        schoolEntity.setJrHigh("jrHighSchool");

        List<SchoolEntity> schoolEntityList = new ArrayList<>();
        schoolEntityList.add(schoolEntity);
        propertyToSave.setSchoolList(schoolEntityList);

        List<PropertyEntity> propertyEntityList = new ArrayList<>();
        propertyEntityList.add(propertyToSave);
        schoolEntity.setPropertyList(propertyEntityList);

        RoomEntity livingRoom = new RoomEntity();
        livingRoom.setArea(45);
        livingRoom.setRoomType(RoomEntity.RoomType.LIVING_ROOM);
        livingRoom.setLength(5);
        livingRoom.setWidth(9);

        RoomEntity bedroom = new RoomEntity();
        bedroom.setWidth(5);
        bedroom.setLength(6);
        bedroom.setArea(30);
        bedroom.setRoomType(RoomEntity.RoomType.BEDROOM);

        List<RoomEntity> rooms = new ArrayList<>();
        rooms.add(livingRoom);
        rooms.add(bedroom);

        propertyToSave.setRoomList(rooms);
        propertyToSave.setBedroomsQty(1);

        PropertyEntity propertySaved = propertyRepository.save(propertyToSave);
        assertThat(propertySaved.getPropertyId()).isNotNull();
        assertThat(propertySaved).hasFieldOrPropertyWithValue("description", propertyToSave.getDescription());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("price", propertyToSave.getPrice());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("schoolList", propertyToSave.getSchoolList());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("roomList", propertyToSave.getRoomList());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("bedroomsQty", propertyToSave.getBedroomsQty());
        assertThat(propertySaved).hasFieldOrPropertyWithValue("bathroomsQty", propertyToSave.getBathroomsQty());

    }

}
