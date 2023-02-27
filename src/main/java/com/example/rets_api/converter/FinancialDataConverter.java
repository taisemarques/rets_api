package com.example.rets_api.converter;

import com.example.rets_api.dto.FinancialDataDTO;
import com.example.rets_api.entity.FinancialDataEntity;
import org.springframework.core.convert.converter.Converter;

import static java.util.Objects.isNull;

public class FinancialDataConverter {

    public static Converter<FinancialDataDTO, FinancialDataEntity> financialDataDTOToFinancialDataEntity = in -> {
        if(isNull(in)) return null;
        FinancialDataEntity financialDataEntity = new FinancialDataEntity();
        financialDataEntity.setLeaseOption(in.getLeaseOption());
        financialDataEntity.setLeaseIndicator(in.getLeaseIndicator());
        financialDataEntity.setTradeOption(in.getTradeOption());
        financialDataEntity.setTradeIndicator(in.getTradeIndicator());
        financialDataEntity.setRentalAmount(in.getRentalAmount());
        financialDataEntity.setRentalAmountType(in.getRentalAmountType());
        financialDataEntity.setRentalAmountCurrencyCode(in.getRentalAmountCurrencyCode());
        financialDataEntity.setRentalAmountPeriod(in.getRentalAmountPeriod());
        financialDataEntity.setRentalAmountUnit(in.getRentalAmountUnit());
        return financialDataEntity;




    };

    public static Converter<FinancialDataEntity, FinancialDataDTO> financialDataEntityToFinancialDataDTO = in -> {
        if(isNull(in)) return null;
        return FinancialDataDTO.builder()
                .leaseOption(in.getLeaseOption())
                .leaseIndicator(in.getLeaseIndicator())
                .tradeOption(in.getTradeOption())
                .tradeIndicator(in.getTradeIndicator())
                .rentalAmount(in.getRentalAmount())
                .rentalAmountType(in.getRentalAmountType())
                .rentalAmountCurrencyCode(in.getRentalAmountCurrencyCode())
                .rentalAmountPeriod(in.getRentalAmountPeriod())
                .rentalAmountUnit(in.getRentalAmountUnit())
                .build();
    };

}
