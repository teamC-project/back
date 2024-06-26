package com.back.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.back.back.entity.ChatroomEntity;

import lombok.Getter;

@Getter
public class ChatroomListItem {

    private String roomName;
    private String customerId;
    private String designerId;
    private Integer chatroomId;

    private ChatroomListItem(ChatroomEntity chatroomEntity) {
        
        this.chatroomId = chatroomEntity.getRoomId();
        this.roomName = chatroomEntity.getRoomName();
        this.customerId = chatroomEntity.getCustomerId();
        this.designerId = chatroomEntity.getDesignerId();
    }

    public static List<ChatroomListItem> getList(List<ChatroomEntity> chatroomEntities) throws Exception {

        List<ChatroomListItem> chatroomList = new ArrayList<>();
        for (ChatroomEntity chatroomEntity : chatroomEntities) {
            
            ChatroomListItem chatroomListItem = new ChatroomListItem(chatroomEntity);
            chatroomList.add(chatroomListItem);
        }

        return chatroomList;
    }

}

