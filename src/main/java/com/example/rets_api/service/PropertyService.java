package com.example.rets_api.service;

import com.example.rets_api.converter.PropertyConverter;
import com.example.rets_api.converter.RoomConverter;
import com.example.rets_api.dto.PropertyDTO;
import com.example.rets_api.dto.PropertyPatchDTO;
import com.example.rets_api.dto.RoomDTO;
import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.entity.RoomEntity;
import com.example.rets_api.repository.RoomRepositoryJPA;
import com.example.rets_api.resource.PropertyFilter;
import com.example.rets_api.repository.PropertyRepositoryJPA;
import com.example.rets_api.repository.PropertyRepositoryQuerydsl;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import static com.example.rets_api.resource.PatchUtils.updatePropertyFieldsWhenChanged;

@Service
public class PropertyService {

    private PropertyRepositoryJPA propertyRepositoryJPA;
    private RoomRepositoryJPA roomRepositoryJPA;
    private PropertyRepositoryQuerydsl propertyRepositoryQuerydsl;

    public PropertyService(PropertyRepositoryJPA propertyRepositoryJPA, RoomRepositoryJPA roomRepositoryJPA,
                           PropertyRepositoryQuerydsl propertyRepositoryQuerydsl){
        this.propertyRepositoryJPA = propertyRepositoryJPA;
        this.roomRepositoryJPA = roomRepositoryJPA;
        this.propertyRepositoryQuerydsl = propertyRepositoryQuerydsl;
    }

    public Long createProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = PropertyConverter.propertyDTOToPropertyEntity.convert(propertyDTO);
        PropertyEntity propertyResponse = propertyRepositoryJPA.saveAndFlush(propertyEntity);
        return propertyResponse.getPropertyId();
    }

    public PropertyDTO getPropertyById(Long propertyId) {
        Optional<PropertyEntity> propertyResponse = propertyRepositoryJPA.findById(propertyId);
        PropertyDTO response = propertyResponse.isPresent()?
                PropertyConverter.propertyEntityToPropertyDTO.convert(propertyResponse.get()):
                null;
        return response;
    }

    public List<PropertyDTO> getPropertiesByParams(PropertyFilter propertyFilter){
        List<PropertyEntity> propertyEntities = propertyRepositoryQuerydsl.fetchAll(propertyFilter);
        List<PropertyDTO> propertiesDTO = PropertyConverter.listPropertiesEntityToListPropertiesDTO(propertyEntities);
        return propertiesDTO;
    }

    public PropertyDTO deletePropertyById(Long propertyId) {
        Optional<PropertyEntity> propertyResponse = propertyRepositoryJPA.findById(propertyId);
        if(!propertyResponse.isPresent()) return null;
        propertyRepositoryJPA.delete(propertyResponse.get());
        return PropertyConverter.propertyEntityToPropertyDTO.convert(propertyResponse.get());
    }

    public <T> T patchProperty(Long propertyId, T patch){
        Optional<PropertyEntity> propertyToPatch = propertyRepositoryJPA.findById(propertyId);
        if(!propertyToPatch.isPresent()){ return null;}
        switch (patch.getClass().getSimpleName()) {
            case "PropertyPatchDTO":
                return (T) patchPropertyBasicFields(propertyToPatch.get(), (PropertyPatchDTO)patch);
            case "List<RoomDTO>":
                return (T) patchRoomList(propertyToPatch.get(), (List<RoomDTO>)patch);
            default:
                return null;
        }
    }

    private PropertyPatchDTO patchPropertyBasicFields(PropertyEntity propertyToPatch, PropertyPatchDTO propertyPatchDTO){
        updatePropertyFieldsWhenChanged(propertyToPatch, propertyPatchDTO);
        PropertyEntity propertyResponse = propertyRepositoryJPA.saveAndFlush(propertyToPatch);
        return PropertyConverter.propertyEntityToPropertyPatchDTO.convert(propertyResponse);
    }

    private List<RoomDTO> patchRoomList(PropertyEntity propertyToPatch, List<RoomDTO> roomListToPatch) {

        return roomListToPatch;
    }

    public RoomDTO patchRoom(Long propertyId, Long roomId, RoomDTO patch) {
        Optional<RoomEntity> roomEntity = roomRepositoryJPA.findRoomEntityByRoomIdAndPropertyPropertyId(roomId, propertyId);
        if(!roomEntity.isPresent()) {return null;}
        return RoomConverter.roomEntityToRoomDTO.convert(roomEntity.get());
    }

    private RoomEntity getRoomById(List<RoomEntity> roomList, Long id){
        for (RoomEntity room: roomList) {
            if(room.getRoomId().equals(id)){
                return room;
            }
        }
        return null;
    }
}
