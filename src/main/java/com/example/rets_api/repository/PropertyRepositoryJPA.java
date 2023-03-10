package com.example.rets_api.repository;

import com.example.rets_api.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepositoryJPA extends JpaRepository<PropertyEntity, Long> {
}
