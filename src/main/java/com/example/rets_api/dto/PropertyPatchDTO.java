package com.example.rets_api.dto;

import com.example.rets_api.resource.Enums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyPatchDTO {

    private int age;

    private String horseFacilities;

    private Enums.Indicator horseFacilitiesIndicator;

    private String hotTub;

    private Enums.Indicator hotTubIndicator;

    private String tennisCourt;

    private Enums.Indicator tennisCourtIndicator;

    private String inclusions;

    private String energyInformation;

    private String constructionMaterial;

    private String disabilityFeatures;

    private Enums.Indicator disabilityFeaturesIndicator;

    private String securityFeatures;

    private Enums.Indicator securityFeaturesIndicator;

    private Boolean propertyTypeRental;

    private Boolean propertyTypeFarm;

    private Boolean propertyTypeCondo;

    private Boolean propertyTypeTownHouse;

    private String firePlaceFuelType;

    private String firePlaceDetails;

    private String floorsHardwood;

    private Enums.Indicator floorsHardwoodIndicator;

    private Boolean displayFlagListing;

    private Boolean displayFlagAddress;

    private String lotSizeRange;

    private Enums.AreaUnit lotSizeRangeUnits;

    private Enums.LengthWidthUnit lotSizeWidthUnits;

    private Enums.LengthWidthUnit diningRoomWidthUnits;

    private Enums.LengthWidthUnit familyRoomWidthUnits;

    private Enums.LengthWidthUnit livingRoomWidthUnits;

    private Enums.LengthWidthUnit basementWidthUnits;

    private Enums.LengthWidthUnit lotSizeLengthUnits;

    private Enums.LengthWidthUnit diningRoomLengthUnits;

    private Enums.LengthWidthUnit livingRoomLengthUnits;

    private Enums.LengthWidthUnit familyRoomLengthUnits;

    private Enums.LengthWidthUnit basementLengthUnits;

    private int parkingTotal;

    private Enums.Operator parkingTotalOperator;
}
