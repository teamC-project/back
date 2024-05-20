package com.back.back.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.entity.UserEntity;

import lombok.Getter;

@Getter
public class GetUserDeleteResponseDto {

public static ResponseEntity<GetSignInUserResponseDto> success(UserEntity userEntity) {
    GetSignInUserResponseDto responseBody = new GetSignInUserResponseDto(userEntity);
    return ResponseEntity.status(HttpStatus.OK).body(responseBody);
}

public static ResponseEntity<GetSignInUserResponseDto> failure() {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
}

    }