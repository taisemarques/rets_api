package com.example.rets_api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "property_table")
@Data
public class PropertyEntity {

    @Id
    @GeneratedValue
    @Column(name="property_id")

    private Long propertyId;

    private String description;

    private Long price;

    private int bedroomsQty;

    private int bathroomsQty;


    @ManyToMany(mappedBy= "propertyList", cascade = CascadeType.ALL)
    private List<SchoolEntity> schoolList;

    @OneToMany(mappedBy= "property", cascade = CascadeType.ALL)
    private List<RoomEntity> roomList;



    @PrePersist
     void updateRoomQuantity(){
        bedroomsQty = 0;
        bathroomsQty = 0;

        for(RoomEntity room: roomList){
            if(room.getRoomType().equals(RoomEntity.RoomType.BEDROOM)){
                bedroomsQty++;
            }
            if(room.getRoomType().equals(RoomEntity.RoomType.BATHROOM)){
                bathroomsQty++;
            }
        }
    }

    @Override
    public String toString() {
        return "PropertyEntity{" +
                "propertyId=" + propertyId +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", bedroomsQty=" + bedroomsQty +
                ", bathroomsQty=" + bathroomsQty +
                ", schoolList=" + schoolList +
                ", roomList=" + roomList +
                '}';
    }
}
