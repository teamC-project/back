package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.dto.response.user.GetUserDeleteResponseDto;
import com.back.back.service.UserDeleteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth/user_delete")
@RequiredArgsConstructor
public class UserDeleteController {

  private final UserDeleteService userDeleteService;

  @GetMapping("/")
  public ResponseEntity<? super GetUserDeleteResponseDto> getUserDelete (
    @AuthenticationPrincipal String userId
  ) {
    ResponseEntity<? super GetUserDeleteResponseDto> response = userDeleteService.getdeleteUser(userId);
    return response;
  }
}
