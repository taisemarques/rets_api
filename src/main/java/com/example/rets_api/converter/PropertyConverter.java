package com.example.rets_api.converter;

import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.entity.PropertyEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class PropertyConverter {

    public static Converter<PropertyDTO, PropertyEntity> propertyDTOToPropertyEntity = in -> {
        if(isNull(in)) return null;
        PropertyEntity retsEntity = new PropertyEntity();
        retsEntity.setAge(in.getAge());
        retsEntity.setHorseFacilities(in.getHorseFacilities());
        retsEntity.setHorseFacilitiesIndicator(in.getHorseFacilitiesIndicator());
        retsEntity.setHotTub(in.getHotTub());
        retsEntity.setHotTubIndicator(in.getHotTubIndicator());
        retsEntity.setTennisCourt(in.getTennisCourt());
        retsEntity.setTennisCourtIndicator(in.getTennisCourtIndicator());
        retsEntity.setInclusions(in.getInclusions());
        retsEntity.setEnergyInformation(in.getEnergyInformation());
        retsEntity.setConstructionMaterial(in.getConstructionMaterial());
        retsEntity.setDisabilityFeatures(in.getDisabilityFeatures());
        retsEntity.setDisabilityFeaturesIndicator(in.getDisabilityFeaturesIndicator());
        retsEntity.setSecurityFeatures(in.getSecurityFeatures());
        retsEntity.setSecurityFeaturesIndicator(in.getSecurityFeaturesIndicator());
        retsEntity.setPropertyTypeRental(in.getPropertyTypeRental());
        retsEntity.setPropertyTypeFarm(in.getPropertyTypeFarm());
        retsEntity.setPropertyTypeCondo(in.getPropertyTypeCondo());
        retsEntity.setPropertyTypeTownHouse(in.getPropertyTypeTownHouse());
        retsEntity.setFinancialData(FinancialDataConverter.financialDataDTOToFinancialDataEntity.convert(in.getFinancialData()));
        retsEntity.setSchoolList(SchoolConverter.listSchoolDTOToListSchoolEntity(in.getSchoolList()));
        retsEntity.setRoomList(RoomConverter.listRoomDTOToListRoomEntity(in.getRoomList()));
        retsEntity.setAnimalPolicy(AnimalPolicyConverter.animalPolicyDTOToAnimalPolicyEntity.convert(in.getAnimalPolicy()));
        retsEntity.setViewData(ViewDataConverter.viewDataDTOToViewDataEntity.convert(in.getViewData()));
        retsEntity.setLotData(LotDataConverter.lotDataDTOToLotDataEntity.convert(in.getLotData()));
        retsEntity.setContactInformation(ContactInformationConverter.contactInformationDTOToContactInformationEntity.convert(in.getContactInformation()));
        retsEntity.setCommunity(CommunityConverter.communityDTOToCommunityEntity.convert(in.getCommunity()));
        retsEntity.setListingPrice(ListingPriceConverter.listPriceDTOToListPriceEntity.convert(in.getListingPrice()));
        retsEntity.setFirePlaceFuelType(in.getFirePlaceFuelType());
        retsEntity.setFirePlaceDetails(in.getFirePlaceDetails());
        retsEntity.setFloorsHardwood(in.getFloorsHardwood());
        retsEntity.setFloorsHardwoodIndicator(in.getFloorsHardwoodIndicator());
        retsEntity.setDisplayFlagListing(in.getDisplayFlagListing());
        retsEntity.setDisplayFlagAddress(in.getDisplayFlagAddress());
        retsEntity.setLotSizeRange(in.getLotSizeRange());
        retsEntity.setLotSizeRangeUnits(in.getLotSizeRangeUnits());
        retsEntity.setLotSizeWidthUnits(in.getLotSizeWidthUnits());
        retsEntity.setDiningRoomWidthUnits(in.getDiningRoomWidthUnits());
        retsEntity.setFamilyRoomWidthUnits(in.getFamilyRoomWidthUnits());
        retsEntity.setLivingRoomWidthUnits(in.getLivingRoomWidthUnits());
        retsEntity.setBasementWidthUnits(in.getBasementWidthUnits());
        retsEntity.setLotSizeLengthUnits(in.getLotSizeLengthUnits());
        retsEntity.setDiningRoomLengthUnits(in.getDiningRoomLengthUnits());
        retsEntity.setLivingRoomLengthUnits(in.getLivingRoomLengthUnits());
        retsEntity.setFamilyRoomLengthUnits(in.getFamilyRoomLengthUnits());
        retsEntity.setBasementLengthUnits(in.getBasementLengthUnits());
        retsEntity.setParkingTotal(in.getParkingTotal());
        retsEntity.setParkingTotalOperator(in.getParkingTotalOperator());
        return retsEntity;
    };

    public static Converter<PropertyEntity, PropertyDTO> propertyEntityToPropertyDTO = in -> {
        if (isNull(in)) return null;
        return PropertyDTO.builder()
                .age(in.getAge())
                .horseFacilities(in.getHorseFacilities())
                .horseFacilitiesIndicator(in.getHorseFacilitiesIndicator())
                .hotTub(in.getHotTub())
                .hotTubIndicator(in.getHotTubIndicator())
                .tennisCourt(in.getTennisCourt())
                .tennisCourtIndicator(in.getTennisCourtIndicator())
                .inclusions((in.getInclusions()))
                .energyInformation(in.getEnergyInformation())
                .constructionMaterial(in.getConstructionMaterial())
                .disabilityFeatures(in.getDisabilityFeatures())
                .disabilityFeaturesIndicator(in.getDisabilityFeaturesIndicator())
                .securityFeatures(in.getSecurityFeatures())
                .securityFeaturesIndicator(in.getSecurityFeaturesIndicator())
                .propertyTypeRental(in.getPropertyTypeRental())
                .propertyTypeFarm(in.getPropertyTypeFarm())
                .propertyTypeCondo(in.getPropertyTypeCondo())
                .propertyTypeTownHouse(in.getPropertyTypeTownHouse())
                .financialData(FinancialDataConverter.financialDataEntityToFinancialDataDTO.convert(in.getFinancialData()))
                .schoolList(SchoolConverter.listSchoolEntityToListSchoolDTO(in.getSchoolList()))
                .roomList(RoomConverter.listRoomEntityToListRoomDTO(in.getRoomList()))
                .viewData(ViewDataConverter.viewDataEntityToViewDataDTO.convert(in.getViewData()))
                .animalPolicy(AnimalPolicyConverter.animalPolicyEntityToAnimalPolicyDTO.convert(in.getAnimalPolicy()))
                .lotData(LotDataConverter.lotDataEntityToLotDataDTO.convert(in.getLotData()))
                .contactInformation(ContactInformationConverter.contactInformationEntityToContactInformationDTO.convert(in.getContactInformation()))
                .community(CommunityConverter.communityEntityToCommunityDTO.convert(in.getCommunity()))
                .listingPrice(ListingPriceConverter.listPriceEntityToListPriceDTO.convert(in.getListingPrice()))
                .firePlaceFuelType(in.getFirePlaceFuelType())
                .firePlaceDetails(in.getFirePlaceDetails())
                .floorsHardwood(in.getFloorsHardwood())
                .floorsHardwoodIndicator(in.getFloorsHardwoodIndicator())
                .displayFlagListing(in.getDisplayFlagListing())
                .displayFlagAddress(in.getDisplayFlagAddress())
                .lotSizeRange(in.getLotSizeRange())
                .lotSizeRangeUnits(in.getLotSizeRangeUnits())
                .lotSizeWidthUnits(in.getLotSizeWidthUnits())
                .diningRoomWidthUnits(in.getDiningRoomWidthUnits())
                .familyRoomWidthUnits(in.getFamilyRoomWidthUnits())
                .livingRoomWidthUnits(in.getLivingRoomWidthUnits())
                .basementWidthUnits(in.getBasementWidthUnits())
                .lotSizeLengthUnits(in.getLotSizeLengthUnits())
                .diningRoomLengthUnits(in.getDiningRoomLengthUnits())
                .livingRoomLengthUnits(in.getLivingRoomLengthUnits())
                .familyRoomLengthUnits(in.getFamilyRoomLengthUnits())
                .basementLengthUnits(in.getBasementLengthUnits())
                .parkingTotal(in.getParkingTotal())
                .parkingTotalOperator(in.getParkingTotalOperator())
                .build();
    };

    public static List<PropertyDTO> listPropertiesEntityToListPropertiesDTO(List<PropertyEntity> propertiesEntity){
        if(isNull(propertiesEntity)) return null;
        return propertiesEntity.stream()
                .map(propertyDTO -> propertyEntityToPropertyDTO.convert(propertyDTO))
                .collect(Collectors.toList());
    }
}
