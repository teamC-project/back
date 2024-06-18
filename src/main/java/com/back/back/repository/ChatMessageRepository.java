package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.ChatMessageEntity;
import com.back.back.entity.ChatroomEntity;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Integer> {


    List<ChatMessageEntity> findByChatroom(ChatroomEntity chatroom);
}

