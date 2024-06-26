package com.back.back.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetFindIdResponseDto extends ResponseDto {

    private String userId;

    private GetFindIdResponseDto(String userId) {
        
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userId = userId;
    }

    public static ResponseEntity<GetFindIdResponseDto> success(String userId) {

        GetFindIdResponseDto responseBody = new GetFindIdResponseDto(userId);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
