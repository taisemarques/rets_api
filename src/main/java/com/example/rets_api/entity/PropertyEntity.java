package com.example.rets_api.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.example.rets_api.resource.Enums.*;
import static java.util.Objects.isNull;

@Entity(name = "property")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PropertyEntity {

    @Id
    @GeneratedValue
    @Column(name="property_id")
    private Long propertyId;

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

    @OneToOne(mappedBy= "property", cascade = CascadeType.ALL)
    private FinancialDataEntity financialData;

    private int bedroomsQty;

    private int bathroomsQty;

    @ManyToMany(mappedBy= "propertyList", cascade = CascadeType.ALL)
    private List<SchoolEntity> schoolList;

    @OneToMany(mappedBy= "property", cascade = CascadeType.ALL)
    private List<RoomEntity> roomList;

    @OneToOne(mappedBy= "property", cascade = CascadeType.ALL)
    private ViewDataEntity viewData;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "lotData_id")
    private LotDataEntity lotData;

    @PrePersist
    void updateBeforeSave(){
        updateRoomQuantity();
        updateNestedObjects();
    }

     void updateRoomQuantity(){
        bedroomsQty = 0;
        bathroomsQty = 0;

        if(!isNull(roomList)) {
            for (RoomEntity room : roomList) {
                if (room.isBedroom()) {
                    bedroomsQty++;
                }
                if (room.isBathroom()) {
                    bathroomsQty++;
                }
            }
        }
    }

    private void updateNestedObjects(){
        if(!isNull(schoolList)) schoolList.forEach(schoolEntity -> schoolEntity.setPropertyList(Arrays.asList(this)));
        if(!isNull(roomList)) roomList.forEach(roomEntity -> roomEntity.setProperty(this));
        if(!isNull(financialData)) financialData.setProperty(this);
        if(!isNull(viewData)) viewData.setProperty(this);
        if(!isNull(lotData)) lotData.setPropertyList(Arrays.asList(this));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropertyEntity)) return false;
        PropertyEntity that = (PropertyEntity) o;
        return getAge() == that.getAge() && getBedroomsQty() == that.getBedroomsQty() && getBathroomsQty() == that.getBathroomsQty() && Objects.equals(getHorseFacilities(), that.getHorseFacilities()) && getHorseFacilitiesIndicator() == that.getHorseFacilitiesIndicator() && Objects.equals(getHotTub(), that.getHotTub()) && getHotTubIndicator() == that.getHotTubIndicator() && Objects.equals(getTennisCourt(), that.getTennisCourt()) && getTennisCourtIndicator() == that.getTennisCourtIndicator() && Objects.equals(getInclusions(), that.getInclusions()) && Objects.equals(getEnergyInformation(), that.getEnergyInformation()) && Objects.equals(getConstructionMaterial(), that.getConstructionMaterial()) && Objects.equals(getDisabilityFeatures(), that.getDisabilityFeatures()) && getDisabilityFeaturesIndicator() == that.getDisabilityFeaturesIndicator() && Objects.equals(getSecurityFeatures(), that.getSecurityFeatures()) && getSecurityFeaturesIndicator() == that.getSecurityFeaturesIndicator() && Objects.equals(getPropertyTypeRental(), that.getPropertyTypeRental()) && Objects.equals(getPropertyTypeFarm(), that.getPropertyTypeFarm()) && Objects.equals(getPropertyTypeCondo(), that.getPropertyTypeCondo()) && Objects.equals(getPropertyTypeTownHouse(), that.getPropertyTypeTownHouse()) && Objects.equals(getFinancialData(), that.getFinancialData()) && Objects.equals(getSchoolList(), that.getSchoolList()) && Objects.equals(getRoomList(), that.getRoomList()) && Objects.equals(getViewData(), that.getViewData()) && Objects.equals(getLotData(), that.getLotData());
    }
}
