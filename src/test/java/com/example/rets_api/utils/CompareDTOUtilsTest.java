package com.example.rets_api.utils;

import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.dto.RoomDTO;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

public class CompareDTOUtilsTest {

    public static boolean compareRoomDTO(RoomDTO roomDTO1, RoomDTO roomDTO2) {
        return roomDTO1.getType().equals(roomDTO2.getType()) &&
                roomDTO1.getIndicator().equals(roomDTO2.getIndicator()) &&
                roomDTO1.getDimensions().equals(roomDTO2.getDimensions()) &&
                roomDTO1.getLength() == roomDTO2.getLength() &&
                roomDTO1.getLengthUnit().equals(roomDTO2.getLengthUnit()) &&
                roomDTO1.getWidth() == roomDTO2.getWidth() &&
                roomDTO1.getWidthUnit().equals(roomDTO2.getWidthUnit()) &&
                roomDTO1.getArea() == roomDTO2.getArea() &&
                roomDTO1.getAreaUnit().equals(roomDTO2.getAreaUnit()) &&
                roomDTO1.getAreaType().equals(roomDTO2.getAreaType()) &&
                roomDTO1.getBathSize().equals(roomDTO2.getBathSize());
    }

    public static boolean compareRoomList(List<RoomDTO> roomDTO1, List<RoomDTO> roomDTO2) {
        if((isEmpty(roomDTO1) && isEmpty(roomDTO2))) return true;
        if((isEmpty(roomDTO1) != isEmpty(roomDTO2)) || (roomDTO1.size() != roomDTO2.size())) return false;
        for(int i = 0; i < roomDTO1.size(); i++){
            if(!compareRoomDTO(roomDTO1.get(i), roomDTO2.get(i))) return false;
        }
        return true;
    }
    
    public static boolean comparePropertyDTOBasicFields(PropertyDTO propertyDTO1, PropertyDTO propertyDTO2){
        return propertyDTO1.getAge()==propertyDTO2.getAge() &&
                propertyDTO1.getHorseFacilities().equals(propertyDTO2.getHorseFacilities()) &&
                propertyDTO1.getHotTub().equals(propertyDTO2.getHotTub()) &&
                propertyDTO1.getHotTubIndicator().equals(propertyDTO2.getHotTubIndicator()) &&
                propertyDTO1.getTennisCourt().equals(propertyDTO2.getTennisCourt()) &&
                propertyDTO1.getTennisCourtIndicator().equals(propertyDTO2.getTennisCourtIndicator()) &&
                propertyDTO1.getInclusions().equals(propertyDTO2.getInclusions()) &&
                propertyDTO1.getEnergyInformation().equals(propertyDTO2.getEnergyInformation()) &&
                propertyDTO1.getConstructionMaterial().equals(propertyDTO2.getConstructionMaterial()) &&
                propertyDTO1.getDisabilityFeatures().equals(propertyDTO2.getDisabilityFeatures()) &&
                propertyDTO1.getDisabilityFeaturesIndicator().equals(propertyDTO2.getDisabilityFeaturesIndicator()) &&
                propertyDTO1.getSecurityFeatures().equals(propertyDTO2.getSecurityFeatures()) &&
                propertyDTO1.getSecurityFeaturesIndicator().equals(propertyDTO2.getSecurityFeaturesIndicator()) &&
                propertyDTO1.getPropertyTypeRental().equals(propertyDTO2.getPropertyTypeRental()) &&
                propertyDTO1.getPropertyTypeFarm().equals(propertyDTO2.getPropertyTypeFarm()) &&
                propertyDTO1.getPropertyTypeCondo().equals(propertyDTO2.getPropertyTypeCondo()) &&
                propertyDTO1.getPropertyTypeTownHouse().equals(propertyDTO2.getPropertyTypeTownHouse()) &&
                propertyDTO1.getFirePlaceFuelType().equals(propertyDTO2.getFirePlaceFuelType()) &&
                propertyDTO1.getFirePlaceDetails().equals(propertyDTO2.getFirePlaceDetails()) &&
                propertyDTO1.getFloorsHardwood().equals(propertyDTO2.getFloorsHardwood()) &&
                propertyDTO1.getFloorsHardwoodIndicator().equals(propertyDTO2.getFloorsHardwoodIndicator()) &&
                propertyDTO1.getDisplayFlagListing().equals(propertyDTO2.getDisplayFlagListing()) &&
                propertyDTO1.getDisplayFlagAddress().equals(propertyDTO2.getDisplayFlagAddress()) &&
                propertyDTO1.getLotSizeRange().equals(propertyDTO2.getLotSizeRange()) &&
                propertyDTO1.getLotSizeRangeUnits().equals(propertyDTO2.getLotSizeRangeUnits()) &&
                propertyDTO1.getLotSizeWidthUnits().equals(propertyDTO2.getLotSizeWidthUnits()) &&
                propertyDTO1.getDiningRoomWidthUnits().equals(propertyDTO2.getDiningRoomWidthUnits()) &&
                propertyDTO1.getFamilyRoomWidthUnits().equals(propertyDTO2.getFamilyRoomWidthUnits()) &&
                propertyDTO1.getLivingRoomWidthUnits().equals(propertyDTO2.getLivingRoomWidthUnits()) &&
                propertyDTO1.getBasementWidthUnits().equals(propertyDTO2.getBasementWidthUnits()) &&
                propertyDTO1.getLotSizeLengthUnits().equals(propertyDTO2.getLotSizeLengthUnits()) &&
                propertyDTO1.getDiningRoomLengthUnits().equals(propertyDTO2.getDiningRoomLengthUnits()) &&
                propertyDTO1.getLivingRoomLengthUnits().equals(propertyDTO2.getLivingRoomLengthUnits()) &&
                propertyDTO1.getFamilyRoomLengthUnits().equals(propertyDTO2.getFamilyRoomLengthUnits()) &&
                propertyDTO1.getBasementLengthUnits().equals(propertyDTO2.getBasementLengthUnits()) &&
                propertyDTO1.getParkingTotal() == propertyDTO2.getParkingTotal() &&
                propertyDTO1.getParkingTotalOperator().equals(propertyDTO2.getParkingTotalOperator());
    }
    
    public static boolean comparePropertyDTO(PropertyDTO propertyDTO1, PropertyDTO propertyDTO2){
        return comparePropertyDTOBasicFields(propertyDTO1, propertyDTO2) &&
                compareRoomList(propertyDTO1.getRoomList(), propertyDTO2.getRoomList()) &&
                propertyDTO1.getContactInformation().equals(propertyDTO1.getContactInformation()) &&
                propertyDTO1.getFinancialData().equals(propertyDTO2.getFinancialData()) &&
                propertyDTO1.getListingPrice().equals(propertyDTO2.getListingPrice()) &&
                propertyDTO1.getAnimalPolicy().equals(propertyDTO2.getAnimalPolicy()) &&
                propertyDTO1.getLotData().equals(propertyDTO2.getLotData()) &&
                propertyDTO1.getSchoolList().equals(propertyDTO2.getSchoolList()) &&
                propertyDTO1.getCommunity().equals(propertyDTO2.getCommunity()) &&
                propertyDTO1.getViewData().equals(propertyDTO2.getViewData());
                
    }
    

}
