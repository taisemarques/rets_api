package com.example.rets_api.converter;

import com.example.rets_api.dto.ContactInformationDTO;
import com.example.rets_api.entity.ContactInformationEntity;
import com.example.rets_api.utils.DtoUtilsTest;
import com.example.rets_api.utils.EntityUtilsTest;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ContactInformationConverterTest {

    // DTO to Entity

    @Test
    public void dtoTOEntity_NullContactInformationConverter_ShouldReturnNull(){
        ContactInformationEntity contactInformationEntity = ContactInformationConverter.contactInformationDTOContactInformationEntity.convert(null);
        assertNull(contactInformationEntity);
    }
    @Test
    public void dtoTOEntity_EmptyContactInformationConverter_ShouldReturnEmpty(){
        ContactInformationDTO contactInformationDTO = new ContactInformationDTO();
        ContactInformationEntity contactInformationEntity = ContactInformationConverter.contactInformationDTOContactInformationEntity.convert(contactInformationDTO);
        checkNullAllFields_ContactInformationEntity(contactInformationEntity);
    }
    @Test
    public void dtoTOEntity_ContactInformationConverter_ShouldReturnCompleteObject(){
        ContactInformationDTO contactInformationDTO = DtoUtilsTest.createContactInformationDTO();
        ContactInformationEntity contactInformationEntity = ContactInformationConverter.contactInformationDTOContactInformationEntity.convert(contactInformationDTO);
        checkAllFields_ContactInformation(contactInformationEntity, contactInformationDTO);
    }

    // Entity TO DTO

    @Test
    public void EntityTODTO_NullContactInformationConverter_ShouldReturnNull(){
        ContactInformationDTO contactInformationDTO = ContactInformationConverter.contactInformationEntityContactInformationDTO.convert(null);
        assertNull(contactInformationDTO);
    }
    @Test
    public void EntityTODTO_EmptyContactInformationConverter_ShouldReturnEmpty(){
        ContactInformationEntity ContactInformationEntity = new ContactInformationEntity();
        ContactInformationDTO contactInformationDTO = ContactInformationConverter.contactInformationEntityContactInformationDTO.convert(ContactInformationEntity);
        checkNullAllFields_ContactInformationDTO(contactInformationDTO);
    }
    @Test
    public void EntityTODTO_ContactInformationConverter_ShouldReturnCompleteObject(){
        ContactInformationEntity contactInformationEntity = EntityUtilsTest.createContactInformationEntity();
        ContactInformationDTO contactInformationDTO  = ContactInformationConverter.contactInformationEntityContactInformationDTO.convert(contactInformationEntity);
        checkAllFields_ContactInformation(contactInformationEntity, contactInformationDTO);
    }


    // Check methods
    private void checkNullAllFields_ContactInformationEntity(ContactInformationEntity contactInformationEntity) {
        assertNull(contactInformationEntity.getAgentPhone());
        assertNull(contactInformationEntity.getListAgentPhone());
        assertNull(contactInformationEntity.getSalesAgentPhone());
        assertNull(contactInformationEntity.getOfficePhone());
        assertNull(contactInformationEntity.getListOfficePhone());
        assertNull(contactInformationEntity.getSalesOfficePhone());
    }
    public static void checkAllFields_ContactInformation(ContactInformationEntity contactInformationEntity, ContactInformationDTO contactInformationDTO){
        assertEquals(contactInformationEntity.getAgentPhone().getPrimaryPhone(), contactInformationDTO.getAgentPhone().getPrimaryPhone());
        assertEquals(contactInformationEntity.getAgentPhone().getAlternatePhone(), contactInformationDTO.getAgentPhone().getAlternatePhone());
        assertEquals(contactInformationEntity.getListAgentPhone().getPrimaryPhone(), contactInformationDTO.getListAgentPhone().getPrimaryPhone());
        assertEquals(contactInformationEntity.getListAgentPhone().getAlternatePhone(), contactInformationDTO.getListAgentPhone().getAlternatePhone());
        assertEquals(contactInformationEntity.getSalesAgentPhone().getPrimaryPhone(), contactInformationDTO.getSalesAgentPhone().getPrimaryPhone());
        assertEquals(contactInformationEntity.getSalesAgentPhone().getAlternatePhone(), contactInformationDTO.getSalesAgentPhone().getAlternatePhone());
        assertEquals(contactInformationEntity.getOfficePhone().getPrimaryPhone(), contactInformationDTO.getOfficePhone().getPrimaryPhone());
        assertEquals(contactInformationEntity.getOfficePhone().getAlternatePhone(), contactInformationDTO.getOfficePhone().getAlternatePhone());
        assertEquals(contactInformationEntity.getListOfficePhone().getPrimaryPhone(), contactInformationDTO.getListOfficePhone().getPrimaryPhone());
        assertEquals(contactInformationEntity.getListOfficePhone().getAlternatePhone(), contactInformationDTO.getListOfficePhone().getAlternatePhone());
        assertEquals(contactInformationEntity.getSalesOfficePhone().getPrimaryPhone(), contactInformationDTO.getSalesOfficePhone().getPrimaryPhone());
        assertEquals(contactInformationEntity.getSalesOfficePhone().getAlternatePhone(), contactInformationDTO.getSalesOfficePhone().getAlternatePhone());
    }
    private void checkNullAllFields_ContactInformationDTO(ContactInformationDTO contactInformationDTO) {
        assertNull(contactInformationDTO.getAgentPhone());
        assertNull(contactInformationDTO.getListAgentPhone());
        assertNull(contactInformationDTO.getSalesAgentPhone());
        assertNull(contactInformationDTO.getOfficePhone());
        assertNull(contactInformationDTO.getListOfficePhone());
        assertNull(contactInformationDTO.getSalesOfficePhone());
    }

}
