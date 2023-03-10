package com.example.rets_api.repository;

import com.example.rets_api.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SchoolRepositoryJPA extends JpaRepository<SchoolEntity, Long> {

//    @Query(name = "SELECT s.* FROM school s LEFT JOIN property_school ps ON ps.school_id = idSchool WHERE s.school_id = idSchool and ps.property_id = idProperty", nativeQuery = true)
//    List<SchoolEntity> findByPropertyId(Long propertyId);
//    Optional<SchoolEntity> findSchoolEntityBySchoolIdAndPropertyPropertyId(@Param("idSchool") Long schoolId, @Param("idProperty") Long propertyId);
}
