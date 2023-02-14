package com.example.rets_api.converter;

import com.example.rets_api.dto.CommunityDTO;
import com.example.rets_api.entity.CommunityEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class CommunityConverter {

    public static Converter<CommunityDTO, CommunityEntity> communityDTOToCommunityEntity = in -> {
        if(isNull(in)) return null;
        CommunityEntity communityEntity = new CommunityEntity();
        communityEntity.setIndicator(in.getIndicator());
        communityEntity.setName(in.getName());
        communityEntity.setType(in.getType());
        return communityEntity;
    };

    public static Converter<CommunityEntity, CommunityDTO> communityEntityToCommunityDTO = in -> {
        if (isNull(in)) return null;
        return CommunityDTO.builder()
                .indicator(in.getIndicator())
                .name(in.getName())
                .type(in.getType())
                .build();
    };

    public static List<CommunityDTO> listCommunityEntityToListCommunityDTO(List<CommunityEntity> communityEntities) {
        if (isNull(communityEntities)) return null;
        return communityEntities.stream()
                .map(community -> communityEntityToCommunityDTO.convert(community))
                .collect(Collectors.toList());
    }

    public static List<CommunityEntity> listCommunityDTOToListCommunityEntity(List<CommunityDTO> communityDTOS) {
        if (isNull(communityDTOS)) return null;
        return communityDTOS.stream()
                .map(communityEntity -> communityDTOToCommunityEntity.convert(communityEntity))
                .collect(Collectors.toList());
    }
}
