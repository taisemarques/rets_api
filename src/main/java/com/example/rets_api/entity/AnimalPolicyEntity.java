package com.example.rets_api.entity;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static com.example.rets_api.resource.Enums.*;

@Entity(name = "animal_policy")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnimalPolicyEntity {

    @Id
    @GeneratedValue
    @Column(name="animal_policy_id")
    private Long animalPolicyId;

    private Indicator animalsPermitted;

    private String permittedTypes;

    private Long weightLimit;

    private WeightUnit weightUnit;

    @OneToMany(mappedBy= "animalPolicy")
    private List<PropertyEntity> properties;

}
