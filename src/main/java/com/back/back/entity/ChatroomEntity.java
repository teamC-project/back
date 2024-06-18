package com.back.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "chatRoom")
@Table(name = "chat_room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatroomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;
    private String customerId;
    private String designerId;
    private String roomName;

    public ChatroomEntity(String customerId, String designerId, String roomName) {
        this.customerId = customerId;
        this.designerId = designerId;
        this.roomName = roomName;
    }
}
