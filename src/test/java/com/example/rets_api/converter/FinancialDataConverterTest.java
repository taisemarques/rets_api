package com.example.rets_api.converter;

import com.example.rets_api.dto.FinancialDataDTO;
import com.example.rets_api.entity.FinancialDataEntity;
import com.example.rets_api.utils.DtoUtilsTest;
import com.example.rets_api.utils.EntityUtilsTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class FinancialDataConverterTest {

    //DTO To Entity

    @Test
    public void dtoTOEntity_NullFinancialDataConverter_ShouldReturnNull(){
        FinancialDataEntity financialDataEntity = FinancialDataConverter.financialDataDTOToFinancialDataEntity.convert(null);
        assertNull(financialDataEntity);
    }

    @Test
    public void dtoTOEntity_EmptyFinancialDataConverter_ShouldReturnEmpty(){
        FinancialDataDTO financialDataDTO = FinancialDataDTO.builder().build();
        FinancialDataEntity financialDataEntity = FinancialDataConverter.financialDataDTOToFinancialDataEntity.convert(financialDataDTO);
        checkNullAllFields_FinancialDataEntity(financialDataEntity);
    }

    @Test
    public void dtoTOEntity_FinancialDataConverter_ShouldReturnCompleteObject(){
        FinancialDataDTO financialDataDTO = DtoUtilsTest.createFinancialDataDTO();
        FinancialDataEntity financialDataEntity = FinancialDataConverter.financialDataDTOToFinancialDataEntity.convert(financialDataDTO);
        checkAllFields_FinancialData(financialDataEntity, financialDataDTO);
    }

    //Entity To DTO

    @Test
    public void entityToDTO_NullFinancialDataConverter_ShouldReturnNull(){
        FinancialDataDTO financialDataDTO = FinancialDataConverter.financialDataEntityToFinancialDataDTO.convert(null);
        assertNull(financialDataDTO);
    }

    @Test
    public void entityToDTO_EmptyFinancialDataConverter_ShouldReturnEmpty(){
        FinancialDataEntity financialDataEntity = new FinancialDataEntity();
        FinancialDataDTO financialDataDTO = FinancialDataConverter.financialDataEntityToFinancialDataDTO.convert(financialDataEntity);
        checkNullAllFields_FinancialDataDTO(financialDataDTO);
    }

    @Test
    public void entityToDTO_FinancialDataConverter_ShouldReturnCompleteObject(){
        FinancialDataEntity financialDataEntity = EntityUtilsTest.createFinancialDataEntity();
        FinancialDataDTO financialDataDTO = FinancialDataConverter.financialDataEntityToFinancialDataDTO.convert(financialDataEntity);
        checkAllFields_FinancialData(financialDataEntity, financialDataDTO);
    }

    private void checkNullAllFields_FinancialDataEntity(FinancialDataEntity financialData){
        assertNull(financialData.getLeaseOption());
        assertNull(financialData.getLeaseIndicator());
        assertNull(financialData.getTradeOption());
        assertNull(financialData.getTradeIndicator());
        assertNull(financialData.getRentalAmount());
        assertNull(financialData.getRentalAmountType());
        assertNull(financialData.getRentalAmountCurrencyCode());
        assertNull(financialData.getRentalAmountPeriod());
        assertNull(financialData.getRentalAmountUnit());
    }

    private void checkNullAllFields_FinancialDataDTO(FinancialDataDTO financialData){
        assertNull(financialData.getLeaseOption());
        assertNull(financialData.getLeaseIndicator());
        assertNull(financialData.getTradeOption());
        assertNull(financialData.getTradeIndicator());
        assertNull(financialData.getRentalAmount());
        assertNull(financialData.getRentalAmountType());
        assertNull(financialData.getRentalAmountCurrencyCode());
        assertNull(financialData.getRentalAmountPeriod());
        assertNull(financialData.getRentalAmountUnit());
    }

    public static void checkAllFields_FinancialData(FinancialDataEntity financialDataEntity, FinancialDataDTO financialDataDTO) {
        assertEquals(financialDataEntity.getLeaseOption(), financialDataDTO.getLeaseOption());
        assertEquals(financialDataEntity.getLeaseIndicator(), financialDataDTO.getLeaseIndicator());
        assertEquals(financialDataEntity.getTradeOption(), financialDataDTO.getTradeOption());
        assertEquals(financialDataEntity.getTradeIndicator(), financialDataDTO.getTradeIndicator());
        assertEquals(financialDataEntity.getRentalAmount(), financialDataDTO.getRentalAmount());
        assertEquals(financialDataEntity.getRentalAmountType(), financialDataDTO.getRentalAmountType());
        assertEquals(financialDataEntity.getRentalAmountCurrencyCode(), financialDataDTO.getRentalAmountCurrencyCode());
        assertEquals(financialDataEntity.getRentalAmountPeriod(), financialDataDTO.getRentalAmountPeriod());
        assertEquals(financialDataEntity.getRentalAmountUnit(), financialDataDTO.getRentalAmountUnit());
    }

}
