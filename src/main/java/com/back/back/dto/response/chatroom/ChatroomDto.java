package com.back.back.dto.response.chatroom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatroomDto {
    private Integer roomId;
    private String customerId;
    private String designerId;
    private String chatroomDatetime;
}
