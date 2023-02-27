package com.example.rets_api.converter;

import com.example.rets_api.dto.ListingPriceDTO;
import com.example.rets_api.entity.ListingPriceEntity;
import com.example.rets_api.repository.UtilsTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ListingPriceConverterTest {

    // DTO To Entity

    @Test
    public void dtoTOEntity_NullListPriceConverter_ShouldReturnNull(){
        ListingPriceEntity listingPriceEntity = ListingPriceConverter.listPriceDTOToListPriceEntity.convert(null);
        assertNull(listingPriceEntity);
    }
    @Test
    public void dtoTOEntity_EmptyListPriceConverter_ShouldReturnEmpty(){
        ListingPriceDTO listingPriceDTO = ListingPriceDTO.builder().build();
        ListingPriceEntity listingPrice = ListingPriceConverter.listPriceDTOToListPriceEntity.convert(listingPriceDTO);
        checkNullAllFields_ListPriceEntity(listingPrice);
    }



    @Test
    public void dtoTOEntity_ListPriceConverter_ShouldReturnCompleteObject(){
        ListingPriceDTO listingPriceDTO = UtilsTest.createListPriceDTO();
        ListingPriceEntity listingPriceEntity = ListingPriceConverter.listPriceDTOToListPriceEntity.convert(listingPriceDTO);
        checkAllFields_ListPrice(listingPriceEntity, listingPriceDTO);
    }



    // Entity To DTO
    @Test
    public void entityTODTO_NullListPriceConverter_ShouldReturnNull(){
        ListingPriceDTO listingPriceDTO = ListingPriceConverter.listPriceEntityToListPriceDTO.convert(null);
        assertNull(listingPriceDTO);
    }
    @Test
    public void entityTODTO_EmptyListPriceConverter_ShouldReturnEmpty(){
        ListingPriceEntity listingPriceEntity = new ListingPriceEntity();
        ListingPriceDTO listingPriceDTO = ListingPriceConverter.listPriceEntityToListPriceDTO.convert(listingPriceEntity);
        checkNullAllFields_ListPriceDTO(listingPriceDTO);
    }
    @Test
    public void entityTODTO_ListPriceConverter_ShouldReturnCompleteObject(){
        ListingPriceEntity listingPriceEntity = UtilsTest.createListPriceEntity();
        ListingPriceDTO listingPriceDTO = ListingPriceConverter.listPriceEntityToListPriceDTO.convert(listingPriceEntity);
        checkAllFields_ListPrice(listingPriceEntity, listingPriceDTO);
    }





    private void checkNullAllFields_ListPriceEntity(ListingPriceEntity listingPrice) {
        assertNull(listingPrice.getLowAmount());
        assertNull(listingPrice.getHighAmount());
        assertNull(listingPrice.getLowAmountType());
        assertNull(listingPrice.getHighAmountType());
        assertNull(listingPrice.getLowAmountCurrencyCode());
        assertNull(listingPrice.getHighAmountCurrencyCode());
        assertNull(listingPrice.getUnits());
    }
    private void checkNullAllFields_ListPriceDTO(ListingPriceDTO listingPriceDTO) {
        assertNull(listingPriceDTO.getLowAmount());
        assertNull(listingPriceDTO.getHighAmount());
        assertNull(listingPriceDTO.getLowAmountType());
        assertNull(listingPriceDTO.getHighAmountType());
        assertNull(listingPriceDTO.getLowAmountCurrencyCode());
        assertNull(listingPriceDTO.getHighAmountCurrencyCode());
        assertNull(listingPriceDTO.getUnits());
    }
    public static void checkAllFields_ListPrice(ListingPriceEntity listingPriceEntity, ListingPriceDTO listingPriceDTO) {
        assertEquals(listingPriceEntity.getLowAmount(), listingPriceDTO.getLowAmount());
        assertEquals(listingPriceEntity.getHighAmount(), listingPriceDTO.getHighAmount());
        assertEquals(listingPriceEntity.getLowAmountType(), listingPriceDTO.getLowAmountType());
        assertEquals(listingPriceEntity.getHighAmountType(), listingPriceDTO.getHighAmountType());
        assertEquals(listingPriceEntity.getLowAmountCurrencyCode(), listingPriceDTO.getLowAmountCurrencyCode());
        assertEquals(listingPriceEntity.getHighAmountCurrencyCode(), listingPriceDTO.getHighAmountCurrencyCode());
    }


}
