package com.back.back.entity;

import com.back.back.common.object.ChatMessage;
import com.back.back.common.util.ChangeDateFormatUtil;

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

@Entity
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

    private Integer chatroomId;
    private String senderId;
    private String message;
    private String sendDatetime;

    public ChatMessageEntity(ChatMessage chatMessage) {

        this.chatroomId = chatMessage.getChatroomId();
        this.senderId = chatMessage.getSenderId();
        this.message = chatMessage.getMessage();
        this.sendDatetime = ChangeDateFormatUtil.getCurrentDatetiem();
    }
}
