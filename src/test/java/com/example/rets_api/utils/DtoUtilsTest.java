package com.example.rets_api.utils;


import com.example.rets_api.dto.*;
import com.example.rets_api.resource.Enums.*;

import static java.util.Arrays.asList;

public class DtoUtilsTest {


    public static PropertyDTO createPropertyDTOWithAllFields(){
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
            .firePlaceFuelType("gas")
            .firePlaceDetails("details")
            .floorsHardwood("hardwood")
            .floorsHardwoodIndicator(Indicator.YES)
            .displayFlagListing(true)
            .displayFlagAddress(false)
            .lotSizeRange("range")
            .lotSizeRangeUnits(AreaUnit.SQ_METERS)
            .lotSizeWidthUnits(LengthWidthUnit.METERS)
            .diningRoomWidthUnits(LengthWidthUnit.METERS)
            .familyRoomWidthUnits(LengthWidthUnit.METERS)
            .livingRoomWidthUnits(LengthWidthUnit.METERS)
            .basementWidthUnits(LengthWidthUnit.METERS)
            .lotSizeLengthUnits(LengthWidthUnit.METERS)
            .diningRoomLengthUnits(LengthWidthUnit.METERS)
            .livingRoomLengthUnits(LengthWidthUnit.METERS)
            .familyRoomLengthUnits(LengthWidthUnit.METERS)
            .basementLengthUnits(LengthWidthUnit.METERS)
            .parkingTotal(1)
            .parkingTotalOperator(Operator.DEFAULT_ENUM_VALUE)
            .financialData(createFinancialDataDTO())
            .viewData(createViewDataDTO())
            .roomList(asList(createRoomDTO(RoomType.MASTER_BEDROOM), createRoomDTO(RoomType.LIVING_ROOM)))
            .schoolList(asList(createSchoolDTO("primary", "jrHigh")))
            .animalPolicy(createAnimalPolicyDTO())
            .lotData(createLotDataDTO())
            .contactInformation(createContactInformationDTO())
            .community(createCommunityDTO())
            .listingPrice(createListingPriceDTO())
            .build();
    }

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
                .firePlaceFuelType("Fuel")
                .firePlaceDetails("Details")
                .floorsHardwood("Hardwood")
                .floorsHardwoodIndicator(Indicator.YES)
                .displayFlagListing(true)
                .displayFlagAddress(true)
                .lotSizeRange("Range")
                .lotSizeRangeUnits(AreaUnit.SQ_METERS)
                .lotSizeWidthUnits(LengthWidthUnit.METERS)
                .diningRoomWidthUnits(LengthWidthUnit.METERS)
                .familyRoomWidthUnits(LengthWidthUnit.METERS)
                .livingRoomWidthUnits(LengthWidthUnit.METERS)
                .basementWidthUnits(LengthWidthUnit.METERS)
                .lotSizeLengthUnits(LengthWidthUnit.METERS)
                .diningRoomLengthUnits(LengthWidthUnit.METERS)
                .livingRoomLengthUnits(LengthWidthUnit.METERS)
                .familyRoomLengthUnits(LengthWidthUnit.METERS)
                .basementLengthUnits(LengthWidthUnit.METERS)
                .parkingTotal(1)
                .parkingTotalOperator(Operator.DEFAULT_ENUM_VALUE)
                .build();
    }

    public static PropertyPatchDTO createPropertyPatchDTO(){
        return PropertyPatchDTO.builder()
                .age(10)
                .horseFacilities("horseFacilities2")
                .horseFacilitiesIndicator(Indicator.NO)
                .hotTub("HotTub2")
                .hotTubIndicator(Indicator.YES)
                .tennisCourt("Tennis2")
                .tennisCourtIndicator(Indicator.UNKNOWN)
                .inclusions("Inclusions2")
                .energyInformation("Energy2")
                .constructionMaterial("Material")
                .disabilityFeatures("Disability")
                .disabilityFeaturesIndicator(Indicator.YES)
                .securityFeatures("Security")
                .securityFeaturesIndicator(Indicator.YES)
                .propertyTypeRental(true)
                .propertyTypeFarm(false)
                .propertyTypeCondo(false)
                .propertyTypeTownHouse(true)
                .firePlaceFuelType("Fuel")
                .firePlaceDetails("Details")
                .floorsHardwood("Hardwood")
                .floorsHardwoodIndicator(Indicator.YES)
                .displayFlagListing(true)
                .displayFlagAddress(true)
                .lotSizeRange("Range")
                .lotSizeRangeUnits(AreaUnit.SQ_METERS)
                .lotSizeWidthUnits(LengthWidthUnit.METERS)
                .diningRoomWidthUnits(LengthWidthUnit.METERS)
                .familyRoomWidthUnits(LengthWidthUnit.METERS)
                .livingRoomWidthUnits(LengthWidthUnit.METERS)
                .basementWidthUnits(LengthWidthUnit.METERS)
                .lotSizeLengthUnits(LengthWidthUnit.METERS)
                .diningRoomLengthUnits(LengthWidthUnit.METERS)
                .livingRoomLengthUnits(LengthWidthUnit.METERS)
                .familyRoomLengthUnits(LengthWidthUnit.METERS)
                .basementLengthUnits(LengthWidthUnit.METERS)
                .parkingTotal(1)
                .parkingTotalOperator(Operator.DEFAULT_ENUM_VALUE)
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
                .cityLight(null)
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

    public static ListingPriceDTO createListingPriceDTO(){
        return ListingPriceDTO.builder()
                .lowAmount(150000L)
                .highAmount(500000L)
                .lowAmountType(NumberType.FLOAT)
                .highAmountType(NumberType.FLOAT)
                .lowAmountCurrencyCode("CAD")
                .highAmountCurrencyCode("CAD")
                .units(AreaUnit.SQ_FEET)
                .build();
    }
}
