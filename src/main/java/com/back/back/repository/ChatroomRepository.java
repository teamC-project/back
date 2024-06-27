package com.back.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.back.back.entity.ChatroomEntity;

@Repository
public interface ChatroomRepository extends JpaRepository<ChatroomEntity, Integer> {

    boolean existsByCustomerId(String customerId);
    boolean existsByDesignerId(String designerId);

    ChatroomEntity findByRoomId(Integer roomId);

    List<ChatroomEntity> findByCustomerIdOrDesignerId(String customerId, String designerId);
    
} 
