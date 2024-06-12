package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.back.back.dto.request.auth.CustomerUpdateRequestDto;
import com.back.back.dto.request.auth.DesignerUpdateRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.user.GetSignInUserResponseDto;
import com.back.back.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/")
  public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
      @AuthenticationPrincipal String userId) {
    ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(userId);
    return response;
  }

  @DeleteMapping("/user-delete")
  public ResponseEntity<ResponseDto> deleteUser(
      @AuthenticationPrincipal String userId) {
    ResponseEntity<ResponseDto> response = userService.deleteUser(userId);
    return response;
  }

  @PostMapping("/customer-update")
  public ResponseEntity<ResponseDto> customerUpdate(
      @RequestBody @Valid CustomerUpdateRequestDto requestBody,
      @AuthenticationPrincipal String userId) {
    ResponseEntity<ResponseDto> response = userService.customerUpdate(requestBody, userId);
    return response;
  }

  @PostMapping("/designer-update")
  public ResponseEntity<ResponseDto> designerUpdate(
      @RequestBody @Valid DesignerUpdateRequestDto requestBody,
      @AuthenticationPrincipal String userId) {
    ResponseEntity<ResponseDto> response = userService.designerUpdate(requestBody, userId);
    return response;
  }

}
