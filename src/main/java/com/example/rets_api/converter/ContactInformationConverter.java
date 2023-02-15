package com.example.rets_api.converter;

import com.example.rets_api.dto.ContactInformationDTO;
import com.example.rets_api.entity.ContactInformationEntity;
import org.springframework.core.convert.converter.Converter;

import static java.util.Objects.isNull;

public class ContactInformationConverter {

    public static Converter<ContactInformationDTO, ContactInformationEntity> contactInformationDTOContactInformationEntity = in -> {
        if(isNull(in)) return null;

        ContactInformationEntity retsEntity = new ContactInformationEntity();
        retsEntity.setAgentPhone(in.getAgentPhone());
        retsEntity.setListAgentPhone(in.getListAgentPhone());
        retsEntity.setSalesAgentPhone(in.getSalesAgentPhone());
        retsEntity.setOfficePhone(in.getOfficePhone());
        retsEntity.setListOfficePhone(in.getListOfficePhone());
        retsEntity.setSalesOfficePhone(in.getSalesOfficePhone());

        return retsEntity;
    };

    public static Converter<ContactInformationEntity, ContactInformationDTO> contactInformationEntityContactInformationDTO = in -> {
        if (isNull(in)) return null;
        return ContactInformationDTO.builder()
                .agentPhone(in.getAgentPhone())
                .listAgentPhone(in.getListAgentPhone())
                .salesAgentPhone(in.getSalesAgentPhone())
                .officePhone(in.getOfficePhone())
                .listOfficePhone(in.getListOfficePhone())
                .salesOfficePhone(in.getSalesOfficePhone())
                .build();
    };
}
