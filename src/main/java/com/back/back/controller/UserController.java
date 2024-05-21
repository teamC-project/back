package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.dto.response.user.DeleteUserDeleteResponseDto;
import com.back.back.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/api/v1/auth/user_delete")
  public ResponseEntity<? super DeleteUserDeleteResponseDto> getUserDelete (
    @AuthenticationPrincipal String userId
  ) {
    ResponseEntity<? super DeleteUserDeleteResponseDto> response = userService(userId);
    return response;
  }

}
