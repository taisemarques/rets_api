package com.example.rets_api.converter;

import com.example.rets_api.dto.CommunityDTO;
import com.example.rets_api.entity.CommunityEntity;
import com.example.rets_api.repository.UtilsTest;
import com.example.rets_api.resource.Enums.CommunityType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CommunityConverterTest {
    //DTO To Entity

    @Test
    public void dtoTOEntity_NullCommunityConverter_ShouldReturnNull(){
        CommunityEntity communityEntity = CommunityConverter.communityDTOToCommunityEntity.convert(null);
        assertNull(communityEntity);
    }

    @Test
    public void dtoTOEntity_EmptyCommunityConverter_ShouldReturnEmpty(){
        CommunityDTO communityDTO = CommunityDTO.builder().build();
        CommunityEntity communityEntity = CommunityConverter.communityDTOToCommunityEntity.convert(communityDTO);
        checkNullAllFields_CommunityEntity(communityEntity);
    }

    @Test
    public void dtoTOEntity_CommunityConverter_ShouldReturnCompleteObject(){
        CommunityDTO communityDTO = UtilsTest.createCommunityDTO(CommunityType.COMMUNITY_PARK);
        CommunityEntity communityEntity = CommunityConverter.communityDTOToCommunityEntity.convert(communityDTO);
        checkAllFields_Community(communityEntity, communityDTO);
    }

    //Entity To DTO

    @Test
    public void entityToDTO_NullCommunityConverter_ShouldReturnNull(){
        CommunityDTO communityDTO = CommunityConverter.communityEntityToCommunityDTO.convert(null);
        assertNull(communityDTO);
    }

    @Test
    public void entityToDTO_EmptyCommunityConverter_ShouldReturnEmpty(){
        CommunityEntity communityEntity = new CommunityEntity();
        CommunityDTO communityDTO = CommunityConverter.communityEntityToCommunityDTO.convert(communityEntity);
       checkNullAllFields_CommunityDTO(communityDTO);
    }

    @Test
    public void entityToDTO_CommunityConverter_ShouldReturnCompleteObject(){
        CommunityEntity communityEntity = UtilsTest.createCommunityEntity(CommunityType.COMMUNITY_PARK);
        CommunityDTO communityDTO = CommunityConverter.communityEntityToCommunityDTO.convert(communityEntity);
        checkAllFields_Community(communityEntity, communityDTO);
    }

    private static void checkNullAllFields_CommunityEntity(CommunityEntity communityEntity){
        assertNull(communityEntity.getType());
        assertNull(communityEntity.getIndicator());
        assertNull(communityEntity.getIndicator());
    }

    private static void checkNullAllFields_CommunityDTO(CommunityDTO communityDTO){
       assertNull(communityDTO.getType());
        assertNull(communityDTO.getIndicator());
        assertNull(communityDTO.getName());
    }

    public static void checkAllFields_Community(CommunityEntity roomEntity, CommunityDTO communityDTO) {
        assertEquals(roomEntity.getType(), communityDTO.getType());
        assertEquals(roomEntity.getIndicator(), communityDTO.getIndicator());
        assertEquals(roomEntity.getName(), communityDTO.getName());
    }

}
