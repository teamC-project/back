package com.back.back.dto.response.chatroom;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.entity.ChatroomEntity;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.common.object.ChatroomListItem;

import lombok.Getter;

@Getter
public class GetChatroomListResponseDto extends ResponseDto {

    private List<ChatroomListItem> chatRoomList;

    private GetChatroomListResponseDto(List<ChatroomEntity> chatroomEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.chatRoomList = ChatroomListItem.getList(chatroomEntities);
    }

    public static ResponseEntity<GetChatroomListResponseDto> success(List<ChatroomEntity> chatroomEntities) throws Exception {

        GetChatroomListResponseDto responseBody = new GetChatroomListResponseDto(chatroomEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}