package com.example.rets_api.entity;

import com.example.rets_api.resource.Enums.*;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "lotData")
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

    private String CornerLot;
    private Indicator CornerLotIndicator;

    private String CuldeSac;
    private Indicator CuldeSacIndicator;

    private String GolfCourseLot;
    private Indicator GolfCourseLotIndicator;



}
