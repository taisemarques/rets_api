package com.example.rets_api.resource;

import com.example.rets_api.dto.FinancialDataDTO;
import com.example.rets_api.dto.PropertyPatchDTO;
import com.example.rets_api.entity.FinancialDataEntity;
import com.example.rets_api.entity.PropertyEntity;

public class PatchUtils {


    public static PropertyEntity updatePropertyFieldsWhenChanged(PropertyEntity propertyToUpdate, PropertyPatchDTO propertyPatchDTO){

        NullUtils.updateIfChanged(propertyToUpdate::setAge, propertyPatchDTO.getAge(), propertyToUpdate::getAge);
        NullUtils.updateIfChanged(propertyToUpdate::setHorseFacilities, propertyPatchDTO.getHorseFacilities(), propertyToUpdate::getHorseFacilities);
        NullUtils.updateIfChanged(propertyToUpdate::setHorseFacilitiesIndicator, propertyPatchDTO.getHorseFacilitiesIndicator(), propertyToUpdate::getHorseFacilitiesIndicator);
        NullUtils.updateIfChanged(propertyToUpdate::setHotTub, propertyPatchDTO.getHotTub(), propertyToUpdate::getHotTub);
        NullUtils.updateIfChanged(propertyToUpdate::setHotTubIndicator, propertyPatchDTO.getHotTubIndicator(), propertyToUpdate::getHotTubIndicator);
        NullUtils.updateIfChanged(propertyToUpdate::setTennisCourt, propertyPatchDTO.getTennisCourt(), propertyToUpdate::getTennisCourt);
        NullUtils.updateIfChanged(propertyToUpdate::setTennisCourtIndicator, propertyPatchDTO.getTennisCourtIndicator(), propertyToUpdate::getTennisCourtIndicator);
        NullUtils.updateIfChanged(propertyToUpdate::setInclusions, propertyPatchDTO.getInclusions(), propertyToUpdate::getInclusions);
        NullUtils.updateIfChanged(propertyToUpdate::setEnergyInformation, propertyPatchDTO.getEnergyInformation(), propertyToUpdate::getEnergyInformation);
        NullUtils.updateIfChanged(propertyToUpdate::setConstructionMaterial, propertyPatchDTO.getConstructionMaterial(), propertyToUpdate::getConstructionMaterial);
        NullUtils.updateIfChanged(propertyToUpdate::setDisabilityFeatures, propertyPatchDTO.getDisabilityFeatures(), propertyToUpdate::getDisabilityFeatures);
        NullUtils.updateIfChanged(propertyToUpdate::setDisabilityFeaturesIndicator, propertyPatchDTO.getDisabilityFeaturesIndicator(), propertyToUpdate::getDisabilityFeaturesIndicator);
        NullUtils.updateIfChanged(propertyToUpdate::setSecurityFeatures, propertyPatchDTO.getSecurityFeatures(), propertyToUpdate::getSecurityFeatures);
        NullUtils.updateIfChanged(propertyToUpdate::setSecurityFeaturesIndicator, propertyPatchDTO.getSecurityFeaturesIndicator(), propertyToUpdate::getSecurityFeaturesIndicator);
        NullUtils.updateIfChanged(propertyToUpdate::setPropertyTypeRental, propertyPatchDTO.getPropertyTypeRental(), propertyToUpdate::getPropertyTypeRental);
        NullUtils.updateIfChanged(propertyToUpdate::setPropertyTypeFarm, propertyPatchDTO.getPropertyTypeFarm(), propertyToUpdate::getPropertyTypeFarm);
        NullUtils.updateIfChanged(propertyToUpdate::setPropertyTypeCondo, propertyPatchDTO.getPropertyTypeCondo(), propertyToUpdate::getPropertyTypeCondo);
        NullUtils.updateIfChanged(propertyToUpdate::setPropertyTypeTownHouse, propertyPatchDTO.getPropertyTypeTownHouse(), propertyToUpdate::getPropertyTypeTownHouse);
        NullUtils.updateIfChanged(propertyToUpdate::setFirePlaceFuelType, propertyPatchDTO.getFirePlaceFuelType(), propertyToUpdate::getFirePlaceFuelType);
        NullUtils.updateIfChanged(propertyToUpdate::setFirePlaceDetails, propertyPatchDTO.getFirePlaceDetails(), propertyToUpdate::getFirePlaceDetails);
        NullUtils.updateIfChanged(propertyToUpdate::setFloorsHardwood, propertyPatchDTO.getFloorsHardwood(), propertyToUpdate::getFloorsHardwood);
        NullUtils.updateIfChanged(propertyToUpdate::setFloorsHardwoodIndicator, propertyPatchDTO.getFloorsHardwoodIndicator(), propertyToUpdate::getFloorsHardwoodIndicator);
        NullUtils.updateIfChanged(propertyToUpdate::setDisplayFlagListing, propertyPatchDTO.getDisplayFlagListing(), propertyToUpdate::getDisplayFlagListing);
        NullUtils.updateIfChanged(propertyToUpdate::setDisplayFlagAddress, propertyPatchDTO.getDisplayFlagAddress(), propertyToUpdate::getDisplayFlagAddress);
        NullUtils.updateIfChanged(propertyToUpdate::setLotSizeRange, propertyPatchDTO.getLotSizeRange(), propertyToUpdate::getLotSizeRange);
        NullUtils.updateIfChanged(propertyToUpdate::setLotSizeRangeUnits, propertyPatchDTO.getLotSizeRangeUnits(), propertyToUpdate::getLotSizeRangeUnits);
        NullUtils.updateIfChanged(propertyToUpdate::setLotSizeWidthUnits, propertyPatchDTO.getLotSizeWidthUnits(), propertyToUpdate::getLotSizeWidthUnits);
        NullUtils.updateIfChanged(propertyToUpdate::setDiningRoomWidthUnits, propertyPatchDTO.getDiningRoomWidthUnits(), propertyToUpdate::getDiningRoomWidthUnits);
        NullUtils.updateIfChanged(propertyToUpdate::setFamilyRoomWidthUnits, propertyPatchDTO.getFamilyRoomWidthUnits(), propertyToUpdate::getFamilyRoomWidthUnits);
        NullUtils.updateIfChanged(propertyToUpdate::setLivingRoomWidthUnits, propertyPatchDTO.getLivingRoomWidthUnits(), propertyToUpdate::getLivingRoomWidthUnits);
        NullUtils.updateIfChanged(propertyToUpdate::setBasementWidthUnits, propertyPatchDTO.getBasementWidthUnits(), propertyToUpdate::getBasementWidthUnits);
        NullUtils.updateIfChanged(propertyToUpdate::setLotSizeLengthUnits, propertyPatchDTO.getLotSizeLengthUnits(), propertyToUpdate::getLotSizeLengthUnits);
        NullUtils.updateIfChanged(propertyToUpdate::setDiningRoomLengthUnits, propertyPatchDTO.getDiningRoomLengthUnits(), propertyToUpdate::getDiningRoomLengthUnits);
        NullUtils.updateIfChanged(propertyToUpdate::setLivingRoomLengthUnits, propertyPatchDTO.getLivingRoomLengthUnits(), propertyToUpdate::getLivingRoomLengthUnits);
        NullUtils.updateIfChanged(propertyToUpdate::setFamilyRoomLengthUnits, propertyPatchDTO.getFamilyRoomLengthUnits(), propertyToUpdate::getFamilyRoomLengthUnits);
        NullUtils.updateIfChanged(propertyToUpdate::setBasementLengthUnits, propertyPatchDTO.getBasementLengthUnits(), propertyToUpdate::getBasementLengthUnits);
        NullUtils.updateIfChanged(propertyToUpdate::setParkingTotal, propertyPatchDTO.getParkingTotal(), propertyToUpdate::getParkingTotal);
        NullUtils.updateIfChanged(propertyToUpdate::setParkingTotalOperator, propertyPatchDTO.getParkingTotalOperator(), propertyToUpdate::getParkingTotalOperator);

        return propertyToUpdate;

    }

    public static FinancialDataEntity updateFinancialDataFieldsWhenChanged(FinancialDataEntity financialDataToUpdate, FinancialDataDTO financialDataDTO){
        if(financialDataDTO == null || financialDataToUpdate == null){ return null;}
        NullUtils.updateIfChanged(financialDataToUpdate::setLeaseOption, financialDataDTO.getLeaseOption(), financialDataToUpdate::getLeaseOption);
        NullUtils.updateIfChanged(financialDataToUpdate::setLeaseIndicator, financialDataDTO.getLeaseIndicator(), financialDataToUpdate::getLeaseIndicator);
        NullUtils.updateIfChanged(financialDataToUpdate::setTradeOption, financialDataDTO.getTradeOption(), financialDataToUpdate::getTradeOption);
        NullUtils.updateIfChanged(financialDataToUpdate::setTradeIndicator, financialDataDTO.getTradeIndicator(), financialDataToUpdate::getTradeIndicator);
        NullUtils.updateIfChanged(financialDataToUpdate::setRentalAmount, financialDataDTO.getRentalAmount(), financialDataToUpdate::getRentalAmount);
        NullUtils.updateIfChanged(financialDataToUpdate::setRentalAmountType, financialDataDTO.getRentalAmountType(), financialDataToUpdate::getRentalAmountType);
        NullUtils.updateIfChanged(financialDataToUpdate::setRentalAmountCurrencyCode, financialDataDTO.getRentalAmountCurrencyCode(), financialDataToUpdate::getRentalAmountCurrencyCode);
        NullUtils.updateIfChanged(financialDataToUpdate::setRentalAmountPeriod, financialDataDTO.getRentalAmountPeriod(), financialDataToUpdate::getRentalAmountPeriod);
        NullUtils.updateIfChanged(financialDataToUpdate::setRentalAmountUnit, financialDataDTO.getRentalAmountUnit(), financialDataToUpdate::getRentalAmountUnit);
        return financialDataToUpdate;
    }


}
