package com.example.rets_api.resource;

import com.example.rets_api.dto.PropertyPatchDTO;
import com.example.rets_api.dto.ViewDataDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.entity.ViewDataEntity;

import java.util.function.Consumer;

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

    public static PropertyEntity updateWhenViewDataChanged(PropertyEntity propertyToUpdate, ViewDataDTO viewDataDTO){

        if(viewDataDTO.equals(null)) return null;
        ViewDataEntity viewDataToUpdated = propertyToUpdate.getViewData();

        NullUtils.updateIfChanged(viewDataToUpdated::setCityLight, viewDataDTO.getCityLight(), viewDataToUpdated::getCityLight);
        NullUtils.updateIfChanged(viewDataToUpdated::setCityLightIndicator, viewDataDTO.getCityLightIndicator(), viewDataToUpdated::getCityLightIndicator);
        NullUtils.updateIfChanged(viewDataToUpdated::setMountain, viewDataDTO.getMountain(), viewDataToUpdated::getMountain);
        NullUtils.updateIfChanged(viewDataToUpdated::setMountainIndicator, viewDataDTO.getMountainIndicator(), viewDataToUpdated::getMountainIndicator);
        NullUtils.updateIfChanged(viewDataToUpdated::setRiver, viewDataDTO.getRiver(), viewDataToUpdated::getRiver);
        NullUtils.updateIfChanged(viewDataToUpdated::setRiverIndicator, viewDataDTO.getRiverIndicator(), viewDataToUpdated::getRiverIndicator);
        NullUtils.updateIfChanged(viewDataToUpdated::setLakeIndicator, viewDataDTO.getLakeIndicator(), viewDataToUpdated::getLakeIndicator);
        NullUtils.updateIfChanged(viewDataToUpdated::setLake, viewDataDTO.getLake(), viewDataToUpdated::getLake);
        NullUtils.updateIfChanged(viewDataToUpdated::setGolfCourse, viewDataDTO.getGolfCourse(), viewDataToUpdated::getGolfCourse);
        NullUtils.updateIfChanged(viewDataToUpdated::setGolfCourseIndicator, viewDataDTO.getGolfCourseIndicator(), viewDataToUpdated::getGolfCourseIndicator);
        NullUtils.updateIfChanged(viewDataToUpdated::setWater, viewDataDTO.getWater(), viewDataToUpdated::getWater);
        NullUtils.updateIfChanged(viewDataToUpdated::setWaterIndicator, viewDataDTO.getWaterIndicator(), viewDataToUpdated::getWaterIndicator);

        propertyToUpdate.setViewData(viewDataToUpdated);

        return propertyToUpdate;

    }

}
