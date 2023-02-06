package com.example.rets_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "property_school")
@Data
public class PropertySchoolEntity {

    @Id
    @GeneratedValue
    @Column(name="propertySchool_id")
    private Long propertySchoolId;

    @ManyToOne(targetEntity = PropertyEntity.class)
    @JoinColumn(name = "property_id")
    private Long propertyId;

    @ManyToOne(targetEntity = SchoolEntity.class)
    @JoinColumn(name = "school_id")
    private Long schoolId;


}
