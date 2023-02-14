package com.example.rets_api.repository;
import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.*;
import com.example.rets_api.resource.Enums.*;
import com.example.rets_api.resource.PropertyFilter;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.rets_api.resource.Constants.*;
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
        QViewDataEntity viewData = QViewDataEntity.viewDataEntity;

        // Joining tables
        JPQLQuery<PropertyEntity> query = from(property).distinct()
                .leftJoin(room).on(property.roomList.contains(room))
                .leftJoin(school).on(property.schoolList.contains(school))
                .leftJoin(viewData).on(property.viewData.eq(viewData));

        if(filterParams.getAge() > 0)
            query = query.where(property.age.eq(filterParams.getAge()));

        if(!filterParams.getHorseFacilities().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.horseFacilities.likeIgnoreCase(filterParams.getHorseFacilities()));

        if(!filterParams.getHorseFacilitiesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.horseFacilitiesIndicator.eq(filterParams.getHorseFacilitiesIndicator()));

        if(!filterParams.getHotTub().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.hotTub.likeIgnoreCase(filterParams.getHotTub()));

        if(!filterParams.getHotTubIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.hotTubIndicator.eq(filterParams.getHotTubIndicator()));

        if(!filterParams.getTennisCourt().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.tennisCourt.likeIgnoreCase(filterParams.getTennisCourt()));

        if(!filterParams.getTennisCourtIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.tennisCourtIndicator.eq(filterParams.getTennisCourtIndicator()));

        if(!filterParams.getInclusions().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.inclusions.likeIgnoreCase(filterParams.getInclusions()));

        if(!filterParams.getEnergyInformation().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.energyInformation.likeIgnoreCase(filterParams.getEnergyInformation()));

        if(!filterParams.getConstructionMaterial().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.constructionMaterial.likeIgnoreCase(filterParams.getConstructionMaterial()));

        if(!filterParams.getDisabilityFeatures().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.disabilityFeatures.likeIgnoreCase(filterParams.getDisabilityFeatures()));

        if(!filterParams.getDisabilityFeaturesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.disabilityFeaturesIndicator.eq(filterParams.getDisabilityFeaturesIndicator()));

        if(!filterParams.getSecurityFeatures().equals(DEFAULT_STRING_VALUE))
            query = query.where(property.securityFeatures.likeIgnoreCase(filterParams.getSecurityFeatures()));

        if(!filterParams.getSecurityFeaturesIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.securityFeaturesIndicator.eq(filterParams.getSecurityFeaturesIndicator()));

        if(nonNull(filterParams.getPropertyTypeRental()))
            query = query.where(property.propertyTypeRental.eq(filterParams.getPropertyTypeRental()));

        if(nonNull(filterParams.getPropertyTypeCondo()))
            query = query.where(property.propertyTypeCondo.eq(filterParams.getPropertyTypeCondo()));

        if(nonNull(filterParams.getPropertyTypeFarm()))
            query = query.where(property.propertyTypeFarm.eq(filterParams.getPropertyTypeFarm()));

        if(nonNull(filterParams.getPropertyTypeTownHouse()))
            query = query.where(property.propertyTypeTownHouse.eq(filterParams.getPropertyTypeTownHouse()));

        if(!isEmpty(filterParams.getBathSizes())){
            BooleanBuilder builder = new BooleanBuilder();
            for(BathSize bathSize: filterParams.getBathSizes()) {
                if(!bathSize.equals(BathSize.DEFAULT_ENUM_VALUE)) {
                    if (bathSize.equals(BathSize.FULL)) {
                        builder = builder.or(room.roomType.eq(RoomType.MASTER_BEDROOM).orAllOf(room.roomType.eq(RoomType.MAIN_FLOOR_BATHROOM), room.bathSize.eq(bathSize)));
                    } else {
                        builder = builder.or(room.bathSize.eq(bathSize).and(room.roomType.eq(RoomType.MAIN_FLOOR_BATHROOM)));
                    }
                }
                query = query.where(builder);
            }
        }

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

        if(!filterParams.getCityLightIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
        query = query.where(property.viewData.cityLightIndicator.eq(filterParams.getCityLightIndicator()));

        if(!filterParams.getMountainIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.viewData.mountainIndicator.eq(filterParams.getMountainIndicator()));

        if(!filterParams.getRiverIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.viewData.riverIndicator.eq(filterParams.getRiverIndicator()));

        if(!filterParams.getLakeIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.viewData.lakeIndicator.eq(filterParams.getLakeIndicator()));

        if(!filterParams.getGolfCourseIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.viewData.golfCourseIndicator.eq(filterParams.getGolfCourseIndicator()));

        if(!filterParams.getWaterIndicator().equals(Indicator.DEFAULT_ENUM_VALUE))
            query = query.where(property.viewData.waterIndicator.eq(filterParams.getWaterIndicator()));

        return query.fetch();
    }
}
