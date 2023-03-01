package com.example.rets_api.utils;

import com.example.rets_api.resource.PropertyFilter;

public class FilterUtilsTest {

    public static PropertyFilter createPropertyFilterAgeBedroomBathRoom(){
        PropertyFilter propertyFilter = new PropertyFilter();
        propertyFilter.setPropertyAgeStart(10);
        propertyFilter.setPropertyBathroomsQtyStart(2);
        propertyFilter.setPropertyBedroomsQtyStart(3);
        return propertyFilter;
    }

    public static String createURLVariablesOperatorAgeBedroomBathroom(){
        return "?propertyAgeStart=4&propertyAgeEnd=10"+
                "&propertyBedroomsQtyStart=1&propertyBedroomsQtyStartOperator=GREATER_THEN" +
                "&propertyBathroomsQtyEnd=3&propertyBathroomsQtyEndOperator=LESS_THEN";
    }

}
