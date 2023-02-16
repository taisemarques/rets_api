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

    //    @OneToOne(mappedBy = "contactInformation", cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agentPhone")
    private PhoneEntity agentPhone;

    //    @OneToOne(mappedBy = "contactInformation", cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "listAgentPhone")
    private PhoneEntity listAgentPhone;

    //    @OneToOne(mappedBy = "contactInformation", cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salesAgentPhone")
    private PhoneEntity salesAgentPhone;

    //    @OneToOne(mappedBy = "contactInformation", cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "officePhone")
    private PhoneEntity officePhone;

    //    @OneToOne(mappedBy = "contactInformation", cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "listOfficePhone")
    private PhoneEntity listOfficePhone;

    //    @OneToOne(mappedBy = "contactInformation", cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salesOfficePhone")
    private PhoneEntity salesOfficePhone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

    @PrePersist
    void updateBeforeSave() {
        updateNestedObjects();
    }

    private void updateNestedObjects() {
        if (!isNull(agentPhone)) agentPhone.setContactInformation(this);
        if (!isNull(listAgentPhone)) listAgentPhone.setContactInformation(this);
        if (!isNull(salesAgentPhone)) salesAgentPhone.setContactInformation(this);
        if (!isNull(officePhone)) officePhone.setContactInformation(this);
        if (!isNull(listOfficePhone)) listOfficePhone.setContactInformation(this);
        if (!isNull(salesOfficePhone)) salesOfficePhone.setContactInformation(this);
    }

}
