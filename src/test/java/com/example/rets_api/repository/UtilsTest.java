package com.example.rets_api.repository;

import com.example.rets_api.entity.*;
import com.example.rets_api.resource.Enums.*;

public class UtilsTest {

    public static PropertyEntity createPropertyEntityWithBasicFields(){
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setAge(5);
        propertyEntity.setHorseFacilities("horseFacilities");
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
        room.setIndicator(Indicator.YES);
        return room;
    }

    public static AnimalPolicyEntity createAnimalPolicy(String permittedType){
        AnimalPolicyEntity animalPolicy = new AnimalPolicyEntity();
        animalPolicy.setAnimalsPermitted(Indicator.YES);
        animalPolicy.setPermittedTypes(permittedType);
        animalPolicy.setWeightUnit(WeightUnit.KILO);
        animalPolicy.setWeightLimit(10L);
        return animalPolicy;
    }

    public static FinancialDataEntity createFinancialDataEntity(String leaseOption) {
        FinancialDataEntity financialData = new FinancialDataEntity();
        financialData.setLeaseOption(leaseOption);
        financialData.setLeaseIndicator(Indicator.YES);
        financialData.setRentalAmount(200L);
        financialData.setRentalAmountCurrencyCode("CAN");
        financialData.setRentalAmountPeriod(RentalPeriod.MONTH);
        financialData.setRentalAmountType(NumberType.FLOAT);
        financialData.setRentalAmountUnit(AreaUnit.SQ_FEET);
        financialData.setTradeIndicator(Indicator.YES);
        financialData.setTradeOption("tradeOption");
        return financialData;
    }


    public static SchoolEntity createSchool(String primary, String jrHigh){
        SchoolEntity school = new SchoolEntity();
        school.setPrimarySchool(primary);
        school.setJrHigh(jrHigh);
        return school;
    }

}
