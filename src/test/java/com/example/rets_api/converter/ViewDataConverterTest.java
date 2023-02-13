package com.example.rets_api.converter;

import com.example.rets_api.dto.ViewDataDTO;
import com.example.rets_api.entity.ViewDataEntity;
import com.example.rets_api.repository.UtilsTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ViewDataConverterTest {

    @Test
    public void dtoTOEntity_NullViewDataConverter_ShouldReturnNull(){
        ViewDataEntity viewDataEntity = ViewDataConverter.viewDataDTOToViewDataEntity.convert(null);
        assertNull(viewDataEntity);
    }

    @Test
    public void dtoTOEntity_EmptyViewDataConverter_ShouldReturnEmpty(){
        ViewDataDTO viewDataDTO = ViewDataDTO.builder().build();
        ViewDataEntity viewDataEntity = ViewDataConverter.viewDataDTOToViewDataEntity.convert(viewDataDTO);
        checkNullAllFields_ViewDataEntity(viewDataEntity);
    }

    @Test
    public void dtoTOEntity_ViewDataConverter_ShouldReturnCompleteObject(){
        ViewDataDTO viewDataDTO = UtilsTest.createViewDataDTO();
        ViewDataEntity viewDataEntity = ViewDataConverter.viewDataDTOToViewDataEntity.convert(viewDataDTO);
        checkAllFields_ViewData(viewDataEntity, viewDataDTO);
    }

    //Entity To DTO

    @Test
    public void entityToDTO_NullViewDataConverter_ShouldReturnNull(){
        ViewDataDTO viewDataDTO = ViewDataConverter.viewDataEntityToViewDataDTO.convert(null);
        assertNull(viewDataDTO);
    }

    @Test
    public void entityToDTO_EmptyViewDataConverter_ShouldReturnEmpty(){
        ViewDataEntity viewDataEntity = new ViewDataEntity();
        ViewDataDTO viewDataDTO = ViewDataConverter.viewDataEntityToViewDataDTO.convert(viewDataEntity);
        checkNullAllFields_ViewDataDTO(viewDataDTO);
    }

    @Test
    public void entityToDTO_ViewDataConverter_ShouldReturnCompleteObject(){
        ViewDataEntity viewDataEntity = UtilsTest.createViewDataEntity();
        ViewDataDTO viewDataDTO = ViewDataConverter.viewDataEntityToViewDataDTO.convert(viewDataEntity);
        checkAllFields_ViewData(viewDataEntity, viewDataDTO);
    }

    private void checkNullAllFields_ViewDataEntity(ViewDataEntity viewData){
        assertNull(viewData.getCityLight());
        assertNull(viewData.getCityLightIndicator());
        assertNull(viewData.getMountain());
        assertNull(viewData.getMountainIndicator());
        assertNull(viewData.getRiver());
        assertNull(viewData.getRiverIndicator());
        assertNull(viewData.getLake());
        assertNull(viewData.getLakeIndicator());
        assertNull(viewData.getGolfCourse());
        assertNull(viewData.getGolfCourseIndicator());
        assertNull(viewData.getWater());
        assertNull(viewData.getWaterIndicator());

    }

    private void checkNullAllFields_ViewDataDTO(ViewDataDTO viewDataDTO){
        assertNull(viewDataDTO.getCityLight());
        assertNull(viewDataDTO.getCityLightIndicator());
        assertNull(viewDataDTO.getMountain());
        assertNull(viewDataDTO.getMountainIndicator());
        assertNull(viewDataDTO.getRiver());
        assertNull(viewDataDTO.getRiverIndicator());
        assertNull(viewDataDTO.getLake());
        assertNull(viewDataDTO.getLakeIndicator());
        assertNull(viewDataDTO.getGolfCourse());
        assertNull(viewDataDTO.getGolfCourseIndicator());
        assertNull(viewDataDTO.getWater());
        assertNull(viewDataDTO.getWaterIndicator());
    }

    public static void checkAllFields_ViewData(ViewDataEntity viewDataEntity, ViewDataDTO viewDataDTO) {
        assertEquals(viewDataEntity.getCityLight(), viewDataDTO.getCityLight());
        assertEquals(viewDataEntity.getCityLightIndicator(), viewDataDTO.getCityLightIndicator());
        assertEquals(viewDataEntity.getMountain(), viewDataDTO.getMountain());
        assertEquals(viewDataEntity.getMountainIndicator(), viewDataDTO.getMountainIndicator());
        assertEquals(viewDataEntity.getRiver(), viewDataDTO.getRiver());
        assertEquals(viewDataEntity.getRiverIndicator(), viewDataDTO.getRiverIndicator());
        assertEquals(viewDataEntity.getLake(), viewDataDTO.getLake());
        assertEquals(viewDataEntity.getLakeIndicator(), viewDataDTO.getLakeIndicator());
        assertEquals(viewDataEntity.getGolfCourse(), viewDataDTO.getGolfCourse());
        assertEquals(viewDataEntity.getGolfCourseIndicator(), viewDataDTO.getGolfCourseIndicator());
        assertEquals(viewDataEntity.getWater(), viewDataDTO.getWater());
        assertEquals(viewDataEntity.getWaterIndicator(), viewDataDTO.getWaterIndicator());
    }
}
