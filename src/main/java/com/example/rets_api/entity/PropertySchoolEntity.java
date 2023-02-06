package com.example.rets_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PropertySchoolEntity {

    @EmbeddedId
    @Column(name="propertySchool_id")
    private Long propertySchoolId;

    @ManyToOne
    @MapsId("propertyId")
    @JoinColumn(name = "property_id")
    private Long propertyId;

    @ManyToOne
    @MapsId("schoolId")
    @JoinColumn(name = "school_id")
    private Long schoolId;


}
