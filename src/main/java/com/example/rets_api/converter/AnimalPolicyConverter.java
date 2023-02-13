package com.example.rets_api.converter;

import com.example.rets_api.dto.AnimalPolicyDTO;
import com.example.rets_api.dto.FinancialDataDTO;
import com.example.rets_api.entity.AnimalPolicyEntity;
import com.example.rets_api.entity.FinancialDataEntity;
import org.springframework.core.convert.converter.Converter;

import static java.util.Objects.isNull;

public class AnimalPolicyConverter {
    public static Converter<AnimalPolicyDTO, AnimalPolicyEntity> animalPolicyDTOToAnimalPolicyEntity = in -> {
        if(isNull(in)) return null;
        AnimalPolicyEntity animalPolicyEntity = new AnimalPolicyEntity();
        animalPolicyEntity.setAnimalsPermitted(in.getAnimalsPermitted());
        animalPolicyEntity.setPermittedTypes(in.getPermittedTypes());
        animalPolicyEntity.setWeightLimit(in.getWeightLimit());
        animalPolicyEntity.setWeightUnit(in.getWeightUnit());
        return animalPolicyEntity;
    };

    public static Converter<AnimalPolicyEntity, AnimalPolicyDTO> animalPolicyEntityToAnimalPolicyDTO = in -> {
        if(isNull(in)) return null;
        return AnimalPolicyDTO.builder()
                .animalsPermitted(in.getAnimalsPermitted())
                .permittedTypes(in.getPermittedTypes())
                .weightLimit(in.getWeightLimit())
                .weightUnit(in.getWeightUnit())
                .build();
    };
}
