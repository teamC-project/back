package com.back.back.dto.request.chatroom;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostChatroomRequestDto {

    @NotBlank(message = "Customer ID is required")
    private String customerId;

    @NotBlank(message = "Designer ID is required")
    private String designerId;

    @NotBlank
    private String roomName;
    
}