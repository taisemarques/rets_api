package com.example.rets_api.entity;

import com.example.rets_api.resource.Enums.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "lot_data")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LotDataEntity {

    @Id
    @GeneratedValue
    @Column(name = "lotData_id")
    private Long lotDataId;

    private String cornerLot;
    private Indicator cornerLotIndicator;

    private String culdeSac;
    private Indicator culdeSacIndicator;

    private String golfCourseLot;
    private Indicator golfCourseLotIndicator;

    @OneToMany(mappedBy = "lotData")
    private List<PropertyEntity> propertyList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LotDataEntity)) return false;
        LotDataEntity that = (LotDataEntity) o;
        return Objects.equals(getCornerLot(), that.getCornerLot()) && getCornerLotIndicator() == that.getCornerLotIndicator() && Objects.equals(getCuldeSac(), that.getCuldeSac()) && getCuldeSacIndicator() == that.getCuldeSacIndicator() && Objects.equals(getGolfCourseLot(), that.getGolfCourseLot()) && getGolfCourseLotIndicator() == that.getGolfCourseLotIndicator();
    }

}
