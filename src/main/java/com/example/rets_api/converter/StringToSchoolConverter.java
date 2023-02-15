package com.example.rets_api.converter;

import com.example.rets_api.dto.SchoolDTO;
import org.springframework.core.convert.converter.Converter;

import static com.example.rets_api.resource.Constants.DEFAULT_STRING_VALUE;

public class StringToSchoolConverter implements Converter<String, SchoolDTO> {

    @Override
    public SchoolDTO convert(String school) {
        String primary = DEFAULT_STRING_VALUE;
        String jrHigh = DEFAULT_STRING_VALUE;
        if(school.trim().equals(";") || school.trim().isEmpty()){
            return null;
        } else {
            try {
                String[] values = school.split(";");
                primary = values[0].trim().isEmpty()?primary:values[0].trim();
                if(values.length > 1) {
                    jrHigh = values[1].trim().isEmpty()?jrHigh:values[1].trim();
                }
                SchoolDTO schoolDTO = SchoolDTO.builder().primary(primary).jrHigh(jrHigh).build();
                return schoolDTO;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }

}

