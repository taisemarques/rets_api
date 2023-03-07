package com.example.rets_api.repository;

import com.example.rets_api.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepositoryJPA extends JpaRepository<RoomEntity, Long> {

    Optional<RoomEntity> findRoomEntityByRoomIdAndPropertyPropertyId(Long roomId, Long propertyId);

}
