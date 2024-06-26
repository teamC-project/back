package com.back.back.dto.response.chatmessage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.entity.ChatMessageEntity;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.common.object.ChatMessageListItem;

import lombok.Getter;

@Getter

public class GetChatMessageListResponseDto extends ResponseDto {
    
    private List<ChatMessageListItem> chatMessageList;

    private GetChatMessageListResponseDto (List<ChatMessageEntity> chatMessageEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.chatMessageList = ChatMessageListItem.getList(chatMessageEntities);
    }

    public static ResponseEntity<GetChatMessageListResponseDto> success (List<ChatMessageEntity> chatMessageEntities) throws Exception {

        GetChatMessageListResponseDto responseBody = new GetChatMessageListResponseDto(chatMessageEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
