package com.back.back.dto.response.chatroom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetChatroomResponseDto {

    private boolean success;
    private ChatroomDto chatroom;
}
