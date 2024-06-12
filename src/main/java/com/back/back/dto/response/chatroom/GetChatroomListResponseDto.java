package com.back.back.dto.response.chatroom;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetChatroomListResponseDto {
    
    private boolean success;
    private List<ChatroomDto> chatRooms;

}
