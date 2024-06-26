package com.back.back.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class SignInResponseDto extends ResponseDto {
    
    private String accessToken;
    private int expires;

    private SignInResponseDto(String accessToken) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.accessToken = accessToken;
        this.expires = 60 * 60;
    }

    public static ResponseEntity<SignInResponseDto> success(String accessToken) {
        SignInResponseDto responseBody = new SignInResponseDto(accessToken);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}