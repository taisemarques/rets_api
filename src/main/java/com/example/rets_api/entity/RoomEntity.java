package com.example.rets_api.entity;

import lombok.*;

import static com.example.rets_api.resource.Enums.*;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "room")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomEntity {

    @Id
    @GeneratedValue
    @Column(name="room_id")
    private Long roomId;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Enumerated(EnumType.STRING)
    private Indicator indicator;

    private String dimensions;

    private float length;

    @Enumerated(EnumType.STRING)
    private LengthWidthUnit lengthUnit;

    private float width;

    @Enumerated(EnumType.STRING)
    private LengthWidthUnit widthUnit;

    private float area;

    @Enumerated(EnumType.STRING)
    private AreaUnit areaUnit;

    @Enumerated(EnumType.STRING)
    private AreaType areaType;

    @Enumerated(EnumType.STRING)
    private BathSize bathSize;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

    public Boolean isBedroom(){
        return ( (roomType.equals(RoomType.MAIN_FLOOR_BEDROOM) || roomType.equals(RoomType.MASTER_BEDROOM) )
                && indicator.equals(Indicator.YES));
    }

    public Boolean isBathroom(){
        return ( (roomType.equals(RoomType.MAIN_FLOOR_BATHROOM) || roomType.equals(RoomType.MASTER_BEDROOM) )
                && indicator.equals(Indicator.YES));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomEntity)) return false;
        RoomEntity that = (RoomEntity) o;
        return Float.compare(that.getLength(), getLength()) == 0 && Float.compare(that.getWidth(), getWidth()) == 0 && Float.compare(that.getArea(), getArea()) == 0 && getRoomType() == that.getRoomType() && getIndicator() == that.getIndicator() && Objects.equals(getDimensions(), that.getDimensions()) && getLengthUnit() == that.getLengthUnit() && getWidthUnit() == that.getWidthUnit() && getAreaUnit() == that.getAreaUnit() && getAreaType() == that.getAreaType() && getBathSize() == that.getBathSize();
    }
}
