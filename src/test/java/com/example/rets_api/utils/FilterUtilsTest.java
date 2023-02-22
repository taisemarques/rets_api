package com.example.rets_api.utils;


import com.example.rets_api.entity.*;
import com.example.rets_api.resource.Enums.*;
import com.example.rets_api.resource.PropertyFilter;

import java.util.Arrays;

import static java.util.Arrays.asList;

public class FilterUtilsTest {

    public static PropertyFilter createDefaultPropertyFilter(){
        PropertyFilter propertyFilter = new PropertyFilter();
        propertyFilter.setPropertyAge(10);
        propertyFilter.setPropertyBathroomsQty(2);
        propertyFilter.setPropertyBedroomsQty(3);
        return propertyFilter;
    }

}
