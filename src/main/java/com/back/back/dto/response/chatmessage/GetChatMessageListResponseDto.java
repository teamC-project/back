package com.back.back.dto.response.chatmessage;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetChatMessageListResponseDto {
    
    private boolean success;
    private List<ChatMessageDto> messages;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ChatMessageDto{
        private Integer messageId;
        private String senderId;
        private String message;
        private String sendDatetime;
    }
}
