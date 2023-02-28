package com.example.rets_api.utils;

import com.example.rets_api.resource.PropertyFilter;

public class FilterUtilsTest {

    public static PropertyFilter createDefaultPropertyFilter(){
        PropertyFilter propertyFilter = new PropertyFilter();
        propertyFilter.setPropertyAge(10);
        propertyFilter.setPropertyBathroomsQty(2);
        propertyFilter.setPropertyBedroomsQty(3);
        return propertyFilter;
    }

}
