package com.example.rets_api.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.springframework.util.ObjectUtils.isEmpty;

@Repository
public class PropertyRepositoryQuerydsl extends QuerydslRepositorySupport {

    public PropertyRepositoryQuerydsl() {
        super(PropertyEntity.class);
    }

    public List<PropertyEntity> fetchAll(PropertyFilter filterParams) {
        QPropertyEntity property = QPropertyEntity.propertyEntity;
        QRoomEntity room = QRoomEntity.roomEntity;
        QSchoolEntity school = QSchoolEntity.schoolEntity;

        // Joining tables
        JPQLQuery<PropertyEntity> query = from(property).distinct()
                .join(room).on(property.roomList.contains(room))
                .join(school).on(property.schoolList.contains(school));

        if(filterParams.getAge() > 0)
            query = query.where(property.age.eq(filterParams.getAge()));

        if(nonNull(filterParams.getHorseFacilities()))
            query = query.where(property.horseFacilities.likeIgnoreCase(filterParams.getHorseFacilities()));

        if(nonNull(filterParams.getHorseFacilitiesIndicator()))
            query = query.where(property.horseFacilitiesIndicator.eq(filterParams.getHorseFacilitiesIndicator()));

        if(nonNull(filterParams.getHotTub()))
            query = query.where(property.hotTub.likeIgnoreCase(filterParams.getHotTub()));

        if(nonNull(filterParams.getHotTubIndicator()))
            query = query.where(property.hotTubIndicator.eq(filterParams.getHotTubIndicator()));

        if(nonNull(filterParams.getTennisCourt()))
            query = query.where(property.tennisCourt.likeIgnoreCase(filterParams.getTennisCourt()));

        if(nonNull(filterParams.getTennisCourtIndicator()))
            query = query.where(property.tennisCourtIndicator.eq(filterParams.getTennisCourtIndicator()));

        if(nonNull(filterParams.getInclusions()))
            query = query.where(property.inclusions.likeIgnoreCase(filterParams.getInclusions()));

        if(nonNull(filterParams.getEnergyInformation()))
            query = query.where(property.energyInformation.likeIgnoreCase(filterParams.getEnergyInformation()));

        if(nonNull(filterParams.getConstructionMaterial()))
            query = query.where(property.constructionMaterial.likeIgnoreCase(filterParams.getConstructionMaterial()));

        if(nonNull(filterParams.getDisabilityFeatures()))
            query = query.where(property.disabilityFeatures.likeIgnoreCase(filterParams.getDisabilityFeatures()));

        if(nonNull(filterParams.getDisabilityFeaturesIndicator()))
            query = query.where(property.disabilityFeaturesIndicator.eq(filterParams.getDisabilityFeaturesIndicator()));

        if(nonNull(filterParams.getSecurityFeatures()))
            query = query.where(property.securityFeatures.likeIgnoreCase(filterParams.getSecurityFeatures()));

        if(nonNull(filterParams.getSecurityFeaturesIndicator()))
            query = query.where(property.securityFeaturesIndicator.eq(filterParams.getSecurityFeaturesIndicator()));

        if(nonNull(filterParams.getPropertyTypeRental()))
            query = query.where(property.propertyTypeRental.eq(filterParams.getPropertyTypeRental()));

        if(nonNull(filterParams.getPropertyTypeCondo()))
            query = query.where(property.propertyTypeCondo.eq(filterParams.getPropertyTypeCondo()));

        if(nonNull(filterParams.getPropertyTypeFarm()))
            query = query.where(property.propertyTypeFarm.eq(filterParams.getPropertyTypeFarm()));

        if(nonNull(filterParams.getPropertyTypeTownHouse()))
            query = query.where(property.propertyTypeTownHouse.eq(filterParams.getPropertyTypeTownHouse()));

        if(!isEmpty(filterParams.getSchoolList())){
            BooleanBuilder builder = new BooleanBuilder();
            for(SchoolDTO schoolDTO: filterParams.getSchoolList()) {
                if(!isNull(schoolDTO.getPrimary()) && !isNull(schoolDTO.getJrHigh())){
                    builder = builder.or(school.primarySchool.eq(schoolDTO.getPrimary()).and(school.jrHigh.eq(schoolDTO.getJrHigh())));
                } else if(isNull(schoolDTO.getPrimary()) && !isNull(schoolDTO.getJrHigh())){
                        builder = builder.or(school.jrHigh.eq(schoolDTO.getJrHigh()));
                } else if(!isNull(schoolDTO.getPrimary()) && isNull(schoolDTO.getJrHigh())){
                    builder = builder.or(school.primarySchool.eq(schoolDTO.getPrimary()));
                }
            }
            query = query.where(builder);
        }

        if(filterParams.getBedroomsQty() >= 0)
            query = query.where(property.bedroomsQty.eq(filterParams.getBedroomsQty()));

        if(filterParams.getBathroomsQty() >= 0)
            query = query.where(property.bathroomsQty.eq(filterParams.getBathroomsQty()));

        return query.fetch();
    }
}
