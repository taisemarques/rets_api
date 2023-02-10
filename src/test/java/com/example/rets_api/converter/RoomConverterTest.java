package com.example.rets_api.converter;

import com.example.rets_api.dto.RoomDTO;
import com.example.rets_api.entity.RoomEntity;
import com.example.rets_api.repository.UtilsTest;
import com.example.rets_api.resource.Enums.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomConverterTest {

    //DTO To Entity

    @Test
    public void dtoTOEntity_NullRoomConverter_ShouldReturnNull(){
        RoomEntity roomEntity = RoomConverter.roomDTOToRoomEntity.convert(null);
        assertNull(roomEntity);
    }

    @Test
    public void dtoTOEntity_EmptyRoomConverter_ShouldReturnEmpty(){
        RoomDTO roomDTO = RoomDTO.builder().build();
        RoomEntity roomEntity = RoomConverter.roomDTOToRoomEntity.convert(roomDTO);
        checkNullAllFields_RoomDataEntity(roomEntity);
    }

    @Test
    public void dtoTOEntity_RoomConverter_ShouldReturnCompleteObject(){
        RoomDTO roomDTO = UtilsTest.createRoomDTO(RoomType.MASTER_BEDROOM);
        RoomEntity roomEntity = RoomConverter.roomDTOToRoomEntity.convert(roomDTO);
        checkAllFields_Room(roomEntity, roomDTO);
    }

    //Entity To DTO

    @Test
    public void entityToDTO_NullRoomConverter_ShouldReturnNull(){
        RoomDTO roomDTO = RoomConverter.roomEntityToRoomDTO.convert(null);
        assertNull(roomDTO);
    }

    @Test
    public void entityToDTO_EmptyFinancialDataConverter_ShouldReturnEmpty(){
        RoomEntity roomEntity = new RoomEntity();
        RoomDTO roomDTO = RoomConverter.roomEntityToRoomDTO.convert(roomEntity);
        checkNullAllFields_RoomDTO(roomDTO);
    }

    @Test
    public void entityToDTO_FinancialDataConverter_ShouldReturnCompleteObject(){
        RoomEntity roomEntity = UtilsTest.createRoomEntity(RoomType.MASTER_BEDROOM);
        RoomDTO roomDTO = RoomConverter.roomEntityToRoomDTO.convert(roomEntity);
        checkAllFields_Room(roomEntity, roomDTO);
    }

    private void checkNullAllFields_RoomDataEntity(RoomEntity roomEntity){
        assertNull(roomEntity.getRoomType());
        assertNull(roomEntity.getIndicator());
        assertNull(roomEntity.getDimensions());
        assertTrue(roomEntity.getLength() == 0.0);
        assertNull(roomEntity.getLengthUnit());
        assertTrue(roomEntity.getWidth() == 0.0);
        assertNull(roomEntity.getWidthUnit());
        assertTrue(roomEntity.getArea() == 0.0);
        assertNull(roomEntity.getAreaUnit());
        assertNull(roomEntity.getAreaType());
        assertNull(roomEntity.getBathSize());
    }

    private void checkNullAllFields_RoomDTO(RoomDTO roomDTO){
        assertNull(roomDTO.getType());
        assertNull(roomDTO.getIndicator());
        assertNull(roomDTO.getDimensions());
        assertTrue(roomDTO.getLength() == 0.0);
        assertNull(roomDTO.getLengthUnit());
        assertTrue(roomDTO.getWidth() == 0.0);
        assertNull(roomDTO.getWidthUnit());
        assertTrue(roomDTO.getArea() == 0.0);
        assertNull(roomDTO.getAreaUnit());
        assertNull(roomDTO.getAreaType());
        assertNull(roomDTO.getBathSize());
    }

    private void checkAllFields_Room(RoomEntity roomEntity, RoomDTO roomDTO) {
        assertEquals(roomEntity.getRoomType(), roomDTO.getType());
        assertEquals(roomEntity.getIndicator(), roomDTO.getIndicator());
        assertEquals(roomEntity.getDimensions(), roomDTO.getDimensions());
        assertTrue(roomEntity.getLength() == roomDTO.getLength());
        assertEquals(roomEntity.getLengthUnit(), roomDTO.getLengthUnit());
        assertTrue(roomEntity.getWidth() == roomDTO.getWidth());
        assertEquals(roomEntity.getWidthUnit(), roomDTO.getWidthUnit());
        assertTrue(roomEntity.getArea() == roomDTO.getArea());
        assertEquals(roomEntity.getAreaUnit(), roomDTO.getAreaUnit());
        assertEquals(roomEntity.getAreaType(), roomDTO.getAreaType());
        assertEquals(roomEntity.getBathSize(), roomDTO.getBathSize());
    }

}
