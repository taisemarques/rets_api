package com.example.rets_api.converter;

import com.example.rets_api.dto.AnimalPolicyDTO;
import com.example.rets_api.entity.AnimalPolicyEntity;
import com.example.rets_api.repository.UtilsTest;
import org.junit.Test;

import static com.example.rets_api.converter.PropertyConverterTest.checkAllFields_Property;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AnimalPolicyConverterTest {

    //DTO To Entity

    @Test
    public void dtoTOEntity_NullAnimalPolicyConverter_ShouldReturnNull(){
        AnimalPolicyEntity animalPolicyEntity = AnimalPolicyConverter.animalPolicyDTOToAnimalPolicyEntity.convert(null);
        assertNull(animalPolicyEntity);
    }

    @Test
    public void dtoTOEntity_EmptyAnimalPolicyConverter_ShouldReturnEmpty(){
        AnimalPolicyDTO animalPolicyDTO = AnimalPolicyDTO.builder().build();
        AnimalPolicyEntity animalPolicyEntity = AnimalPolicyConverter.animalPolicyDTOToAnimalPolicyEntity.convert(animalPolicyDTO);
        checkNullAllFields_AnimalPolicy(animalPolicyEntity);
    }

    @Test
    public void dtoTOEntity_AnimalPolicyConverter_ShouldReturnCompleteObject(){
        AnimalPolicyDTO animalPolicyDTO = UtilsTest.createAnimalPolicyDTO();
        AnimalPolicyEntity animalPolicyEntity = AnimalPolicyConverter.animalPolicyDTOToAnimalPolicyEntity.convert(animalPolicyDTO);
        checkAllFields_AnimalPolicy(animalPolicyEntity, animalPolicyDTO);
    }

    //Entity To DTO

    @Test
    public void entityToDTO_NullAnimalPolicyConverter_ShouldReturnNull(){
        AnimalPolicyDTO animalPolicyDTO = AnimalPolicyConverter.animalPolicyEntityToAnimalPolicyDTO.convert(null);
        assertNull(animalPolicyDTO);
    }

    @Test
    public void entityToDTO_EmptyAnimalPolicyConverter_ShouldReturnEmpty(){
        AnimalPolicyEntity animalPolicyEntity = new AnimalPolicyEntity();
        AnimalPolicyDTO animalPolicyDTO = AnimalPolicyConverter.animalPolicyEntityToAnimalPolicyDTO.convert(animalPolicyEntity);
        checkNullAllFields_AnimalPolicyDTO(animalPolicyDTO);
    }

    @Test
    public void entityToDTO_AnimalPolicyConverter_ShouldReturnCompleteObject(){
        AnimalPolicyEntity animalPolicyEntity = UtilsTest.createAnimalPolicy("permitted");
        AnimalPolicyDTO animalPolicyDTO = AnimalPolicyConverter.animalPolicyEntityToAnimalPolicyDTO.convert(animalPolicyEntity);
        checkAllFields_AnimalPolicy(animalPolicyEntity, animalPolicyDTO);
    }

    private void checkNullAllFields_AnimalPolicy(AnimalPolicyEntity animalPolicy){
        assertNull(animalPolicy.getAnimalsPermitted());
        assertNull(animalPolicy.getPermittedTypes());
        assertNull(animalPolicy.getWeightLimit());
        assertNull(animalPolicy.getWeightUnit());
        assertNull(animalPolicy.getProperties());
    }

    public static void checkAllFields_AnimalPolicy(AnimalPolicyEntity animalPolicyEntity, AnimalPolicyDTO animalPolicyDTO){

        assertEquals(animalPolicyDTO.getAnimalsPermitted(), animalPolicyEntity.getAnimalsPermitted());
        assertEquals(animalPolicyDTO.getPermittedTypes(), animalPolicyEntity.getPermittedTypes());
        assertEquals(animalPolicyDTO.getWeightLimit(), animalPolicyEntity.getWeightLimit());
        assertEquals(animalPolicyDTO.getWeightUnit(), animalPolicyEntity.getWeightUnit());
    }

    private void checkNullAllFields_AnimalPolicyDTO(AnimalPolicyDTO animalPolicyDTO){
        assertNull(animalPolicyDTO.getAnimalsPermitted());
        assertNull(animalPolicyDTO.getPermittedTypes());
        assertNull(animalPolicyDTO.getWeightLimit());
        assertNull(animalPolicyDTO.getWeightUnit());
    }


}
