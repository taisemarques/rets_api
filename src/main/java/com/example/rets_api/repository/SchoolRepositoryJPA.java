package com.example.rets_api.repository;

import com.example.rets_api.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SchoolRepositoryJPA extends JpaRepository<SchoolEntity, Long> {
}
