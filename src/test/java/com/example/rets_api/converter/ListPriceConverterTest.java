package com.example.rets_api.converter;

import com.example.rets_api.dto.ListPriceDTO;
import com.example.rets_api.entity.ListPriceEntity;
import com.example.rets_api.repository.UtilsTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ListPriceConverterTest {

    // DTO To Entity

    @Test
    public void dtoTOEntity_NullListPriceConverter_ShouldReturnNull(){
        ListPriceEntity listPriceEntity = ListPriceConverter.listPriceDTOToListPriceEntity.convert(null);
        assertNull(listPriceEntity);
    }
    @Test
    public void dtoTOEntity_EmptyListPriceConverter_ShouldReturnEmpty(){
        ListPriceDTO listPriceDTO = ListPriceDTO.builder().build();
        ListPriceEntity listPrice = ListPriceConverter.listPriceDTOToListPriceEntity.convert(listPriceDTO);
        checkNullAllFields_ListPriceEntity(listPrice);
    }



    @Test
    public void dtoTOEntity_ListPriceConverter_ShouldReturnCompleteObject(){
        ListPriceDTO listPriceDTO = UtilsTest.createListPriceDTO();
        ListPriceEntity listPriceEntity = ListPriceConverter.listPriceDTOToListPriceEntity.convert(listPriceDTO);
        checkAllFields_ListPrice(listPriceEntity, listPriceDTO);
    }



    // Entity To DTO
    @Test
    public void entityTODTO_NullListPriceConverter_ShouldReturnNull(){
        ListPriceDTO listPriceDTO = ListPriceConverter.listPriceEntityToListPriceDTO.convert(null);
        assertNull(listPriceDTO);
    }
    @Test
    public void entityTODTO_EmptyListPriceConverter_ShouldReturnEmpty(){
        ListPriceEntity listPriceEntity = new ListPriceEntity();
        ListPriceDTO listPriceDTO = ListPriceConverter.listPriceEntityToListPriceDTO.convert(listPriceEntity);
        checkNullAllFields_ListPriceDTO(listPriceDTO);
    }
    @Test
    public void entityTODTO_ListPriceConverter_ShouldReturnCompleteObject(){
        ListPriceEntity listPriceEntity = UtilsTest.createListPriceEntity();
        ListPriceDTO listPriceDTO = ListPriceConverter.listPriceEntityToListPriceDTO.convert(listPriceEntity);
        checkAllFields_ListPrice(listPriceEntity, listPriceDTO);
    }





    private void checkNullAllFields_ListPriceEntity(ListPriceEntity listPrice) {
        assertNull(listPrice.getLowAmount());
        assertNull(listPrice.getHighAmount());
        assertNull(listPrice.getLowAmountType());
        assertNull(listPrice.getHighAmountType());
        assertNull(listPrice.getLowAmountCurrencyCode());
        assertNull(listPrice.getHighAmountCurrencyCode());
        assertNull(listPrice.getUnits());
    }
    private void checkNullAllFields_ListPriceDTO(ListPriceDTO listPriceDTO) {
        assertNull(listPriceDTO.getLowAmount());
        assertNull(listPriceDTO.getHighAmount());
        assertNull(listPriceDTO.getLowAmountType());
        assertNull(listPriceDTO.getHighAmountType());
        assertNull(listPriceDTO.getLowAmountCurrencyCode());
        assertNull(listPriceDTO.getHighAmountCurrencyCode());
        assertNull(listPriceDTO.getUnits());
    }
    public static void checkAllFields_ListPrice(ListPriceEntity listPriceEntity, ListPriceDTO listPriceDTO) {
        assertEquals(listPriceEntity.getLowAmount(), listPriceDTO.getLowAmount());
        assertEquals(listPriceEntity.getHighAmount(), listPriceDTO.getHighAmount());
        assertEquals(listPriceEntity.getLowAmountType(), listPriceDTO.getLowAmountType());
        assertEquals(listPriceEntity.getHighAmountType(), listPriceDTO.getHighAmountType());
        assertEquals(listPriceEntity.getLowAmountCurrencyCode(), listPriceDTO.getLowAmountCurrencyCode());
        assertEquals(listPriceEntity.getHighAmountCurrencyCode(), listPriceDTO.getHighAmountCurrencyCode());

    }


}
