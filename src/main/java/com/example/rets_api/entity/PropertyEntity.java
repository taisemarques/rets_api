package com.example.rets_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PropertyEntity {

    @Id
    @GeneratedValue
    @Column(name="property_id")
    private Long propertyId;

    private String description;

    private Long price;

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", description =" + description +
                ", price =" + price + "}" ;
    }

}
