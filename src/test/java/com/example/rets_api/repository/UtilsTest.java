package com.example.rets_api.repository;


import com.example.rets_api.dto.*;
import com.example.rets_api.entity.*;
import com.example.rets_api.resource.Enums.*;
import com.example.rets_api.resource.PropertyFilter;

import java.util.Arrays;

import static java.util.Arrays.asList;

public class UtilsTest {

    //Entity

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
        propertyEntity.setFinancialData(createFinancialDataEntity());
        propertyEntity.setRoomList(asList(createRoomEntity(RoomType.LIVING_ROOM), createRoomEntity((RoomType.MAIN_FLOOR_BEDROOM))));
        propertyEntity.setBedroomsQty(1);
        propertyEntity.setSchoolList(asList(createSchoolEntity("primary", "jrHigh")));
        propertyEntity.setAnimalPolicy(createAnimalPolicyEntity());
        propertyEntity.setLotData(createLotDataEntity());
        propertyEntity.setViewData(createViewDataEntity());
        propertyEntity.setCommunity(createCommunityEntity());
        return propertyEntity;
    }

    public static PropertyEntity createPropertyEntityResponseAndID(Long id){
        PropertyEntity propertyEntity = createPropertyEntityWithBasicFields();
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
        community.setCommunityParkIndicator(Indicator.YES);
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
        animalPolicy.setProperties(Arrays.asList(createPropertyEntityWithBasicFields()));
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

    public static LotDataDTO createLotDataDTO(){
        return LotDataDTO.builder()
        .cornerLot("corner lot test")
        .cornerLotIndicator(Indicator.UNKNOWN)
        .golfCourseLot("golf course lot test")
        .golfCourseLotIndicator(Indicator.NO)
        .culdeSac("cul de sac test")
        .culdeSacIndicator(Indicator.YES)
        .build();
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
        financialDataEntity.setRentalAmount(Long.valueOf(1000));
        financialDataEntity.setRentalAmountType(NumberType.INTEGER);
        financialDataEntity.setRentalAmountCurrencyCode("rentalAmountCurrencyCode");
        financialDataEntity.setRentalAmountPeriod(RentalPeriod.YEAR);
        financialDataEntity.setRentalAmountUnit(AreaUnit.SQ_METERS);
        return financialDataEntity;
    }

    //DTO

    public static PropertyDTO createPropertyDTOWithBasicFields(){
        return PropertyDTO.builder()
            .age(5)
            .horseFacilities("horseFacilities")
            .horseFacilitiesIndicator(Indicator.NO)
            .hotTub("HotTub")
            .hotTubIndicator(Indicator.YES)
            .tennisCourt("Tennis")
            .tennisCourtIndicator(Indicator.UNKNOWN)
            .inclusions("Inclusions")
            .energyInformation("Energy")
            .constructionMaterial("Material")
            .disabilityFeatures("Disability")
            .disabilityFeaturesIndicator(Indicator.YES)
            .securityFeatures("Security")
            .securityFeaturesIndicator(Indicator.YES)
            .propertyTypeRental(true)
            .propertyTypeFarm(false)
            .propertyTypeCondo(false)
            .propertyTypeTownHouse(true)
            .financialData(createFinancialDataDTO())
            .viewData(createViewDataDTO())
            .roomList(asList(createRoomDTO(RoomType.MASTER_BEDROOM), createRoomDTO(RoomType.LIVING_ROOM)))
            .schoolList(asList(createSchoolDTO("primary", "jrHigh")))
            .animalPolicy(createAnimalPolicyDTO())
            .lotData(createLotDataDTO())
            .community(createCommunityDTO())
            .build();
    }

    public static RoomDTO createRoomDTO(RoomType roomType){
        return RoomDTO.builder()
                .indicator(Indicator.YES)
                .area(45)
                .type(roomType)
                .length(5)
                .width(9)
                .build();
    }

    public static CommunityDTO createCommunityDTO(){
        return CommunityDTO.builder()
                .clubHouse("club-house")
                .clubHouseIndicator(Indicator.YES)
                .exerciseArea("exercise_area")
                .exerciseAreaIndicator(Indicator.YES)
                .golf("golf")
                .golfIndicator(Indicator.YES)
                .tennis("tennis")
                .tennisIndicator(Indicator.YES)
                .recreationalFacilities("recreational-facilities")
                .recreationalFacilitiesIndicator(Indicator.NO)
                .securityFeatures("secure")
                .securityFeaturesIndicator(Indicator.NO)
                .seniorCommunity("seniorCommunity")
                .seniorCommunityIndicator(Indicator.NO)
                .hotTub("hotTub")
                .hotTubIndicator(Indicator.NO)
                .pool("pool")
                .poolIndicator(Indicator.UNKNOWN)
                .boatFacilities("boats")
                .boatFacilitiesIndicator(Indicator.UNKNOWN)
                .horseFacilities("horses")
                .horseFacilitiesIndicator(Indicator.UNKNOWN)
                .communityPark("parks")
                .communityParkIndicator(Indicator.UNKNOWN)
                .build();
    }

    public static SchoolDTO createSchoolDTO(String primary, String jrHigh){
        return SchoolDTO.builder()
            .primary(primary)
            .jrHigh(jrHigh)
            .build();
    }

    public static FinancialDataDTO createFinancialDataDTO(){
        return FinancialDataDTO.builder()
                .leaseOption("leaseOption")
                .leaseIndicator(Indicator.NO)
                .tradeOption("tradeOption")
                .rentalAmount(Long.valueOf(1000))
                .rentalAmountType(NumberType.INTEGER)
                .rentalAmountCurrencyCode("rentalAmountCurrencyCode")
                .rentalAmountPeriod(RentalPeriod.YEAR)
                .rentalAmountUnit(AreaUnit.SQ_METERS)
                .build();

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

    public static ViewDataDTO createViewDataDTO(){
        return ViewDataDTO.builder()
                .cityLight("light")
                .cityLightIndicator(Indicator.NO)
                .mountain("mountain")
                .mountainIndicator(Indicator.NO)
                .river("river")
                .riverIndicator(Indicator.NO)
                .lake("lake")
                .lakeIndicator(Indicator.NO)
                .golfCourse("golfCourse")
                .golfCourseIndicator(Indicator.NO)
                .water("water")
                .waterIndicator(Indicator.NO)
                .build();
    }


    public static AnimalPolicyDTO createAnimalPolicyDTO(){
        return AnimalPolicyDTO.builder()
                .permittedTypes("permitttedType")
                .animalsPermitted(Indicator.YES)
                .weightUnit(WeightUnit.KILO)
                .weightLimit(10L)
                .build();
    }

    //Filter

    public static PropertyFilter createDefaultPropertyFilter(){
        PropertyFilter propertyFilter = new PropertyFilter();
        propertyFilter.setPropertyAge(10);
        propertyFilter.setPropertyBathroomsQty(2);
        propertyFilter.setPropertyBedroomsQty(3);
        return propertyFilter;
    }

}
