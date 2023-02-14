package com.example.rets_api.entity;
import lombok.*;

import javax.persistence.*;

import com.example.rets_api.resource.Enums.*;

import java.util.Objects;

@Entity(name = "viewData")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ViewDataEntity {

    @Id
    @GeneratedValue
    @Column(name="viewData_id")
    private long viewDataId;

    private String cityLight;
    private Indicator cityLightIndicator;

    private String mountain;
    private Indicator mountainIndicator;

    private String river;
    private Indicator riverIndicator;

    private String lake;
    private Indicator lakeIndicator;

    private String golfCourse;
    private Indicator golfCourseIndicator;

    private String water;
    private Indicator waterIndicator;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ViewDataEntity)) return false;
        ViewDataEntity that = (ViewDataEntity) o;
        return Objects.equals(getCityLight(), that.getCityLight()) && getCityLightIndicator() == that.getCityLightIndicator() && Objects.equals(getMountain(), that.getMountain()) && getMountainIndicator() == that.getMountainIndicator() && Objects.equals(getRiver(), that.getRiver()) && getRiverIndicator() == that.getRiverIndicator() && Objects.equals(getLake(), that.getLake()) && getLakeIndicator() == that.getLakeIndicator() && Objects.equals(getGolfCourse(), that.getGolfCourse()) && getGolfCourseIndicator() == that.getGolfCourseIndicator() && Objects.equals(getWater(), that.getWater()) && getWaterIndicator() == that.getWaterIndicator();
    }

}
