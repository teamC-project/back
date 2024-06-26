package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.back.back.service.ChatroomService;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.request.chatroom.PostChatroomRequestDto;
import com.back.back.dto.response.chatroom.GetChatroomResponseDto;
import com.back.back.dto.response.chatroom.GetChatroomListResponseDto;
import com.back.back.dto.response.chatmessage.GetChatMessageListResponseDto;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/chat")
@RequiredArgsConstructor
public class ChatroomController {

    private final ChatroomService chatroomService;

    @GetMapping("/rooms")
    public ResponseEntity<? super GetChatroomListResponseDto> getChatroomList(
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<? super GetChatroomListResponseDto> response = chatroomService.getChatroomList(userId);
        return response;
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<? super GetChatroomResponseDto> getChatroom(
        @PathVariable("roomId") int roomId
        ) {
            ResponseEntity<? super GetChatroomResponseDto> response = chatroomService.getChatroom(roomId);
        return response;
    }

    @GetMapping("/{roomId}/messages")
    public ResponseEntity<? super GetChatMessageListResponseDto> getChatMessageList(
        @PathVariable("roomId") int roomId
        ) {
            ResponseEntity<? super GetChatMessageListResponseDto> response = chatroomService.getChatMessageList(roomId);
        return response;
    }

    @PostMapping("/room")
    public ResponseEntity<ResponseDto> postChatRoom (
        @RequestBody @Valid PostChatroomRequestDto requestBody,
        @AuthenticationPrincipal String userId
        ) {
            String roomName = requestBody.getRoomName();
            System.out.println("Received request to create chat room with roomName: " + roomName);
            ResponseEntity<ResponseDto> response = chatroomService.postChatroom(requestBody, userId, roomName);
        return response;
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<ResponseDto> deleteChatroom(
        @PathVariable("roomId") int roomId,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = chatroomService.deleteChatroom(roomId, userId);
        return response;
    }

}