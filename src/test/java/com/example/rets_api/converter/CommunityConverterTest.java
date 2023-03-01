package com.example.rets_api.converter;

import com.example.rets_api.dto.CommunityDTO;
import com.example.rets_api.entity.CommunityEntity;
import com.example.rets_api.utils.DtoUtilsTest;
import com.example.rets_api.utils.EntityUtilsTest;
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
        CommunityDTO communityDTO = DtoUtilsTest.createCommunityDTO();
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
        CommunityEntity communityEntity = EntityUtilsTest.createCommunityEntity();
        CommunityDTO communityDTO = CommunityConverter.communityEntityToCommunityDTO.convert(communityEntity);
        checkAllFields_Community(communityEntity, communityDTO);
    }

    private static void checkNullAllFields_CommunityEntity(CommunityEntity communityEntity){
        assertNull(communityEntity.getClubHouse());
        assertNull(communityEntity.getClubHouseIndicator());
        assertNull(communityEntity.getExerciseArea());
        assertNull(communityEntity.getExerciseAreaIndicator());
        assertNull(communityEntity.getGolf());
        assertNull(communityEntity.getGolfIndicator());
        assertNull(communityEntity.getTennis());
        assertNull(communityEntity.getTennisIndicator());
        assertNull(communityEntity.getRecreationalFacilities());
        assertNull(communityEntity.getRecreationalFacilitiesIndicator());
        assertNull(communityEntity.getSecurityFeatures());
        assertNull(communityEntity.getSecurityFeaturesIndicator());
        assertNull(communityEntity.getSeniorCommunity());
        assertNull(communityEntity.getSeniorCommunityIndicator());
        assertNull(communityEntity.getHotTub());
        assertNull(communityEntity.getHotTubIndicator());
        assertNull(communityEntity.getPool());
        assertNull(communityEntity.getPoolIndicator());
        assertNull(communityEntity.getBoatFacilities());
        assertNull(communityEntity.getBoatFacilitiesIndicator());
        assertNull(communityEntity.getHorseFacilities());
        assertNull(communityEntity.getHorseFacilitiesIndicator());
        assertNull(communityEntity.getCommunityPark());
        assertNull(communityEntity.getCommunityParkIndicator());
    }

    private static void checkNullAllFields_CommunityDTO(CommunityDTO communityDTO){
        assertNull(communityDTO.getClubHouse());
        assertNull(communityDTO.getClubHouseIndicator());
        assertNull(communityDTO.getExerciseArea());
        assertNull(communityDTO.getExerciseAreaIndicator());
        assertNull(communityDTO.getGolf());
        assertNull(communityDTO.getGolfIndicator());
        assertNull(communityDTO.getTennis());
        assertNull(communityDTO.getTennisIndicator());
        assertNull(communityDTO.getRecreationalFacilities());
        assertNull(communityDTO.getRecreationalFacilitiesIndicator());
        assertNull(communityDTO.getSecurityFeatures());
        assertNull(communityDTO.getSecurityFeaturesIndicator());
        assertNull(communityDTO.getSeniorCommunity());
        assertNull(communityDTO.getSeniorCommunityIndicator());
        assertNull(communityDTO.getHotTub());
        assertNull(communityDTO.getHotTubIndicator());
        assertNull(communityDTO.getPool());
        assertNull(communityDTO.getPoolIndicator());
        assertNull(communityDTO.getBoatFacilities());
        assertNull(communityDTO.getBoatFacilitiesIndicator());
        assertNull(communityDTO.getHorseFacilities());
        assertNull(communityDTO.getHorseFacilitiesIndicator());
        assertNull(communityDTO.getCommunityPark());
        assertNull(communityDTO.getCommunityParkIndicator());
    }

    public static void checkAllFields_Community(CommunityEntity communityEntity, CommunityDTO communityDTO) {
        assertEquals(communityEntity.getClubHouse(), communityDTO.getClubHouse());
        assertEquals(communityEntity.getClubHouseIndicator(), communityDTO.getClubHouseIndicator());
        assertEquals(communityEntity.getExerciseArea(), communityDTO.getExerciseArea());
        assertEquals(communityEntity.getExerciseAreaIndicator(), communityDTO.getExerciseAreaIndicator());
        assertEquals(communityEntity.getGolf(), communityDTO.getGolf());
        assertEquals(communityEntity.getGolfIndicator(), communityDTO.getGolfIndicator());
        assertEquals(communityEntity.getTennisIndicator(), communityDTO.getTennisIndicator());
        assertEquals(communityEntity.getTennis(), communityDTO.getTennis());
        assertEquals(communityEntity.getRecreationalFacilitiesIndicator(), communityDTO.getRecreationalFacilitiesIndicator());
        assertEquals(communityEntity.getRecreationalFacilities(), communityDTO.getRecreationalFacilities());
        assertEquals(communityEntity.getSecurityFeaturesIndicator(), communityDTO.getSecurityFeaturesIndicator());
        assertEquals(communityEntity.getSecurityFeatures(), communityDTO.getSecurityFeatures());
        assertEquals(communityEntity.getSeniorCommunityIndicator(), communityDTO.getSeniorCommunityIndicator());
        assertEquals(communityEntity.getSeniorCommunity(), communityDTO.getSeniorCommunity());
        assertEquals(communityEntity.getHotTub(), communityDTO.getHotTub());
        assertEquals(communityEntity.getPoolIndicator(), communityDTO.getPoolIndicator());
        assertEquals(communityEntity.getHotTubIndicator(), communityDTO.getHotTubIndicator());
        assertEquals(communityEntity.getPool(), communityDTO.getPool());
        assertEquals(communityEntity.getBoatFacilitiesIndicator(), communityDTO.getBoatFacilitiesIndicator());
        assertEquals(communityEntity.getBoatFacilities(), communityDTO.getBoatFacilities());
        assertEquals(communityEntity.getHorseFacilities(), communityDTO.getHorseFacilities());
        assertEquals(communityEntity.getHorseFacilitiesIndicator(), communityDTO.getHorseFacilitiesIndicator());
        assertEquals(communityEntity.getCommunityPark(), communityDTO.getCommunityPark());
        assertEquals(communityEntity.getCommunityParkIndicator(), communityDTO.getCommunityParkIndicator());
    }

}
