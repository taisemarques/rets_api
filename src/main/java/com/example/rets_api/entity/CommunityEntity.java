package com.example.rets_api.entity;

import com.example.rets_api.resource.Enums.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "community")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommunityEntity {

    @Id
    @GeneratedValue
    @Column(name = "community_id")
    private long communityId;

    private String clubHouse;
    private Indicator clubHouseIndicator;

    private String exerciseArea;
    private Indicator exerciseAreaIndicator;

    private String golf;
    private Indicator golfIndicator;

    private String tennis;
    private Indicator tennisIndicator;

    private String recreationalFacilities;
    private Indicator recreationalFacilitiesIndicator;

    private String securityFeatures;
    private Indicator securityFeaturesIndicator;

    private String seniorCommunity;
    private Indicator seniorCommunityIndicator;

    private String hotTub;
    private Indicator hotTubIndicator;

    private String pool;
    private Indicator poolIndicator;

    private String boatFacilities;
    private Indicator boatFacilitiesIndicator;

    private String horseFacilities;
    private Indicator horseFacilitiesIndicator;

    private String communityPark;
    private Indicator communityParkIndicator;

    @OneToMany(mappedBy= "community")
    private List<PropertyEntity> properties;
}
