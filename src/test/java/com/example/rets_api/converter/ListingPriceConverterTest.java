package com.example.rets_api.converter;

import com.example.rets_api.dto.ListingPriceDTO;
import com.example.rets_api.entity.ListingPriceEntity;
import com.example.rets_api.utils.DtoUtilsTest;
import com.example.rets_api.utils.EntityUtilsTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ListingPriceConverterTest {

    // DTO To Entity

    @Test
    public void dtoTOEntity_NullListingPriceConverter_ShouldReturnNull(){
        ListingPriceEntity listingPriceEntity = ListingPriceConverter.listingPriceDTOToListingPriceEntity.convert(null);
        assertNull(listingPriceEntity);
    }
    @Test
    public void dtoTOEntity_EmptyListingPriceConverter_ShouldReturnEmpty(){
        ListingPriceDTO listingPriceDTO = ListingPriceDTO.builder().build();
        ListingPriceEntity listingPrice = ListingPriceConverter.listingPriceDTOToListingPriceEntity.convert(listingPriceDTO);
        checkNullAllFields_ListingPriceEntity(listingPrice);
    }



    @Test
    public void dtoTOEntity_ListingPriceConverter_ShouldReturnCompleteObject(){
        ListingPriceDTO listingPriceDTO = DtoUtilsTest.createListingPriceDTO();
        ListingPriceEntity listingPriceEntity = ListingPriceConverter.listingPriceDTOToListingPriceEntity.convert(listingPriceDTO);
        checkAllFields_ListingPrice(listingPriceEntity, listingPriceDTO);
    }



    // Entity To DTO
    @Test
    public void entityTODTO_NullListingPriceConverter_ShouldReturnNull(){
        ListingPriceDTO listingPriceDTO = ListingPriceConverter.listingPriceEntityToListingPriceDTO.convert(null);
        assertNull(listingPriceDTO);
    }
    @Test
    public void entityTODTO_EmptyListingPriceConverter_ShouldReturnEmpty(){
        ListingPriceEntity listingPriceEntity = new ListingPriceEntity();
        ListingPriceDTO listingPriceDTO = ListingPriceConverter.listingPriceEntityToListingPriceDTO.convert(listingPriceEntity);
        checkNullAllFields_ListingPriceDTO(listingPriceDTO);
    }
    @Test
    public void entityTODTO_ListingPriceConverter_ShouldReturnCompleteObject(){
        ListingPriceEntity listingPriceEntity = EntityUtilsTest.createListingPriceEntity();
        ListingPriceDTO listingPriceDTO = ListingPriceConverter.listingPriceEntityToListingPriceDTO.convert(listingPriceEntity);
        checkAllFields_ListingPrice(listingPriceEntity, listingPriceDTO);
    }





    private void checkNullAllFields_ListingPriceEntity(ListingPriceEntity listingPrice) {
        assertNull(listingPrice.getLowAmount());
        assertNull(listingPrice.getHighAmount());
        assertNull(listingPrice.getLowAmountType());
        assertNull(listingPrice.getHighAmountType());
        assertNull(listingPrice.getLowAmountCurrencyCode());
        assertNull(listingPrice.getHighAmountCurrencyCode());
        assertNull(listingPrice.getUnits());
    }
    private void checkNullAllFields_ListingPriceDTO(ListingPriceDTO listingPriceDTO) {
        assertNull(listingPriceDTO.getLowAmount());
        assertNull(listingPriceDTO.getHighAmount());
        assertNull(listingPriceDTO.getLowAmountType());
        assertNull(listingPriceDTO.getHighAmountType());
        assertNull(listingPriceDTO.getLowAmountCurrencyCode());
        assertNull(listingPriceDTO.getHighAmountCurrencyCode());
        assertNull(listingPriceDTO.getUnits());
    }
    public static void checkAllFields_ListingPrice(ListingPriceEntity listingPriceEntity, ListingPriceDTO listingPriceDTO) {
        assertEquals(listingPriceEntity.getLowAmount(), listingPriceDTO.getLowAmount());
        assertEquals(listingPriceEntity.getHighAmount(), listingPriceDTO.getHighAmount());
        assertEquals(listingPriceEntity.getLowAmountType(), listingPriceDTO.getLowAmountType());
        assertEquals(listingPriceEntity.getHighAmountType(), listingPriceDTO.getHighAmountType());
        assertEquals(listingPriceEntity.getLowAmountCurrencyCode(), listingPriceDTO.getLowAmountCurrencyCode());
        assertEquals(listingPriceEntity.getHighAmountCurrencyCode(), listingPriceDTO.getHighAmountCurrencyCode());
        assertEquals(listingPriceEntity.getUnits(), listingPriceDTO.getUnits());
    }


}
