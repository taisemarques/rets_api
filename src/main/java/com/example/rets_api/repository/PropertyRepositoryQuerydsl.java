package com.example.rets_api.repository;

import com.example.rets_api.converter.SchoolConverter;
import com.example.rets_api.dto.SchoolDTO;
import com.example.rets_api.entity.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Objects.nonNull;

@Repository
public class PropertyRepositoryQuerydsl extends QuerydslRepositorySupport {

    public PropertyRepositoryQuerydsl() {
        super(PropertyEntity.class);
    }

    public List<PropertyEntity> fetchAll(PropertyFilter filterParams) {
        QPropertyEntity property = QPropertyEntity.propertyEntity;
        QRoomEntity room = QRoomEntity.roomEntity;
        QSchoolEntity school = QSchoolEntity.schoolEntity;
        QPropertySchoolEntity propertySchool = QPropertySchoolEntity.propertySchoolEntity;


        // Joining tables
        JPQLQuery<PropertyEntity> query = from(property)
                .join(room).on(property.roomList.contains(room));
//                .join(propertySchool).on(propertySchool.propertyId.eq(property.propertyId))
//                .join(school).on(propertySchool.propertyId.eq(property.schoolList.));


        if(nonNull(filterParams.getDescription()))
            query = query.where(property.description.likeIgnoreCase(filterParams.getDescription()));

        if(nonNull(filterParams.getPrice()))
            query = query.where(property.price.eq(filterParams.getPrice()));

        if(nonNull((filterParams.getSchoolList()))){
            BooleanBuilder builder = new BooleanBuilder();
            for(SchoolDTO schoolDTO: filterParams.getSchoolList()){
                builder = builder.or(property.schoolList.contains(SchoolConverter.schoolDTOToSchoolEntity.convert(schoolDTO)));
            }
            query = query.where(builder);
        }

        if(filterParams.getBedroomsQty() > 0)
            query = query.where(property.bedroomsQty.eq(filterParams.getBedroomsQty()));

        if(filterParams.getBathroomsQty() > 0)
            query = query.where(property.bathroomsQty.eq(filterParams.getBathroomsQty()));


        return query.groupBy(room.roomType).fetch();
    }
}
