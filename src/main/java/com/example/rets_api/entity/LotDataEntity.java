package com.example.rets_api.entity;

import com.example.rets_api.resource.Enums.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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



}
