package com.example.rets_api.converter;

import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.SchoolEntity;
import com.example.rets_api.repository.UtilsTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SchoolConverterTest {

    //DTO To Entity

    @Test
    public void dtoTOEntity_NullSchoolConverter_ShouldReturnNull(){
        SchoolEntity schoolEntity = SchoolConverter.schoolDTOToSchoolEntity.convert(null);
        assertNull(schoolEntity);
    }

    @Test
    public void dtoTOEntity_EmptySchoolConverter_ShouldReturnEmpty(){
        SchoolDTO schoolDTO = SchoolDTO.builder().build();
        SchoolEntity schoolEntity = SchoolConverter.schoolDTOToSchoolEntity.convert(schoolDTO);
        checkNullAllFields_SchoolDataEntity(schoolEntity);
    }

    @Test
    public void dtoTOEntity_SchoolConverter_ShouldReturnCompleteObject(){
        SchoolDTO schoolDTO = UtilsTest.createSchoolDTO("primary", "jrHigh");
        SchoolEntity schoolEntity = SchoolConverter.schoolDTOToSchoolEntity.convert(schoolDTO);
        checkAllFields_School(schoolEntity, schoolDTO);
    }

    //Entity To DTO

    @Test
    public void entityToDTO_NullSchoolConverter_ShouldReturnNull(){
        SchoolDTO schoolDTO = SchoolConverter.schoolEntityToSchoolDTO.convert(null);
        assertNull(schoolDTO);
    }

    @Test
    public void entityToDTO_EmptySchoolConverter_ShouldReturnEmpty(){
        SchoolEntity schoolEntity = new SchoolEntity();
        SchoolDTO schoolDTO = SchoolConverter.schoolEntityToSchoolDTO.convert(schoolEntity);
        checkNullAllFields_SchoolDTO(schoolDTO);
    }

    @Test
    public void entityToDTO_SchoolConverter_ShouldReturnCompleteObject(){
        SchoolEntity schoolEntity = UtilsTest.createSchoolEntity("primary", "jrHigh");
        SchoolDTO schoolDTO = SchoolConverter.schoolEntityToSchoolDTO.convert(schoolEntity);
        checkAllFields_School(schoolEntity, schoolDTO);
    }

    private void checkNullAllFields_SchoolDataEntity(SchoolEntity schoolEntity){
        assertNull(schoolEntity.getPrimarySchool());
        assertNull(schoolEntity.getJrHigh());
    }

    private void checkNullAllFields_SchoolDTO(SchoolDTO schoolDTO){
        assertNull(schoolDTO.getPrimary());
        assertNull(schoolDTO.getJrHigh());
    }

    private void checkAllFields_School(SchoolEntity schoolEntity, SchoolDTO schoolDTO) {
        assertEquals(schoolEntity.getPrimarySchool(), schoolDTO.getPrimary());
        assertEquals(schoolEntity.getJrHigh(), schoolDTO.getJrHigh());
    }

}
