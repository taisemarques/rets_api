package com.example.rets_api.dto;

import com.example.rets_api.resource.Enums.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ViewDataDTO {

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

}
