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

    private int age = 0;

    private String horseFacilities = DEFAULT_STRING_VALUE;

    private List<SchoolDTO> schoolList = Collections.emptyList();

    private List<BathSize> bathSizes = Collections.emptyList();

    private Indicator cornerLotIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator culdeSacIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator golfCourseLotIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private int bedroomsQty = DEFAULT_ROOM_QTY;

    private int bathroomsQty = DEFAULT_ROOM_QTY;

    private Indicator horseFacilitiesIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private String hotTub = DEFAULT_STRING_VALUE;

    private Indicator hotTubIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private String tennisCourt = DEFAULT_STRING_VALUE;

    private Indicator tennisCourtIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private String inclusions = DEFAULT_STRING_VALUE;

    private String energyInformation = DEFAULT_STRING_VALUE;

    private String constructionMaterial = DEFAULT_STRING_VALUE;

    private String disabilityFeatures = DEFAULT_STRING_VALUE;

    private Indicator disabilityFeaturesIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private String securityFeatures = DEFAULT_STRING_VALUE;

    private Indicator securityFeaturesIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Boolean propertyTypeRental = DEFAULT_BOOLEAN_VALUE;

    private Boolean propertyTypeFarm = DEFAULT_BOOLEAN_VALUE;

    private Boolean propertyTypeCondo = DEFAULT_BOOLEAN_VALUE;

    private Boolean propertyTypeTownHouse = DEFAULT_BOOLEAN_VALUE;

    private Indicator cityLightIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator mountainIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator riverIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator lakeIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator golfCourseIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator waterIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private String leaseOption = DEFAULT_STRING_VALUE;

    private Indicator leaseIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator animalPermitted = Indicator.DEFAULT_ENUM_VALUE;

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
