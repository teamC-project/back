package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.ChatroomEntity;

@Repository
public interface ChatroomRepository extends JpaRepository<ChatroomEntity, Integer> {

    ChatroomEntity findByRoomId(Integer roomId);

    boolean existsByCustomerId(String customerId);
    boolean existsByDesignerId(String designerId);

    List<ChatroomEntity> findByCustomerIdOrDesignerId(String customerId, String designerId);
} 
