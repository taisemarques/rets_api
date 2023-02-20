package com.example.rets_api.resource;

import com.example.rets_api.dto.SchoolDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Collections;
import java.util.List;

import static com.example.rets_api.resource.Constants.*;
import static com.example.rets_api.resource.Enums.*;

@NoArgsConstructor
@Setter
@Getter
public class PropertyFilter {

    private int propertyAge = DEFAULT_NUMBER_VALUE;

    private int propertyBedroomsQty = DEFAULT_NUMBER_VALUE;

    private int propertyBathroomsQty = DEFAULT_NUMBER_VALUE;

    private String propertyHorseFacilitiesDescription = DEFAULT_STRING_VALUE;

    private Indicator propertyHorseFacilitiesIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private String propertyHotTubDescription = DEFAULT_STRING_VALUE;

    private Indicator propertyHotTubIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private String propertyTennisCourtDescription = DEFAULT_STRING_VALUE;

    private Indicator propertyTennisCourtIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private String propertyDisabilityFeaturesDescription = DEFAULT_STRING_VALUE;

    private Indicator propertyDisabilityFeaturesIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private String propertySecurityFeaturesDescription = DEFAULT_STRING_VALUE;

    private Indicator propertySecurityFeaturesIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private String propertyInclusionsDescription = DEFAULT_STRING_VALUE;

    private String propertyEnergyInformationDescription = DEFAULT_STRING_VALUE;

    private String propertyConstructionMaterialDescription = DEFAULT_STRING_VALUE;

    private Boolean propertyTypeRental = DEFAULT_BOOLEAN_VALUE;

    private Boolean propertyTypeFarm = DEFAULT_BOOLEAN_VALUE;

    private Boolean propertyTypeCondo = DEFAULT_BOOLEAN_VALUE;

    private Boolean propertyTypeTownHouse = DEFAULT_BOOLEAN_VALUE;

    private List<SchoolDTO> schoolList = Collections.emptyList();

    private List<BathSize> propertyBathSizes = Collections.emptyList();

    private Indicator lotDataCornerLotIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator lotDataCuldeSacIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator lotDataGolfCourseLotIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator viewDataCityLightIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator viewDataMountainIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator viewDataRiverIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator viewDataLakeIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator viewDataGolfCourseIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator viewDataWaterIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator financialDataTradeIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator financialDataLeaseIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Long financialDataRentalAmount = DEFAULT_LONG_VALUE;

    private Indicator animalPolicyAnimalPermitted = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator communityClubHouseIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator communityExerciseAreaIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator communityGolfIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator communityTennisIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator communityRecreationalFacilitiesIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator communitySecurityFeaturesIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator communitySeniorCommunityIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator communityHotTubIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator communityPoolIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator communityBoatFacilitiesIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator communityHorseFacilitiesIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator communityParkIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private List<String> contactInformationPhoneNumbers = Collections.emptyList();

    private String firePlaceFuelType = DEFAULT_STRING_VALUE;

    private String firePlaceDetails = DEFAULT_STRING_VALUE;;

    private String floorsHardwood = DEFAULT_STRING_VALUE;;

    private Indicator floorsHardwoodIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Boolean displayFlagListing = DEFAULT_BOOLEAN_VALUE;

    private Boolean displayFlagAddress = DEFAULT_BOOLEAN_VALUE;

    private String lotSizeRange = DEFAULT_STRING_VALUE;;

    private AreaUnit lotSizeRangeUnits = AreaUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit lotSizeWidthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit diningRoomWidthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit familyRoomWidthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit livingRoomWidthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit basementWidthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit lotSizeLengthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit diningRoomLengthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit livingRoomLengthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit familyRoomLengthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit basementLengthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private int parkingTotal = 0;

    private Operator parkingTotalOperator = Operator.DEFAULT_ENUM_VALUE;

}
