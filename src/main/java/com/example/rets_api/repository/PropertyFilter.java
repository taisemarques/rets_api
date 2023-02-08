package com.example.rets_api.repository;

import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.Enums.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class PropertyFilter {
    private int age = 0;
    private String horseFacilities = null;
    private List<SchoolDTO> schoolList = null;
    private int bedroomsQty = -1;
    private int bathroomsQty = -1;

    private Indicator horseFacilitiesIndicator = null;

    private String hotTub = null;

    private Indicator hotTubIndicator = null;

    private String tennisCourt = null;

    private Indicator tennisCourtIndicator = null;

    private String inclusions = null;

    private String energyInformation = null;

    private String constructionMaterial = null;

    private String disabilityFeatures = null;

    private Indicator disabilityFeaturesIndicator = null;

    private String securityFeatures = null;

    private Indicator securityFeaturesIndicator = null;

    private Boolean propertyTypeRental = null;

    private Boolean propertyTypeFarm = null;

    private Boolean propertyTypeCondo = null;

    private Boolean propertyTypeTownHouse = null;

}
