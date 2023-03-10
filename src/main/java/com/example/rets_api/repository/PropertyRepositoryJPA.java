package com.example.rets_api.repository;

import com.example.rets_api.entity.PropertyEntity;
import com.example.rets_api.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepositoryJPA extends JpaRepository<PropertyEntity, Long> {

    List<SchoolEntity> findSchoolListByPropertyId(Long propertyId);
}
