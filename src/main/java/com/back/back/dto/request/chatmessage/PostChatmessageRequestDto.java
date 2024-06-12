package com.back.back.dto.request.chatmessage;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class    PostChatmessageRequestDto {
    
    @NotBlank
    private String senderId;

    @NotBlank
    private String message;
}
