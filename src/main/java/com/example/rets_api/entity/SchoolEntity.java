package com.example.rets_api.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "school")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SchoolEntity {

    @Id
    @GeneratedValue
    @Column(name = "school_id")
    private Long schoolId;

    private String primarySchool;

    private String jrHigh;

    @ManyToMany
    @JoinTable(name = "property_school",
            joinColumns = @JoinColumn(name = "school_id"),
            inverseJoinColumns = @JoinColumn(name = "property_id"))
    private List<PropertyEntity> propertyList;

}

