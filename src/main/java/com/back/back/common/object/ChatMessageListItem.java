package com.back.back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.back.back.entity.ChatMessageEntity;

import lombok.Getter;

@Getter
public class ChatMessageListItem {
  private Integer roomId;
  private String senderMessage;
  private String receiveMessage;

  private ChatMessageListItem(ChatMessageEntity chatMessageEntity) {
    this.roomId = chatMessageEntity.getChatroomId();
    this.senderMessage = chatMessageEntity.getMessage();
    this.receiveMessage = chatMessageEntity.getMessage();
  }

  public static List<ChatMessageListItem> getList (List<ChatMessageEntity> chatMessageEntities) throws Exception {
    List<ChatMessageListItem> chatMessageList = new ArrayList<>();

    for (ChatMessageEntity chatMessageEntity : chatMessageEntities) {
      
    }

    return chatMessageList;
  }
}
