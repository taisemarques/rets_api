package com.example.rets_api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class PropertyEntity {

    @Id
    @GeneratedValue
    @Column(name="property_id")

    private Long propertyId;

    private String description;

    private Long price;

    @Transient
    private Map<RoomEntity.RoomType, Integer> roomQuantityMap = new HashMap<>();

    @OneToOne(mappedBy="property", cascade = CascadeType.ALL)
    private SchoolEntity schoolEntity;

    @OneToMany(mappedBy= "property", cascade = CascadeType.ALL)
    private List<RoomEntity> roomList;


    @PostLoad
     void populateRoomQuantityMap(){

        for(RoomEntity room : roomList){
            int count = 1;
            RoomEntity.RoomType key = room.getRoomType();
            if(roomQuantityMap.keySet().contains(key)){
                count = roomQuantityMap.get(key)+1;
            }
            roomQuantityMap.put(key, count);
        }

    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", description =" + description +
                ", price =" + price +
                ", school =" + schoolEntity + "}" ;
    }

}
