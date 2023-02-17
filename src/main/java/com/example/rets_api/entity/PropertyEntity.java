package com.example.rets_api.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

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

    private int bedroomsQty;

    private int bathroomsQty;

    @OneToOne(mappedBy= "property", cascade = CascadeType.ALL)
    private FinancialDataEntity financialData;

    @ManyToMany(mappedBy= "propertyList", cascade = CascadeType.ALL)
    private List<SchoolEntity> schoolList;

    @OneToMany(mappedBy= "property", cascade = CascadeType.ALL)
    private List<RoomEntity> roomList;

    @OneToOne(mappedBy= "property", cascade = CascadeType.ALL)
    private ViewDataEntity viewData;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "community_id")
    private CommunityEntity community;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "animal_policy_id")
    private AnimalPolicyEntity animalPolicy;

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
        if(!isNull(community)) community.setProperties(Arrays.asList(this));
        if(!isNull(viewData)) viewData.setProperty(this);
        if(!isNull(animalPolicy)) animalPolicy.setProperties(Arrays.asList(this));
        if(!isNull(lotData)) lotData.setPropertyList(Arrays.asList(this));
    }

}
