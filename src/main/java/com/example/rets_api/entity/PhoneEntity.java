package com.example.rets_api.entity;
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

    @OneToOne(mappedBy = "agentPhone", cascade = CascadeType.ALL)
    private ContactInformationEntity agentPhoneContactInformationEntity;

    @OneToOne(mappedBy = "listAgentPhone", cascade = CascadeType.ALL)
    private ContactInformationEntity listAgentPhoneContactInformationEntity;

    @OneToOne(mappedBy = "salesAgentPhone", cascade = CascadeType.ALL)
    private ContactInformationEntity salesAgentPhoneContactInformationEntity;

    @OneToOne(mappedBy = "officePhone", cascade = CascadeType.ALL)
    private ContactInformationEntity officePhoneContactInformationEntity;

    @OneToOne(mappedBy = "listOfficePhone", cascade = CascadeType.ALL)
    private ContactInformationEntity listOfficePhoneContactInformationEntity;

    @OneToOne(mappedBy = "salesOfficePhone", cascade = CascadeType.ALL)
    private ContactInformationEntity salesOfficePhoneContactInformationEntity;
}

