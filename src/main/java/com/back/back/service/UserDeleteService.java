package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.user.GetSignInUserResponseDto;

public interface UserDeleteService {
  
  RepositoryEntity<? super GetSignInUserResponseDto> getUserDelete (String userId);
}
