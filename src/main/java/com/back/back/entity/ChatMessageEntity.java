package com.back.back.entity;


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "chatMessage")
@Table(name = "chat_message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessageEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private ChatroomEntity chatroom;

    private String senderId;
    private String message;
    private String sendDatetime;

    public ChatMessageEntity(ChatroomEntity chatRoom, String senderId, String message) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sendDatetime = simpleDateFormat.format(now);

        this.chatroom = chatRoom;
        this.senderId = senderId;
        this.message = message;
        this.sendDatetime = sendDatetime;
    }

    private void updateMessage(String message) {
        this.message = message;
    }

}
