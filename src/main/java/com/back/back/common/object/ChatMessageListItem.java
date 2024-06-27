package com.back.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.back.back.entity.ChatMessageEntity;

import lombok.Getter;

@Getter
public class ChatMessageListItem {
    
    private String message;
    private String senderId;
    private Integer messageId;
    private Integer chatroomId;

    public ChatMessageListItem(ChatMessageEntity chatMessageEntity) {

        this.messageId = chatMessageEntity.getMessageId();
        this.chatroomId = chatMessageEntity.getChatroomId();
        this.senderId = chatMessageEntity.getSenderId();
        this.message = chatMessageEntity.getMessage();
    }

    public static List<ChatMessageListItem> getList (List<ChatMessageEntity> chatMessageEntities) throws Exception {

        List<ChatMessageListItem> chatMessageList = new ArrayList<>();
        for (ChatMessageEntity chatMessageEntity : chatMessageEntities) {
            
            ChatMessageListItem chatMessageListItem = new ChatMessageListItem(chatMessageEntity);
            chatMessageList.add(chatMessageListItem);
        }

        return chatMessageList;
    }

}
