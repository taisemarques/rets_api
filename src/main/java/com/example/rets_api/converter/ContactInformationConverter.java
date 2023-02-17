package com.example.rets_api.converter;

import com.example.rets_api.dto.ContactInformationDTO;
import com.example.rets_api.entity.ContactInformationEntity;
import org.springframework.core.convert.converter.Converter;

import static java.util.Objects.isNull;

public class ContactInformationConverter {

    public static Converter<ContactInformationDTO, ContactInformationEntity> contactInformationDTOContactInformationEntity = in -> {
        if(isNull(in)) return null;

        ContactInformationEntity retsEntity = new ContactInformationEntity();
        retsEntity.setAgentPhone(PhoneConverter.phoneDTOPhoneEntityConverter.convert(in.getAgentPhone()));
        retsEntity.setListAgentPhone(PhoneConverter.phoneDTOPhoneEntityConverter.convert(in.getListAgentPhone()));
        retsEntity.setSalesAgentPhone(PhoneConverter.phoneDTOPhoneEntityConverter.convert(in.getSalesAgentPhone()));
        retsEntity.setOfficePhone(PhoneConverter.phoneDTOPhoneEntityConverter.convert(in.getOfficePhone()));
        retsEntity.setListOfficePhone(PhoneConverter.phoneDTOPhoneEntityConverter.convert(in.getListOfficePhone()));
        retsEntity.setSalesOfficePhone(PhoneConverter.phoneDTOPhoneEntityConverter.convert(in.getSalesOfficePhone()));

        return retsEntity;
    };

    public static Converter<ContactInformationEntity, ContactInformationDTO> contactInformationEntityContactInformationDTO = in -> {
        if (isNull(in)) return null;
        return ContactInformationDTO.builder()
                .agentPhone(PhoneConverter.phoneEntityPhoneDTOConverter.convert(in.getAgentPhone()))
                .listAgentPhone(PhoneConverter.phoneEntityPhoneDTOConverter.convert(in.getListAgentPhone()))
                .salesAgentPhone(PhoneConverter.phoneEntityPhoneDTOConverter.convert(in.getSalesAgentPhone()))
                .officePhone(PhoneConverter.phoneEntityPhoneDTOConverter.convert(in.getOfficePhone()))
                .listOfficePhone(PhoneConverter.phoneEntityPhoneDTOConverter.convert(in.getListOfficePhone()))
                .salesOfficePhone(PhoneConverter.phoneEntityPhoneDTOConverter.convert(in.getSalesOfficePhone()))
                .build();
    };
}
