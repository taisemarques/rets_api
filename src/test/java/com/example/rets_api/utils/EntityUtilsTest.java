package com.example.rets_api.utils;


import com.example.rets_api.entity.*;
import com.example.rets_api.resource.Enums.*;

import java.util.Arrays;

import static java.util.Arrays.asList;

public class EntityUtilsTest {

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
        propertyEntity.setBedroomsQty(1);

        return propertyEntity;
    }

    public static PropertyEntity createPropertyEntityWithAllNestedFields(){
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
        propertyEntity.setFinancialData(createFinancialDataEntity());
        propertyEntity.setRoomList(asList(createRoomEntity(RoomType.LIVING_ROOM), createRoomEntity((RoomType.MAIN_FLOOR_BEDROOM))));
        propertyEntity.setBedroomsQty(1);
        propertyEntity.setSchoolList(asList(createSchoolEntity("primary", "jrHigh")));
        propertyEntity.setAnimalPolicy(createAnimalPolicyEntity());
        propertyEntity.setLotData(createLotDataEntity());
        propertyEntity.setViewData(createViewDataEntity());
        propertyEntity.setContactInformation(createContactInformationEntity());
        propertyEntity.setCommunity(createCommunityEntity());

        propertyEntity.setFirePlaceFuelType("Fuel");
        propertyEntity.setFirePlaceDetails("Fire place details");
        propertyEntity.setFloorsHardwood("Hardwood");
        propertyEntity.setFloorsHardwoodIndicator(Indicator.YES);
        propertyEntity.setDisplayFlagListing(true);
        propertyEntity.setDisplayFlagAddress(true);
        propertyEntity.setLotSizeRange("range");
        propertyEntity.setLotSizeRangeUnits(AreaUnit.SQ_METERS);
        propertyEntity.setLotSizeWidthUnits(LengthWidthUnit.METERS);
        propertyEntity.setDiningRoomWidthUnits(LengthWidthUnit.METERS);
        propertyEntity.setFamilyRoomWidthUnits(LengthWidthUnit.METERS);
        propertyEntity.setLivingRoomWidthUnits(LengthWidthUnit.METERS);
        propertyEntity.setBasementWidthUnits(LengthWidthUnit.METERS);
        propertyEntity.setLotSizeLengthUnits(LengthWidthUnit.METERS);
        propertyEntity.setDiningRoomLengthUnits(LengthWidthUnit.METERS);
        propertyEntity.setLivingRoomLengthUnits(LengthWidthUnit.METERS);
        propertyEntity.setFamilyRoomLengthUnits(LengthWidthUnit.METERS);
        propertyEntity.setBasementLengthUnits(LengthWidthUnit.METERS);
        propertyEntity.setParkingTotal(2);
        propertyEntity.setParkingTotalOperator(Operator.DEFAULT_ENUM_VALUE);
        return propertyEntity;
    }

    public static PropertyEntity createPropertyEntityResponseAndID(Long id){
        PropertyEntity propertyEntity = createPropertyEntityWithAllNestedFields();
        propertyEntity.setPropertyId(id);
        return propertyEntity;
    }

    public static RoomEntity createRoomEntity(RoomType roomType){
        RoomEntity room = new RoomEntity();
        room.setRoomType(roomType);
        room.setIndicator(Indicator.YES);
        room.setDimensions("dimensions");
        room.setLength(5);
        room.setLengthUnit(LengthWidthUnit.METERS);
        room.setWidth(9);
        room.setWidthUnit(LengthWidthUnit.METERS);
        room.setArea(45);
        room.setAreaUnit(AreaUnit.SQ_METERS);
        room.setAreaType(AreaType.FLOAT);
        room.setBathSize(BathSize.THREE_QUARTER);
        room.setIndicator(Indicator.YES);
        return room;
    }

    public static CommunityEntity createCommunityEntity() {
        CommunityEntity community = new CommunityEntity();
        community.setClubHouse("club house");
        community.setClubHouseIndicator(Indicator.YES);
        community.setExerciseArea("exercise area");
        community.setExerciseAreaIndicator(Indicator.YES);
        community.setGolf("golf house");
        community.setGolfIndicator(Indicator.YES);
        community.setTennis("tennis area");
        community.setTennisIndicator(Indicator.YES);
        community.setRecreationalFacilities("recreational house");
        community.setRecreationalFacilitiesIndicator(Indicator.YES);
        community.setSeniorCommunity("senior house");
        community.setSeniorCommunityIndicator(Indicator.YES);
        community.setSecurityFeatures("security");
        community.setSecurityFeaturesIndicator(Indicator.YES);
        community.setHotTub("hotTub");
        community.setHotTubIndicator(Indicator.YES);
        community.setPool("pool");
        community.setPoolIndicator(Indicator.YES);
        community.setBoatFacilities("boats");
        community.setBoatFacilitiesIndicator(Indicator.YES);
        community.setHorseFacilities("horses");
        community.setHorseFacilitiesIndicator(Indicator.YES);
        community.setCommunityPark("parks");
        community.setCommunityParkIndicator(Indicator.YES);

        return community;
    }

    public static AnimalPolicyEntity createAnimalPolicy(String permittedType){
        AnimalPolicyEntity animalPolicy = new AnimalPolicyEntity();
        animalPolicy.setAnimalsPermitted(Indicator.YES);
        animalPolicy.setPermittedTypes(permittedType);
        animalPolicy.setWeightUnit(WeightUnit.KILO);
        animalPolicy.setWeightLimit(10L);
        animalPolicy.setProperties(Arrays.asList(createPropertyEntityWithAllNestedFields()));
        return animalPolicy;
    }

    public static SchoolEntity createSchoolEntity(String primary, String jrHigh){
        SchoolEntity school = new SchoolEntity();
        school.setPrimarySchool(primary);
        school.setJrHigh(jrHigh);
        return school;
    }

    public static LotDataEntity createLotDataEntity() {
        LotDataEntity lotData = new LotDataEntity();
        lotData.setCornerLot("corner lot test");
        lotData.setCornerLotIndicator(Indicator.UNKNOWN);
        lotData.setGolfCourseLot("golf course lot test");
        lotData.setGolfCourseLotIndicator(Indicator.NO);
        lotData.setCuldeSac("cul de sac test");
        lotData.setCuldeSacIndicator(Indicator.YES);

        return lotData;
    }

    public static AnimalPolicyEntity createAnimalPolicyEntity() {
        AnimalPolicyEntity animalPolicy = new AnimalPolicyEntity();
        animalPolicy.setAnimalsPermitted(Indicator.YES);
        animalPolicy.setPermittedTypes("permitted");
        animalPolicy.setWeightLimit(10L);
        animalPolicy.setWeightUnit(WeightUnit.KILO);
        return animalPolicy;
    }

    public static FinancialDataEntity createFinancialDataEntity(){
        FinancialDataEntity financialDataEntity = new FinancialDataEntity();
        financialDataEntity.setLeaseOption("leaseOption");
        financialDataEntity.setLeaseIndicator(Indicator.NO);
        financialDataEntity.setTradeOption("tradeOption");
        financialDataEntity.setTradeIndicator(Indicator.YES);
        financialDataEntity.setRentalAmount(Long.valueOf(1000));
        financialDataEntity.setRentalAmountType(NumberType.INTEGER);
        financialDataEntity.setRentalAmountCurrencyCode("rentalAmountCurrencyCode");
        financialDataEntity.setRentalAmountPeriod(RentalPeriod.YEAR);
        financialDataEntity.setRentalAmountUnit(AreaUnit.SQ_METERS);
        return financialDataEntity;
    }

    public static ViewDataEntity createViewDataEntity(){
        ViewDataEntity viewData = new ViewDataEntity();
        viewData.setCityLight("Light");
        viewData.setCityLightIndicator(Indicator.YES);
        viewData.setMountain("Mountain");
        viewData.setMountainIndicator(Indicator.YES);
        viewData.setRiver("River");
        viewData.setRiverIndicator(Indicator.YES);
        viewData.setLake("Lake");
        viewData.setLakeIndicator(Indicator.YES);
        viewData.setGolfCourse("Golf");
        viewData.setGolfCourseIndicator(Indicator.YES);
        viewData.setWater("Water");
        viewData.setWaterIndicator(Indicator.YES);
        return viewData;
    }

    public static ContactInformationEntity createContactInformationEntity(){
        ContactInformationEntity contactInformation = new ContactInformationEntity();
        contactInformation.setAgentPhone(createPhoneEntity("5140001111", "5140002222"));
        contactInformation.setListAgentPhone(createPhoneEntity("5140003333", "5140004444"));
        contactInformation.setSalesAgentPhone(createPhoneEntity("5140005555", "5140006666"));
        contactInformation.setOfficePhone(createPhoneEntity("5140007777", "5140008888"));
        contactInformation.setListOfficePhone(createPhoneEntity("5140009999", "5140009898"));
        contactInformation.setSalesOfficePhone(createPhoneEntity("5140009987", "5140009989"));
        return contactInformation;
    }

    public static PhoneEntity createPhoneEntity(String primaryPhone, String alternatePhone){
        PhoneEntity phone = new PhoneEntity();
        phone.setPrimaryPhone(primaryPhone);
        phone.setAlternatePhone(alternatePhone);
        phone.setAgentPhoneContactInformationEntity(new ContactInformationEntity());
        phone.setListAgentPhoneContactInformationEntity(new ContactInformationEntity());
        phone.setSalesAgentPhoneContactInformationEntity(new ContactInformationEntity());
        phone.setOfficePhoneContactInformationEntity(new ContactInformationEntity());
        phone.setListOfficePhoneContactInformationEntity(new ContactInformationEntity());
        phone.setSalesOfficePhoneContactInformationEntity(new ContactInformationEntity());
        return phone;
    }

}
