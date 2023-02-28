package com.example.rets_api.utils;

import com.example.rets_api.entity.*;

public class CompareEntitiesTest {

    public static boolean compareRoom(RoomEntity entity1, RoomEntity entity2) {
        return entity1.getRoomType().equals(entity2.getRoomType()) &&
                entity1.getIndicator().equals(entity2.getIndicator()) &&
                entity1.getDimensions().equals(entity2.getDimensions()) &&
                entity1.getLength() == entity2.getLength() &&
                entity1.getLengthUnit().equals(entity2.getLengthUnit()) &&
                entity1.getWidth() == entity2.getWidth() &&
                entity1.getWidthUnit().equals(entity2.getWidthUnit()) &&
                entity1.getArea() == entity2.getArea() &&
                entity1.getAreaUnit().equals(entity2.getAreaUnit()) &&
                entity1.getAreaType().equals(entity2.getAreaType()) &&
                entity1.getBathSize().equals(entity2.getBathSize());
    }

    public static boolean compareFinancialData(FinancialDataEntity entity1, FinancialDataEntity entity2) {
        return entity1.getLeaseOption().equals(entity2.getLeaseOption()) &&
                entity1.getLeaseIndicator().equals(entity2.getLeaseIndicator()) &&
                entity1.getTradeOption().equals(entity2.getTradeOption()) &&
                entity1.getTradeIndicator().equals(entity2.getTradeIndicator()) &&
                entity1.getRentalAmount().equals(entity2.getRentalAmount()) &&
                entity1.getRentalAmountType().equals(entity2.getRentalAmountType()) &&
                entity1.getRentalAmountCurrencyCode().equals(entity2.getRentalAmountCurrencyCode()) &&
                entity1.getRentalAmountPeriod().equals(entity2.getRentalAmountPeriod()) &&
                entity1.getRentalAmountUnit().equals(entity2.getRentalAmountUnit());
    }

    public static boolean compareViewData(ViewDataEntity entity1, ViewDataEntity entity2) {
        return entity1.getCityLight().equals(entity2.getCityLight()) &&
                entity1.getCityLightIndicator().equals(entity2.getCityLightIndicator()) &&
                entity1.getMountain().equals(entity2.getMountain()) &&
                entity1.getMountainIndicator().equals(entity2.getMountainIndicator()) &&
                entity1.getRiver().equals(entity2.getRiver()) &&
                entity1.getRiverIndicator().equals(entity2.getRiverIndicator()) &&
                entity1.getLake().equals(entity2.getLake()) &&
                entity1.getLakeIndicator().equals(entity2.getLakeIndicator()) &&
                entity1.getGolfCourse().equals(entity2.getGolfCourse()) &&
                entity1.getGolfCourseIndicator().equals(entity2.getGolfCourseIndicator()) &&
                entity1.getWater().equals(entity2.getWater()) &&
                entity2.getWaterIndicator().equals(entity2.getWaterIndicator());
    }

    public static boolean compareLotData(LotDataEntity entity1, LotDataEntity entity2) {
        return entity1.getCornerLot().equals(entity2.getCornerLot()) &&
                entity1.getCornerLotIndicator().equals(entity2.getCornerLotIndicator()) &&
                entity1.getCuldeSac().equals(entity2.getCuldeSac()) &&
                entity1.getCuldeSacIndicator().equals(entity2.getCuldeSacIndicator()) &&
                entity1.getGolfCourseLot().equals(entity2.getGolfCourseLot()) &&
                entity1.getGolfCourseLotIndicator().equals(entity2.getGolfCourseLotIndicator());
    }

    public static boolean compareSchool(SchoolEntity entity1, SchoolEntity entity2) {
        return entity1.getPrimarySchool().equals(entity2.getPrimarySchool()) &&
                entity2.getJrHigh().equals(entity2.getJrHigh());
    }


    public static boolean compareAnimalPolicy(AnimalPolicyEntity entity1, AnimalPolicyEntity entity2) {
        return entity1.getAnimalsPermitted().equals(entity2.getAnimalsPermitted()) &&
                entity1.getPermittedTypes().equals(entity2.getPermittedTypes()) &&
                entity1.getWeightLimit().equals(entity2.getWeightLimit()) &&
                entity1.getWeightUnit().equals(entity2.getWeightUnit());
    }


    public static boolean compareContactInformation(ContactInformationEntity entity1, ContactInformationEntity entity2) {
        return entity1.getAgentPhone().getPrimaryPhone().equals(entity2.getAgentPhone().getPrimaryPhone()) &&
                entity1.getAgentPhone().getAlternatePhone().equals(entity2.getAgentPhone().getAlternatePhone()) &&
                entity1.getListAgentPhone().getPrimaryPhone().equals(entity2.getListAgentPhone().getPrimaryPhone()) &&
                entity1.getListAgentPhone().getAlternatePhone().equals(entity2.getListAgentPhone().getAlternatePhone()) &&
                entity1.getSalesAgentPhone().getPrimaryPhone().equals(entity2.getSalesAgentPhone().getPrimaryPhone()) &&
                entity1.getSalesAgentPhone().getAlternatePhone().equals(entity2.getSalesAgentPhone().getAlternatePhone()) &&
                entity1.getOfficePhone().getPrimaryPhone().equals(entity2.getOfficePhone().getPrimaryPhone()) &&
                entity1.getOfficePhone().getAlternatePhone().equals(entity2.getOfficePhone().getAlternatePhone()) &&
                entity1.getListOfficePhone().getPrimaryPhone().equals(entity2.getListOfficePhone().getPrimaryPhone()) &&
                entity1.getListOfficePhone().getAlternatePhone().equals(entity2.getListOfficePhone().getAlternatePhone()) &&
                entity1.getSalesOfficePhone().getPrimaryPhone().equals(entity2.getSalesOfficePhone().getPrimaryPhone()) &&
                entity1.getSalesOfficePhone().getAlternatePhone().equals(entity2.getSalesOfficePhone().getAlternatePhone());
    }

    public static boolean compareCommunity(CommunityEntity entity1, CommunityEntity entity2) {
        return entity1.getClubHouse().equals(entity2.getClubHouse()) &&
                entity1.getClubHouseIndicator().equals(entity2.getClubHouseIndicator()) &&
                entity1.getExerciseArea().equals(entity2.getExerciseArea()) &&
                entity1.getExerciseAreaIndicator().equals(entity2.getExerciseAreaIndicator()) &&
                entity1.getGolf().equals(entity2.getGolf()) &&
                entity1.getGolfIndicator().equals(entity2.getGolfIndicator()) &&
                entity1.getTennis().equals(entity2.getTennis()) &&
                entity1.getTennisIndicator().equals(entity2.getTennisIndicator()) &&
                entity1.getRecreationalFacilities().equals(entity2.getRecreationalFacilities()) &&
                entity1.getRecreationalFacilitiesIndicator().equals(entity2.getRecreationalFacilitiesIndicator()) &&
                entity1.getSecurityFeatures().equals(entity2.getSecurityFeatures()) &&
                entity1.getSecurityFeaturesIndicator().equals(entity2.getSecurityFeaturesIndicator()) &&
                entity1.getSeniorCommunity().equals(entity2.getSeniorCommunity()) &&
                entity1.getSeniorCommunityIndicator().equals(entity2.getSeniorCommunityIndicator()) &&
                entity1.getHotTub().equals(entity2.getHotTub()) &&
                entity1.getHotTubIndicator().equals(entity2.getHotTubIndicator()) &&
                entity1.getPool().equals(entity2.getPool()) &&
                entity1.getPoolIndicator().equals(entity2.getPoolIndicator()) &&
                entity1.getBoatFacilities().equals(entity2.getBoatFacilities()) &&
                entity1.getBoatFacilitiesIndicator().equals(entity2.getBoatFacilitiesIndicator()) &&
                entity1.getHorseFacilities().equals(entity2.getHorseFacilities()) &&
                entity1.getHorseFacilitiesIndicator().equals(entity2.getHorseFacilitiesIndicator()) &&
                entity1.getCommunityPark().equals(entity2.getCommunityPark()) &&
                entity1.getCommunityParkIndicator().equals(entity2.getCommunityParkIndicator());
    }
    public static boolean compareListingPrice(ListingPriceEntity entity1, ListingPriceEntity entity2){
        return  entity1.getLowAmount().equals(entity2.getLowAmount()) &&
                entity1.getHighAmount().equals(entity2.getHighAmount()) &&
                entity1.getLowAmountType().equals(entity2.getLowAmountType()) &&
                entity1.getHighAmountType().equals(entity2.getHighAmountType()) &&
                entity1.getLowAmountCurrencyCode().equals(entity2.getLowAmountCurrencyCode()) &&
                entity1.getHighAmountCurrencyCode().equals(entity2.getHighAmountCurrencyCode()) &&
                entity1.getUnits().equals(entity2.getUnits());
    }

}
