package com.back.back.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import com.back.back.entity.UserEntity;
import com.back.back.entity.ChatroomEntity;
import com.back.back.service.ChatroomService;
import com.back.back.entity.ChatMessageEntity;
import com.back.back.dto.response.ResponseDto;
import com.back.back.repository.UserRepository;
import com.back.back.repository.ChatroomRepository;
import com.back.back.repository.ChatMessageRepository;
import com.back.back.dto.request.chatroom.PostChatroomRequestDto;
import com.back.back.dto.response.chatroom.GetChatroomResponseDto;
import com.back.back.dto.response.chatroom.GetChatroomListResponseDto;
import com.back.back.dto.response.chatmessage.GetChatMessageListResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatroomServiceImplimentation implements ChatroomService {

    private final UserRepository userRepository;
    private final ChatroomRepository chatroomRepository;
    private final ChatMessageRepository chatMessageRepository;

    @Override
    public ResponseEntity<ResponseDto> postChatroom(PostChatroomRequestDto dto, String userId, String roomName) {

        try {
            boolean isExistUser = userRepository.existsById(userId);
            if (!isExistUser)
            return ResponseDto.authenticationFailed();

            UserEntity user = userRepository.findById(userId).orElse(null); 
            if (user == null || !user.getUserRole().equals("ROLE_CUSTOMER")) 
            return ResponseDto.authorizationFailed();

            ChatroomEntity chatroom = new ChatroomEntity(dto.getCustomerId(), dto.getDesignerId(), dto.getRoomName());
            chatroomRepository.save(chatroom);

            return ResponseDto.success();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetChatroomListResponseDto> getChatroomList(String userId) {

        try {
            List<ChatroomEntity> chatroom = chatroomRepository.findByCustomerIdOrDesignerId(userId, userId);
            return GetChatroomListResponseDto.success(chatroom);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.internalServerErrorForChatroomList();
        }
    }
	
    @Override
    public ResponseEntity<? super GetChatroomResponseDto> getChatroom(int roomId) {

        try {
            ChatroomEntity chatroomEntity = chatroomRepository.findByRoomId(roomId);
            if (chatroomEntity == null)
            return ResponseDto.noExistBoard();

            return GetChatroomResponseDto.success(chatroomEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.internalServerErrorForChatroom();
		}
    }

    @Override
    public ResponseEntity<? super GetChatMessageListResponseDto> getChatMessageList(int roomId) {

        try {
            List<ChatMessageEntity> chatMessageEntities = chatMessageRepository.findByChatroomId(roomId);
            return GetChatMessageListResponseDto.success(chatMessageEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.internalServerErrorForChatMessageList();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> deleteChatroom(int roomId, String userId) {

        try {
            chatroomRepository.deleteById(roomId);
            return ResponseDto.success();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

}
