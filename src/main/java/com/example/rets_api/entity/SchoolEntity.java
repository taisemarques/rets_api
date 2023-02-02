package com.example.rets_api.entity;

import javax.persistence.*;

public class SchoolEntity {

    @Id
    @GeneratedValue
    @Column(name="school_id")

    private Long schoolId;

    private String primary;

    private String jrHigh;

    @OneToOne
    @JoinColumn(name="property_id")
    private PropertyEntity property;

    @Override
    public String toString() {
        return "School{" +
                "schoolId=" + schoolId +
                ", primary='" + primary + '\'' +
                ", jrHigh='" + jrHigh + '\'' +
                '}';
    }
}
