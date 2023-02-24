package com.example.rets_api.converter;

import com.example.rets_api.dto.ListingPriceDTO;
import com.example.rets_api.entity.ListingPriceEntity;
import org.springframework.core.convert.converter.Converter;

import static java.util.Objects.isNull;

public class ListingPriceConverter {

    public static Converter<ListingPriceDTO, ListingPriceEntity> listPriceDTOToListPriceEntity = in -> {
        if(isNull(in)) return null;
        ListingPriceEntity listingPriceEntity = new ListingPriceEntity();
        listingPriceEntity.setLowAmount(in.getLowAmount());
        listingPriceEntity.setHighAmount(in.getHighAmount());
        listingPriceEntity.setLowAmountType(in.getLowAmountType());
        listingPriceEntity.setHighAmountType(in.getHighAmountType());
        listingPriceEntity.setLowAmountCurrencyCode(in.getLowAmountCurrencyCode());
        listingPriceEntity.setHighAmountCurrencyCode(in.getHighAmountCurrencyCode());
        listingPriceEntity.setUnits(in.getUnits());
        return listingPriceEntity;
    };
    public static Converter<ListingPriceEntity, ListingPriceDTO> listPriceEntityToListPriceDTO = in -> {
        if(isNull(in)) return null;
        return ListingPriceDTO.builder()
                .lowAmount(in.getLowAmount())
                .highAmount(in.getHighAmount())
                .lowAmountType(in.getLowAmountType())
                .highAmountType(in.getHighAmountType())
                .lowAmountCurrencyCode(in.getLowAmountCurrencyCode())
                .highAmountCurrencyCode(in.getHighAmountCurrencyCode())
                .units(in.getUnits())
                .build();
    };
}
