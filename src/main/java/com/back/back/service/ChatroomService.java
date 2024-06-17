package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.chatroom.PostChatroomRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.chatmessage.GetChatMessageListResponseDto;
import com.back.back.dto.response.chatroom.GetChatroomListResponseDto;
import com.back.back.dto.response.chatroom.GetChatroomResponseDto;

public interface ChatroomService {

    ResponseEntity<ResponseDto> postChatroom(PostChatroomRequestDto dto, String userId, String roomName);
    
    ResponseEntity<? super GetChatroomListResponseDto> getChatroomList(String userId);
    ResponseEntity<? super GetChatroomResponseDto> getChatroom(int roomId);
    ResponseEntity<? super GetChatMessageListResponseDto> getChatMessageList(int roomId);

    ResponseEntity<ResponseDto> deleteChatroom(int roomId, String userId);
} 
