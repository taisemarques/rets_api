package com.example.rets_api.repository;

import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.entity.QPropertyEntity;
import com.example.rets_api.entity.QRoomEntity;
import com.example.rets_api.entity.QSchoolEntity;
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


        // Joining tables
        JPQLQuery<PropertyEntity> query = from(property)
                .join(room).on(property.roomList.contains(room))
                .join(school).on(property.schoolEntity.property.propertyId.eq(school.property.propertyId));


        if(nonNull(filterParams.getDescription()))
            query = query.where(property.description.likeIgnoreCase(filterParams.getDescription()));

        if(nonNull(filterParams.getPrice()))
            query = query.where(property.price.eq(filterParams.getPrice()));

        if(nonNull((filterParams.getPrimarySchool())))
            query = query.where(property.schoolEntity.primarySchool.eq(filterParams.getPrimarySchool()));

        if(nonNull((filterParams.getJrHigh())))
            query = query.where(property.schoolEntity.jrHigh.eq(filterParams.getJrHigh()));

        if(filterParams.getBedroomsQty() > 0)
            query = query.where(property.bedroomsQty.eq(filterParams.getBedroomsQty()));

        if(filterParams.getBathroomsQty() > 0)
            query = query.where(property.bathroomsQty.eq(filterParams.getBathroomsQty()));


        return query.groupBy(room.roomType).fetch();
    }
}
