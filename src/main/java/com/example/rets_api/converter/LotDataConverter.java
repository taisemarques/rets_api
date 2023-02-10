package com.example.rets_api.converter;

import com.example.rets_api.dto.LotDataDTO;
import com.example.rets_api.entity.LotDataEntity;
import org.springframework.core.convert.converter.Converter;
import static java.util.Objects.isNull;

public class LotDataConverter {


    public static Converter<LotDataDTO, LotDataEntity> lotDataDTOToLotDataEntity = in -> {
        if(isNull(in)) return null;
        LotDataEntity retsEntity = new LotDataEntity();
        retsEntity.setCornerLot(in.getCornerLot());
        retsEntity.setCornerLotIndicator(in.getCornerLotIndicator());
        retsEntity.setCuldeSac(in.getCuldeSac());
        retsEntity.setCuldeSacIndicator(in.getCuldeSacIndicator());
        return retsEntity;
    };

    public static Converter<LotDataEntity, LotDataDTO> lotDataEntityToLotDataDTO = in -> {
        if (isNull(in)) return null;
        return LotDataDTO.builder()
                .CornerLot(in.getCornerLot())
                .CornerLotIndicator(in.getCornerLotIndicator())
                .CuldeSac(in.getCuldeSac())
                .CuldeSacIndicator(in.getCuldeSacIndicator())
                .build();
    };
}
