package com.back.back.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.back.dto.request.chatmessage.PostChatmessageRequestDto;
import com.back.back.dto.request.chatroom.PostChatroomRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.chatmessage.GetChatMessageListResponseDto;
import com.back.back.dto.response.chatroom.GetChatroomListResponseDto;
import com.back.back.dto.response.chatroom.GetChatroomResponseDto;
import com.back.back.entity.ChatMessageEntity;
import com.back.back.entity.ChatroomEntity;
import com.back.back.entity.UserEntity;
import com.back.back.repository.ChatMessageRepository;
import com.back.back.repository.ChatroomRepository;
import com.back.back.repository.UserRepository;
import com.back.back.service.ChatroomService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatroomServiceImplimentation implements ChatroomService {
    
    private final ChatroomRepository chatroomRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseDto> postChatroom(PostChatroomRequestDto dto, String userId) {
        
        try {
            
            boolean isExistUser = userRepository.existsById(userId);
            if (!isExistUser)
                return ResponseDto.authenticationFailed();

            UserEntity user = userRepository.findById(userId).orElse(null);
            if (user == null || !user.getUserRole().equals("ROLE_CUSTOMER"))  {
                return ResponseDto.authorizationFailed();
            }

            ChatroomEntity chatroom = new ChatroomEntity(dto.getCustomerId(), dto.getDesignerId());
            chatroomRepository.save(chatroom);

            return ResponseDto.success();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
            }

    }

    @Override
    public ResponseEntity<ResponseDto> postChatMessage(PostChatmessageRequestDto dto, int roomId, String userId) {
        
        try {

            ChatroomEntity chatroom = chatroomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room ID"));

            ChatMessageEntity message = new ChatMessageEntity(chatroom, dto.getSenderId(), dto.getMessage());
            chatMessageRepository.save(message);
            
            return ResponseDto.success();

        } catch(IllegalArgumentException exception) {
                return ResponseDto.invalidRoomIdForChatroom();
                
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
            }

    }

    @Override
    public ResponseEntity<? super GetChatroomListResponseDto> getChatroomList() {
        
        try {

            List<ChatroomEntity> chatroom = chatroomRepository.findAll(); // 목록 가져오기

            List<GetChatroomListResponseDto.ChatroomDto> chatRoomDtos = chatroom.stream() // 각 채팅방 Entity를 Dto로 변환
                .map(chatRoom -> new GetChatroomListResponseDto.ChatroomDto(
                    chatRoom.getRoomId(),
                    chatRoom.getCustomerId(),
                    chatRoom.getDesignerId(),
                    chatRoom.getChatRoomDatetime()
                ))
                .collect(Collectors.toList()); // 변환된 DTO 목록을 리스트로 수집

            GetChatroomListResponseDto responseDto = new GetChatroomListResponseDto(true, chatRoomDtos); // 응답 Dto 생성
            return ResponseEntity.ok(responseDto);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.internalServerErrorForChatroomList();
            }

    }

    @Override
    public ResponseEntity<? super GetChatroomResponseDto> getChatroom(int roomId) {
        
        try {

            ChatroomEntity chatRoom = chatroomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room ID"));

            GetChatroomResponseDto.ChatroomDto chatRoomDto = new GetChatroomResponseDto.ChatroomDto(
                chatRoom.getRoomId(),
                chatRoom.getCustomerId(),
                chatRoom.getDesignerId(),
                chatRoom.getChatRoomDatetime()
            );

            GetChatroomResponseDto responseDto = new GetChatroomResponseDto(true, chatRoomDto);
            return ResponseEntity.ok(responseDto);

        } catch (IllegalArgumentException exception) {
            return ResponseDto.invalidRoomIdForGetChatroom();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.internalServerErrorForChatroom();
        }
    
    }

    @Override
    public ResponseEntity<? super GetChatMessageListResponseDto> getChatMessageList(int roomId) {
        
        try {

            ChatroomEntity chatroom = chatroomRepository.findById(roomId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid room ID"));
            
            List<ChatMessageEntity> messages = chatMessageRepository.findByChatroom(chatroom);

            List<GetChatMessageListResponseDto.ChatMessageDto> messageDtos = messages.stream()
            .map(message -> new GetChatMessageListResponseDto.ChatMessageDto(
                message.getMessageId(),
                message.getSenderId(), 
                message.getMessage(), 
                message.getSendDatetime()
                ))
                .collect(Collectors.toList());

            GetChatMessageListResponseDto responseDto = new GetChatMessageListResponseDto(true, messageDtos);
            return ResponseEntity.ok(responseDto);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.internalServerErrorForChatMessageList();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> deleteChatroom(int roomId) {
        
        try {
            
            chatroomRepository.deleteById(roomId);
                return ResponseDto.success();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

    }

    @Override
    public ResponseEntity<ResponseDto> deleteChatMessage(int roomId, int messageId) {
        
        try {
            
            chatMessageRepository.deleteById(messageId);
                return ResponseDto.success();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

    }
}
