package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.user.DeleteUserDeleteResponseDto;

public interface UserService {

    ResponseEntity<? super DeleteUserDeleteResponseDto> getdeleteUser(String userId);
}
