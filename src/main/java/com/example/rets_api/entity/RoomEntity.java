package com.example.rets_api.entity;

import lombok.*;

import static com.example.rets_api.entity.Enums.*;

import javax.persistence.*;

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
    private LenghWidthUnit lenghUnit;

    private float width;

    @Enumerated(EnumType.STRING)
    private LenghWidthUnit widthUnit;

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

}
