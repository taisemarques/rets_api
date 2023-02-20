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

    private List<String> phoneNumbers = Collections.emptyList();

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

    private Indicator clubHouseIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator exerciseAreaIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator golfIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator tennisIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator recreationalFacilitiesIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator securityFeaturesIndicatorOfCommunity = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator seniorCommunityIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator hotTubIndicatorOfCommunity = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator poolIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator boatFacilitiesIndicator = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator horseFacilitiesIndicatorOfCommunity = Indicator.DEFAULT_ENUM_VALUE;

    private Indicator communityParkIndicator = Indicator.DEFAULT_ENUM_VALUE;

}
