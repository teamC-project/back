package com.back.back.dto.response.chatroom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.entity.ChatroomEntity;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetChatroomResponseDto extends ResponseDto {
    
    private Integer chatroomId;
    private String customerId;
    private String designerId;
    private String roomName;

    private GetChatroomResponseDto(ChatroomEntity chatroomEntity) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.chatroomId = chatroomEntity.getRoomId();
        this.customerId = chatroomEntity.getCustomerId();
        this.designerId = chatroomEntity.getDesignerId();
        this.roomName = chatroomEntity.getRoomName();
    }

    public static ResponseEntity<GetChatroomResponseDto> success (ChatroomEntity chatroomEntity) throws Exception {
        
        GetChatroomResponseDto responseBody = new GetChatroomResponseDto(chatroomEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
