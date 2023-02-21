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

    private int propertyAgeStart = DEFAULT_INTEGER_VALUE;

    private Operator propertyAgeStartOperator = Operator.DEFAULT_ENUM_VALUE;

    private int propertyAgeEnd = DEFAULT_INTEGER_VALUE;

    private Operator propertyAgeEndOperator = Operator.DEFAULT_ENUM_VALUE;

    private int propertyBedroomsQtyStart = DEFAULT_INTEGER_VALUE;

    private Operator propertyBedroomsQtyStartOperator = Operator.DEFAULT_ENUM_VALUE;

    private int propertyBedroomsQtyEnd = DEFAULT_INTEGER_VALUE;

    private Operator propertyBedroomsQtyEndOperator = Operator.DEFAULT_ENUM_VALUE;

    private int propertyBathroomsQtyStart = DEFAULT_INTEGER_VALUE;

    private Operator propertyBathroomsQtyStartOperator = Operator.DEFAULT_ENUM_VALUE;

    private int propertyBathroomsQtyEnd = DEFAULT_INTEGER_VALUE;

    private Operator propertyBathroomsQtyEndOperator = Operator.DEFAULT_ENUM_VALUE;

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

    private Long financialDataRentalAmountStart = DEFAULT_LONG_VALUE;

    private Operator financialDataRentalAmountStartOperator = Operator.DEFAULT_ENUM_VALUE;

    private Long financialDataRentalAmountEnd = DEFAULT_LONG_VALUE;

    private Operator financialDataRentalAmountEndOperator = Operator.DEFAULT_ENUM_VALUE;

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

    private String propertyFirePlaceFuelType = DEFAULT_STRING_VALUE;

    private String propertyFirePlaceDetails = DEFAULT_STRING_VALUE;

    private String propertyFloorsHardwood = DEFAULT_STRING_VALUE;

    private Indicator propertyFloorsHardwoodIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Boolean propertyDisplayFlagListing = DEFAULT_BOOLEAN_VALUE;

    private Boolean propertyDisplayFlagAddress = DEFAULT_BOOLEAN_VALUE;

    private String propertyLotSizeRange = DEFAULT_STRING_VALUE;

    private AreaUnit propertyLotSizeRangeUnits = AreaUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit propertyLotSizeWidthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit propertyDiningRoomWidthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit propertyFamilyRoomWidthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit propertyLivingRoomWidthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit propertyBasementWidthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit propertyLotSizeLengthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit propertyDiningRoomLengthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit propertyLivingRoomLengthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit propertyFamilyRoomLengthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private LengthWidthUnit propertyBasementLengthUnits = LengthWidthUnit.DEFAULT_ENUM_VALUE;

    private int propertyParkingTotal = DEFAULT_NUMBER_VALUE ;

    private Operator propertyParkingTotalOperator = Operator.DEFAULT_ENUM_VALUE;

}
