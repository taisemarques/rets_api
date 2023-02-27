package com.example.rets_api.converter;
import com.example.rets_api.dto.RoomDTO;
import com.example.rets_api.entity.RoomEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class RoomConverter {
    public static Converter<RoomDTO, RoomEntity> roomDTOToRoomEntity = in -> {
        if(isNull(in)) return null;
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomType(in.getType());
        roomEntity.setLength(in.getLength());
        roomEntity.setWidth(in.getWidth());
        roomEntity.setArea(in.getArea());
        roomEntity.setDimensions(in.getDimensions());
        roomEntity.setBathSize(in.getBathSize());
        roomEntity.setIndicator(in.getIndicator());
        roomEntity.setLengthUnit(in.getLengthUnit());
        roomEntity.setWidthUnit(in.getWidthUnit());
        roomEntity.setAreaUnit(in.getAreaUnit());
        roomEntity.setAreaType(in.getAreaType());
        return roomEntity;
    };

    public static Converter<RoomEntity, RoomDTO> roomEntityToRoomDTO = in -> {
        if (isNull(in)) return null;
        return RoomDTO.builder()
                .type(in.getRoomType())
                .width(in.getWidth())
                .length(in.getLength())
                .area(in.getArea())
                .indicator(in.getIndicator())
                .dimensions(in.getDimensions())
                .lengthUnit(in.getLengthUnit())
                .widthUnit(in.getWidthUnit())
                .areaType(in.getAreaType())
                .areaUnit(in.getAreaUnit())
                .bathSize(in.getBathSize())
                .build();
    };

    public static List<RoomDTO> listRoomEntityToListRoomDTO(List<RoomEntity> roomEntityList) {
        if (isNull(roomEntityList)) return null;
        return roomEntityList.stream()
                .map(roomDTO -> roomEntityToRoomDTO.convert(roomDTO))
                .collect(Collectors.toList());
    }

    public static List<RoomEntity> listRoomDTOToListRoomEntity(List<RoomDTO> roomDTOList) {
        if (isNull(roomDTOList)) return null;
        return roomDTOList.stream()
                .map(roomEntity -> roomDTOToRoomEntity.convert(roomEntity))
                .collect(Collectors.toList());
    }
}
