package com.example.rets_api.entity;

import com.example.rets_api.resource.Enums.*;

import javax.persistence.*;

public class CommunityEntity {

    @Id
    @GeneratedValue
    @Column(name = "community_id")
    private long communityId;

    private String name;

    private CommunityType type;

    private Indicator indicator;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;
}
