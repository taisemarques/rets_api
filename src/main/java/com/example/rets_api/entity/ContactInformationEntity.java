package com.example.rets_api.entity;

import lombok.*;

import javax.persistence.*;

import static java.util.Objects.isNull;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agentPhone")
    private PhoneEntity agentPhone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "listAgentPhone")
    private PhoneEntity listAgentPhone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salesAgentPhone")
    private PhoneEntity salesAgentPhone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "officePhone")
    private PhoneEntity officePhone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "listOfficePhone")
    private PhoneEntity listOfficePhone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salesOfficePhone")
    private PhoneEntity salesOfficePhone;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

    @PrePersist
    void updateBeforeSave() {
        updateNestedObjects();
    }

    private void updateNestedObjects() {
        if (!isNull(agentPhone)) agentPhone.setAgentPhoneContactInformationEntity(this);
        if (!isNull(listAgentPhone)) listAgentPhone.setListAgentPhoneContactInformationEntity(this);
        if (!isNull(salesAgentPhone)) salesAgentPhone.setSalesAgentPhoneContactInformationEntity(this);
        if (!isNull(officePhone)) officePhone.setOfficePhoneContactInformationEntity(this);
        if (!isNull(listOfficePhone)) listOfficePhone.setListOfficePhoneContactInformationEntity(this);
        if (!isNull(salesOfficePhone)) salesOfficePhone.setSalesOfficePhoneContactInformationEntity(this);
    }

}
