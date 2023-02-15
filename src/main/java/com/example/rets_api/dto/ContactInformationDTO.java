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

    private PhoneEntity agentPhone;
    private PhoneEntity listAgentPhone;

    private PhoneEntity salesAgentPhone;

    private PhoneEntity officePhone;
    private PhoneEntity listOfficePhone;

    private PhoneEntity salesOfficePhone;
}
