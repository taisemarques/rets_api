package com.example.rets_api.dto;

import com.example.rets_api.resource.Enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {

    private int age;

    private String horseFacilities;

    private Indicator horseFacilitiesIndicator;

    private String hotTub;

    private Indicator hotTubIndicator;

    private String tennisCourt;

    private Indicator tennisCourtIndicator;

    private String inclusions;

    private String energyInformation;

    private String constructionMaterial;

    private String disabilityFeatures;

    private Indicator disabilityFeaturesIndicator;

    private String securityFeatures;

    private Indicator securityFeaturesIndicator;

    private Boolean propertyTypeRental;

    private Boolean propertyTypeFarm;

    private Boolean propertyTypeCondo;

    private Boolean propertyTypeTownHouse;

    private FinancialDataDTO financialData;

    private List<SchoolDTO> schoolList;

    private List<RoomDTO> roomList;

    private ViewDataDTO viewData;

    private AnimalPolicyDTO animalPolicy;

    private CommunityDTO community;

    private LotDataDTO lotData;

    private ContactInformationDTO contactInformation;


    private String firePlaceFuelType;

    private String firePlaceDetails;

    private String floorsHardwood;

    private Indicator floorsHardwoodIndicator;

    private Boolean displayFlagListing;

    private Boolean displayFlagAddress;

    private String lotSizeRange;

    private AreaUnit lotSizeRangeUnits;

    private LengthWidthUnit lotSizeWidthUnits;

    private LengthWidthUnit diningRoomWidthUnits;

    private LengthWidthUnit familyRoomWidthUnits;

    private LengthWidthUnit livingRoomWidthUnits;

    private LengthWidthUnit basementWidthUnits;

    private LengthWidthUnit lotSizeLengthUnits;

    private LengthWidthUnit diningRoomLengthUnits;

    private LengthWidthUnit livingRoomLengthUnits;

    private LengthWidthUnit familyRoomLengthUnits;

    private LengthWidthUnit basementLengthUnits;

    private int parkingTotal;

    private Operator parkingTotalOperator;
}
