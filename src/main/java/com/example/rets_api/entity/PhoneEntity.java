package com.example.rets_api.entity;

import com.example.rets_api.entity.ContactInformationEntity;
import lombok.*;

import javax.persistence.*;

@Entity(name = "phone")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phone_id")
    private Long phoneId;

    private String primaryPhone;
    private String alternatePhone;

    @OneToOne
    @JoinColumn(name = "contactInformationId")
    private ContactInformationEntity contactInformation;
}

