package com.example.rets_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SchoolEntity {

    @Id
    @GeneratedValue
    @Column(name = "school_id")

    private Long schoolId;

    private String primarySchool;

    private String jrHigh;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

    @Override
    public String toString() {
        return "SchoolEntity{" +
                "schoolId=" + schoolId +
                ", primarySchool='" + primarySchool + '\'' +
                ", jrHigh='" + jrHigh + '\'' +
                ", property=" + property +
                '}';
    }
}

