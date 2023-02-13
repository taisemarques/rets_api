package com.example.rets_api.converter;

import com.example.rets_api.dto.LotDataDTO;
import com.example.rets_api.entity.LotDataEntity;
import com.example.rets_api.repository.UtilsTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LotDataConverterTest {


    // DTO To Entity

    @Test
    public void dtoTOEntity_NullLotDataConverter_ShouldReturnNull(){
        LotDataEntity lotDataEntity = LotDataConverter.lotDataDTOToLotDataEntity.convert(null);
        assertNull(lotDataEntity);
    }

    @Test
    public void dtoTOEntity_EmptyLotDataConverter_ShouldReturnEmpty(){
        LotDataDTO lotDataDTO = LotDataDTO.builder().build();
        LotDataEntity lotDataEntity = LotDataConverter.lotDataDTOToLotDataEntity.convert(lotDataDTO);
        checkNullAllFields_LotDataEntity(lotDataEntity);
    }

    @Test
    public void dtoTOEntity_LotDataConverter_ShouldReturnCompleteObject(){
        LotDataDTO lotDataDTO = UtilsTest.createLotDataDTO();
        LotDataEntity lotDataEntity = LotDataConverter.lotDataDTOToLotDataEntity.convert(lotDataDTO);
        checkAllFields_LotData(lotDataEntity, lotDataDTO);
    }

    // Entity To DTO
    @Test
    public void entityToDTO_NullLotDataConverter_ShouldReturnNull(){
        LotDataDTO lotDataDTO = LotDataConverter.lotDataEntityToLotDataDTO.convert(null);
        assertNull(lotDataDTO);
    }

    @Test
    public void entityToDTO_EmptyLotDataConverter_ShouldReturnEmpty(){
        LotDataEntity lotDataEntity = new LotDataEntity();
        LotDataDTO lotDataDTO = LotDataConverter.lotDataEntityToLotDataDTO.convert(lotDataEntity);
        checkNullAllFields_LotDataDTO(lotDataDTO);
    }

    @Test
    public void entityToDTO_LotDataConverter_ShouldReturnCompleteObject() {
        LotDataEntity lotDataEntity = UtilsTest.createLotDataEntity();
        LotDataDTO lotDataDTO = LotDataConverter.lotDataEntityToLotDataDTO.convert(lotDataEntity);
        checkAllFields_LotData(lotDataEntity, lotDataDTO);
    }




    private void checkNullAllFields_LotDataEntity(LotDataEntity lotDataEntity){
        assertNull(lotDataEntity.getCornerLot());
        assertNull(lotDataEntity.getCornerLotIndicator());
        assertNull(lotDataEntity.getGolfCourseLot());
        assertNull(lotDataEntity.getGolfCourseLotIndicator());
        assertNull(lotDataEntity.getCuldeSac());
        assertNull(lotDataEntity.getCuldeSacIndicator());
    }

    private void checkNullAllFields_LotDataDTO(LotDataDTO lotDataDTO){
        assertNull(lotDataDTO.getCornerLot());
        assertNull(lotDataDTO.getCornerLotIndicator());
        assertNull(lotDataDTO.getGolfCourseLot());
        assertNull(lotDataDTO.getGolfCourseLotIndicator());
        assertNull(lotDataDTO.getCuldeSac());
        assertNull(lotDataDTO.getCuldeSacIndicator());
    }

    private void checkAllFields_LotData(LotDataEntity lotDataEntity, LotDataDTO lotDataDTO){
        assertEquals(lotDataEntity.getCornerLot(), lotDataDTO.getCornerLot());
        assertEquals(lotDataEntity.getCornerLotIndicator(), lotDataDTO.getCornerLotIndicator());
        assertEquals(lotDataEntity.getGolfCourseLot(), lotDataDTO.getGolfCourseLot());
        assertEquals(lotDataEntity.getGolfCourseLotIndicator(), lotDataDTO.getGolfCourseLotIndicator());
        assertEquals(lotDataEntity.getCuldeSac(), lotDataDTO.getCuldeSac());
        assertEquals(lotDataEntity.getCuldeSacIndicator(), lotDataDTO.getCuldeSacIndicator());
    }
}
