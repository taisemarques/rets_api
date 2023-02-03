package com.example.rets_api.repository;

import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.entity.QPropertyEntity;
import com.example.rets_api.entity.QRoomEntity;
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


        // Joining tables
        JPQLQuery<PropertyEntity> query = from(property)
                .join(room).on(property.roomList.contains(room));


        if(nonNull(filterParams.getDescription()))
            query = query.where(property.description.likeIgnoreCase(filterParams.getDescription()));

        if(nonNull(filterParams.getPrice()))
            query = query.where(property.price.eq(filterParams.getPrice()));

        if(nonNull((filterParams.getSchoolEntity())))
            query = query.where(property.schoolEntity.eq(filterParams.getSchoolEntity()));


        return query.groupBy(room.roomType).fetch();
    }
}
