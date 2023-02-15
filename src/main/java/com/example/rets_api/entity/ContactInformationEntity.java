package com.example.rets_api.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "contact_information")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactInformationEntity {

    @Id
    @GeneratedValue
    @Column(name = "contact_information_id")
    private Long contactInformationId;

    @OneToOne(mappedBy = "contactInformation", cascade = CascadeType.ALL)
    private PhoneEntity agentPhone;

    @OneToOne(mappedBy = "contactInformation", cascade = CascadeType.ALL)
    private PhoneEntity listAgentPhone;

    @OneToOne(mappedBy = "contactInformation", cascade = CascadeType.ALL)
    private PhoneEntity salesAgentPhone;

    @OneToOne(mappedBy = "contactInformation", cascade = CascadeType.ALL)
    private PhoneEntity officePhone;

    @OneToOne(mappedBy = "contactInformation", cascade = CascadeType.ALL)
    private PhoneEntity listOfficePhone;

    @OneToOne(mappedBy = "contactInformation", cascade = CascadeType.ALL)
    private PhoneEntity salesOfficePhone;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

}
