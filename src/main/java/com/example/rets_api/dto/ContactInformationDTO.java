package com.example.rets_api.dto;

import com.example.rets_api.entity.PhoneEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactInformationDTO {

    private PhoneDTO agentPhone;
    private PhoneDTO listAgentPhone;

    private PhoneDTO salesAgentPhone;

    private PhoneDTO officePhone;
    private PhoneDTO listOfficePhone;

    private PhoneDTO salesOfficePhone;
}
