package com.example.rets_api.entity;
import lombok.*;

import javax.persistence.*;

import com.example.rets_api.resource.Enums.*;


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


}
