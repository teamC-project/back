package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.user.GetUserDeleteResponseDto;

public interface UserDeleteService {
  ResponseEntity<? super GetUserDeleteResponseDto> getdeleteUser(String userId);
}

