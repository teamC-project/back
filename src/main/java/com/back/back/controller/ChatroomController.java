package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.dto.request.chatmessage.PostChatmessageRequestDto;
import com.back.back.dto.request.chatroom.PostChatroomRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.chatmessage.GetChatMessageListResponseDto;
import com.back.back.dto.response.chatroom.GetChatroomListResponseDto;
import com.back.back.dto.response.chatroom.GetChatroomResponseDto;
import com.back.back.service.ChatroomService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/chat")
@RequiredArgsConstructor
public class ChatroomController {
    
    private final ChatroomService chatroomService;

    @PostMapping("/room")
    public ResponseEntity<ResponseDto> postChatRoom (
        @RequestBody @Valid PostChatroomRequestDto requestBody,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = chatroomService.postChatroom(requestBody, userId);
        return response;
    }

    @PostMapping("/room/{roomId}/message")
    public ResponseEntity<ResponseDto> postChatMessage (
        @RequestBody @Valid PostChatmessageRequestDto requestbody,
        @PathVariable("roomId") int roomId,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = chatroomService.postChatMessage(requestbody, roomId, userId);
        return response;
    }

    @GetMapping("/rooms")
    public ResponseEntity<? super GetChatroomListResponseDto> getChatroomList() {
        ResponseEntity<? super GetChatroomListResponseDto> response = chatroomService.getChatroomList();
        return response;
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<? super GetChatroomResponseDto> getChatroom(
        @PathVariable("roomId") int roomId
    ) {
        ResponseEntity<? super GetChatroomResponseDto> response = chatroomService.getChatroom(roomId);
        return response;
    }

    @GetMapping("/room/{roomId}/messages")
    public ResponseEntity<? super GetChatMessageListResponseDto> getChatMessageList(
        @PathVariable("roomId") int roomId
    ) {
        ResponseEntity<? super GetChatMessageListResponseDto> response = chatroomService.getChatMessageList(roomId);
        return response;
    }

    @DeleteMapping("/room/{roomId}")
    public ResponseEntity<ResponseDto> deleteChatroom(
        @PathVariable("roomId") int roomId
    ) {
        ResponseEntity<ResponseDto> response = chatroomService.deleteChatroom(roomId);
        return response;
    }

    @DeleteMapping("/room/{roomId}/message/{messageId}")
    public ResponseEntity<ResponseDto> deleteChatMessage(
        @PathVariable("roomId") int roomId,
        @PathVariable("messageId") int messageId
    ) {
        ResponseEntity<ResponseDto> response = chatroomService.deleteChatMessage(messageId, messageId);
        return response;
    }
}
