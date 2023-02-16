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

    @OneToOne(mappedBy = "agentPhone")
    private ContactInformationEntity agentPhoneContactInformationEntity;

    @OneToOne(mappedBy = "listAgentPhone")
    private ContactInformationEntity listAgentPhoneContactInformationEntity;

    @OneToOne(mappedBy = "salesAgentPhone")
    private ContactInformationEntity salesAgentPhoneContactInformationEntity;

    @OneToOne(mappedBy = "officePhone")
    private ContactInformationEntity officePhoneContactInformationEntity;

    @OneToOne(mappedBy = "listOfficePhone")
    private ContactInformationEntity listOfficePhoneContactInformationEntity;

    @OneToOne(mappedBy = "salesOfficePhone")
    private ContactInformationEntity salesOfficePhoneContactInformationEntity;
}

