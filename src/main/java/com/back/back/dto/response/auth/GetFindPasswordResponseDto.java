package com.back.back.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetFindPasswordResponseDto extends ResponseDto {

    private String userPassword;

    private GetFindPasswordResponseDto(String userPassword) {
        
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userPassword = userPassword;
    }

    public static ResponseEntity<GetFindPasswordResponseDto> success(String userPassword) {

        GetFindPasswordResponseDto responseBody = new GetFindPasswordResponseDto(userPassword);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
