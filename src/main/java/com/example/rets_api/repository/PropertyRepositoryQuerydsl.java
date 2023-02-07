package com.example.rets_api.repository;

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

        //TODO: need to add all fields

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

        if(filterParams.getBedroomsQty() > 0)
            query = query.where(property.bedroomsQty.eq(filterParams.getBedroomsQty()));

        if(filterParams.getBathroomsQty() > 0)
            query = query.where(property.bathroomsQty.eq(filterParams.getBathroomsQty()));

        return query.fetch();
    }
}
