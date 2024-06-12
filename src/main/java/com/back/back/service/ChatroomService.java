package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.chatmessage.PostChatmessageRequestDto;
import com.back.back.dto.request.chatroom.PostChatroomRequestDto;
import com.back.back.dto.response.ResponseDto;

public interface ChatroomService {

    ResponseEntity<ResponseDto> postChatroom(PostChatroomRequestDto dto, String userId);
    ResponseEntity<ResponseDto> postChatMessage(PostChatmessageRequestDto dto, int roomId, String userId);
    
    // ResponseEntity<>
} 
