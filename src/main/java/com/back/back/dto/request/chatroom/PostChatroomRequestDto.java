package com.back.back.dto.request.chatroom;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostChatroomRequestDto {

    @NotBlank
    private String customerId;

    @NotBlank
    private String designerId;

    @NotBlank
    private String roomName;
    
}