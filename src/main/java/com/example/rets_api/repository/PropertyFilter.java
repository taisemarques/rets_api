package com.example.rets_api.repository;

import com.example.rets_api.dto.RoomDTO;
import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.Enums.*;
import com.example.rets_api.entity.RoomEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static com.example.rets_api.entity.Enums.BathSize.DEFAULT_BATH_SIZE;
import static com.example.rets_api.entity.Enums.Indicator.DEFAULT_IND_VALUE;

@NoArgsConstructor
@Setter
@Getter
public class PropertyFilter {

    static final int DEFAULT_ROOM_QTY = -1;
    static final String DEFAULT_STRING_VALUE = "DEFAULT_STRING_VALUE";

    private int age = 0;
    private String horseFacilities = DEFAULT_STRING_VALUE;
    private List<SchoolDTO> schoolList = null;
    private int bedroomsQty = DEFAULT_ROOM_QTY;
    private int bathroomsQty = DEFAULT_ROOM_QTY;

    private Indicator horseFacilitiesIndicator = DEFAULT_IND_VALUE;

    private String hotTub = DEFAULT_STRING_VALUE;

    private Indicator hotTubIndicator = DEFAULT_IND_VALUE;

    private String tennisCourt = DEFAULT_STRING_VALUE;

    private Indicator tennisCourtIndicator = DEFAULT_IND_VALUE;

    private String inclusions = DEFAULT_STRING_VALUE;

    private String energyInformation = DEFAULT_STRING_VALUE;

    private String constructionMaterial = DEFAULT_STRING_VALUE;

    private String disabilityFeatures = DEFAULT_STRING_VALUE;

    private Indicator disabilityFeaturesIndicator = DEFAULT_IND_VALUE;

    private String securityFeatures = DEFAULT_STRING_VALUE;

    private Indicator securityFeaturesIndicator = DEFAULT_IND_VALUE;

    private Boolean propertyTypeRental = null;

    private Boolean propertyTypeFarm = null;

    private Boolean propertyTypeCondo = null;

    private Boolean propertyTypeTownHouse = null;

}
