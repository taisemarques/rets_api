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
        propertyEntity.setContactInformation(createContactInformationEntity());
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
            .contactInformation(createContactInformationDTO())
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

    public static SchoolDTO createSchoolDTO(String primary, String jrHigh){
        return SchoolDTO.builder()
            .primary(primary)
            .jrHigh(jrHigh)
            .build();
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
                .permittedTypes("permittted")
                .animalsPermitted(Indicator.YES)
                .weightUnit(WeightUnit.KILO)
                .weightLimit(10L)
                .build();
    }

    public static ContactInformationDTO createContactInformationDTO(){
        return ContactInformationDTO.builder()
                .agentPhone(createPhoneDTO("5140001111", "5140002222"))
                .listAgentPhone(createPhoneDTO("5140003333", "5140004444"))
                .salesAgentPhone(createPhoneDTO("5140005555", "5140006666"))
                .officePhone(createPhoneDTO("5140007777", "5140008888"))
                .listOfficePhone(createPhoneDTO("5140009999", "5140009898"))
                .salesOfficePhone(createPhoneDTO("5140009987", "5140009989"))
                .build();
    }

    public static PhoneDTO createPhoneDTO(String primaryPhone, String alternatePhone){
        return PhoneDTO.builder()
                .primaryPhone(primaryPhone)
                .alternatePhone(alternatePhone)
                .build();
    }

    //Filter

    public static PropertyFilter createDefaultPropertyFilter(){
        PropertyFilter propertyFilter = new PropertyFilter();
        propertyFilter.setAge(10);
        propertyFilter.setBathroomsQty(2);
        propertyFilter.setBedroomsQty(3);
        return propertyFilter;
    }

}
