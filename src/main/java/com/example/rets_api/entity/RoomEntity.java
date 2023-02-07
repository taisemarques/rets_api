package com.example.rets_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RoomEntity {

    public enum RoomType {
        BEDROOM,
        MASTER_BEDROOM,
        LIVING_ROOM,
        KITCHEN,
        BATHROOM,
        OFFICE
    }

    @Id
    @GeneratedValue
    @Column(name="room_id")
    private Long roomId;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private float width;
    private float length;
    private float area;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;


    @Override
    public String toString() {
        return "RoomEntity{" +
                "roomType=" + roomType +
                ", width=" + width +
                ", length=" + length +
                ", area=" + area +
                '}';
    }
}
