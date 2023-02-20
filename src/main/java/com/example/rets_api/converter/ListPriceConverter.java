package com.example.rets_api.converter;

import com.example.rets_api.dto.ListPriceDTO;
import com.example.rets_api.entity.ListPriceEntity;
import org.springframework.core.convert.converter.Converter;

import static java.util.Objects.isNull;

public class ListPriceConverter {

    public static Converter<ListPriceDTO, ListPriceEntity> listPriceDTOToListPriceEntity = in -> {
        if(isNull(in)) return null;
        ListPriceEntity listPriceEntity = new ListPriceEntity();
        listPriceEntity.setLowAmount(in.getLowAmount());
        listPriceEntity.setHighAmount(in.getHighAmount());
        listPriceEntity.setCurrencyCode(in.getCurrencyCode());
        listPriceEntity.setUnits(in.getUnits());
        return listPriceEntity;
    };
    public static Converter<ListPriceEntity, ListPriceDTO> listPriceEntityToListPriceDTO = in -> {
        if(isNull(in)) return null;
        return ListPriceDTO.builder()
                .lowAmount(in.getLowAmount())
                .highAmount(in.getHighAmount())
                .currencyCode(in.getCurrencyCode())
                .units(in.getUnits())
                .build();
    };
}
