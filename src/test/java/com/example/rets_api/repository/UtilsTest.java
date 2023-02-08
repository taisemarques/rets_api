package com.example.rets_api.repository;

import com.example.rets_api.entity.Enums.*;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.entity.RoomEntity;
import com.example.rets_api.entity.SchoolEntity;

public class UtilsTest {

    public static PropertyEntity createPropertyEntityWithBasicFields(){
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setAge(5);
        propertyEntity.setHorseFacilities("");
        propertyEntity.setHorseFacilitiesIndicator(Indicator.NO);
        propertyEntity.setHotTub("HotTub");
        propertyEntity.setHotTubIndicator(Indicator.YES);
        propertyEntity.setTennisCourt("Tennis");
        propertyEntity.setTennisCourtIndicator(Indicator.UNKNOWN);
        propertyEntity.setInclusions("Inclusions");
        propertyEntity.setEnergyInformation("Energy");
        propertyEntity.setConstructionMaterial("Material");
        propertyEntity.setDisabilityFeatures("Disability");
        propertyEntity.setDisabilityFeaturesIndicator(Indicator.YES);
        propertyEntity.setSecurityFeatures("Security");
        propertyEntity.setSecurityFeaturesIndicator(Indicator.YES);
        propertyEntity.setPropertyTypeRental(true);
        propertyEntity.setPropertyTypeFarm(false);
        propertyEntity.setPropertyTypeCondo(false);
        propertyEntity.setPropertyTypeTownHouse(true);
        return propertyEntity;
    }

    public static RoomEntity createRoom(RoomType roomType){
        RoomEntity room = new RoomEntity();
        room.setArea(45);
        room.setRoomType(roomType);
        room.setLength(5);
        room.setWidth(9);
        return room;
    }

    public static SchoolEntity createSchool(String primary, String jrHigh){
        SchoolEntity school = new SchoolEntity();
        school.setPrimarySchool(primary);
        school.setJrHigh(jrHigh);
        return school;
    }

}
