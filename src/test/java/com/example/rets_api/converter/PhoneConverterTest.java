package com.example.rets_api.converter;

import com.example.rets_api.dto.PhoneDTO;
import com.example.rets_api.entity.PhoneEntity;
import com.example.rets_api.repository.UtilsTest;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PhoneConverterTest {

    // DTO to Entity

    @Test
    public void dtoTOEntity_NullPhoneConverter_ShouldReturnNull(){
        PhoneEntity phoneEntity = PhoneConverter.phoneDTOPhoneEntityConverter.convert(null);
        assertNull(phoneEntity);
    }
    @Test
    public void dtoTOEntity_EmptyPhoneConverter_ShouldReturnEmpty(){
        PhoneDTO phoneDTO = new PhoneDTO();
        PhoneEntity phoneEntity = PhoneConverter.phoneDTOPhoneEntityConverter.convert(phoneDTO);
        checkNullAllFields_PhoneEntity(phoneEntity);
    }
    @Test
    public void dtoTOEntity_PhoneConverter_ShouldReturnCompleteObject(){
        PhoneDTO phoneDTO = UtilsTest.createPhoneDTO("5140001111", "5140002222");
        PhoneEntity phoneEntity = PhoneConverter.phoneDTOPhoneEntityConverter.convert(phoneDTO);
        checkAllFields_Phone(phoneEntity, phoneDTO);
    }

    // Entity TO DTO

    @Test
    public void EntityTODTO_NullPhoneConverter_ShouldReturnNull(){
        PhoneDTO phoneDTO = PhoneConverter.phoneEntityPhoneDTOConverter.convert(null);
        assertNull(phoneDTO);
    }
    @Test
    public void EntityTODTO_EmptyPhoneConverter_ShouldReturnEmpty(){
        PhoneEntity phoneEntity = new PhoneEntity();
        PhoneDTO phoneDTO = PhoneConverter.phoneEntityPhoneDTOConverter.convert(phoneEntity);
        checkNullAllFields_PhoneDTO(phoneDTO);
    }
    @Test
    public void EntityTODTO_PhoneConverter_ShouldReturnCompleteObject(){
        PhoneEntity phoneEntity = UtilsTest.createPhoneEntity("5140001111", "5140002222");
        PhoneDTO phoneDTO = PhoneConverter.phoneEntityPhoneDTOConverter.convert(phoneEntity);
        checkAllFields_Phone(phoneEntity, phoneDTO);
    }

    // Check methods

    private void checkNullAllFields_PhoneEntity(PhoneEntity phoneEntity) {
        assertNull(phoneEntity.getPrimaryPhone());
        assertNull(phoneEntity.getAlternatePhone());
    }
    private void checkAllFields_Phone(PhoneEntity phoneEntity, PhoneDTO phoneDTO) {
        assertEquals(phoneEntity.getPrimaryPhone(), phoneDTO.getPrimaryPhone());
        assertEquals(phoneEntity.getAlternatePhone(), phoneDTO.getAlternatePhone());
    }
    private void checkNullAllFields_PhoneDTO(PhoneDTO phoneDTO) {
        assertNull(phoneDTO.getPrimaryPhone());
        assertNull(phoneDTO.getAlternatePhone());
    }
}
