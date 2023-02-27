package com.example.rets_api.converter;

import com.example.rets_api.dto.PhoneDTO;
import com.example.rets_api.entity.PhoneEntity;
import org.springframework.core.convert.converter.Converter;

import static java.util.Objects.isNull;

public class PhoneConverter {

    public static Converter<PhoneDTO, PhoneEntity> phoneDTOPhoneEntityConverter = in -> {
        if (isNull(in)) return null;
        PhoneEntity phoneEntity = new PhoneEntity();
        phoneEntity.setPrimaryPhone(in.getPrimaryPhone());
        phoneEntity.setAlternatePhone(in.getAlternatePhone());

        return phoneEntity;
    };

    public static Converter<PhoneEntity, PhoneDTO> phoneEntityPhoneDTOConverter = in -> {
      if(isNull(in)) return null;

      return PhoneDTO.builder()
              .primaryPhone(in.getPrimaryPhone())
              .alternatePhone(in.getAlternatePhone())
              .build();
    };


}
