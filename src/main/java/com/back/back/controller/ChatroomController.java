// package com.back.back.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.back.back.dto.request.chatmessage.PostChatmessageRequestDto;
// import com.back.back.dto.request.chatroom.PostChatroomRequestDto;
// import com.back.back.dto.response.ResponseDto;
// import com.back.back.service.ChatroomService;

// import jakarta.validation.Valid;
// import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("/api/v1/chat")
// @RequiredArgsConstructor
// public class ChatroomController {
    
//     private final ChatroomService chatroomService;

//     @PostMapping("/room")
//     public ResponseEntity<ResponseDto> postChatRoom (
//         @RequestBody @Valid PostChatroomRequestDto requestBody,
//         @AuthenticationPrincipal String userId
//     ) {
//         ResponseEntity<ResponseDto> response = chatroomService.postChatroom(requestBody, userId);
//         return response;
//     }

//     @PostMapping("/room/{roomId}/message")
//     public ResponseEntity<ResponseDto> postChatMessage (
//         @RequestBody @Valid PostChatmessageRequestDto requestbody,
//         @PathVariable("roomId") int roomId,
//         @AuthenticationPrincipal String userId
//     ) {
//         ResponseEntity<ResponseDto> response = chatroomService.postChatMessage(requestbody, roomId, userId);
//         return response;
//     }
// }
