package com.example.rets_api.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

import static com.example.rets_api.entity.Enums.*;
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
                if (room.getRoomType().equals(RoomType.MAIN_FLOOR_BEDROOM) || room.getRoomType().equals(RoomType.MASTER_BEDROOM)) {
                    bedroomsQty++;
                }
                if (room.getRoomType().equals(RoomType.MAIN_FLOOR_BATHROOM) || room.getRoomType().equals(RoomType.MASTER_BEDROOM)) {
                    bathroomsQty++;
                }
            }
        }
    }

    private void updateNestedObjects(){
        if(!isNull(schoolList)) schoolList.stream()
                .forEach(schoolEntity -> schoolEntity.setPropertyList(Arrays.asList(this)));
        if(!isNull(roomList)) roomList.stream()
                .forEach(roomEntity -> roomEntity.setProperty(this));
        if(!isNull(financialData)) financialData.setProperty(this);
    }

}
