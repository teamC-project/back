package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.dto.request.auth.CustomerSignUpRequestDto;
import com.back.back.dto.request.auth.DesignerSignUpRequestDto;
import com.back.back.dto.request.auth.EmailAuthCheckRequestDto;
import com.back.back.dto.request.auth.EmailAuthRequestDto;
import com.back.back.dto.request.auth.IdFoundRequestDto;
import com.back.back.dto.request.auth.PasswordFoundRequestDto;
import com.back.back.dto.request.auth.SignInRequestDto;
import com.back.back.dto.request.user.CustomerUpdateRequestDto;
import com.back.back.dto.request.user.DesginerUpdateRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.auth.GetFindIdResponseDto;
import com.back.back.dto.response.auth.GetFindPasswordResponseDto;
import com.back.back.dto.response.auth.SignInResponseDto;
import com.back.back.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/sign-in")
  public ResponseEntity<? super SignInResponseDto> signIn(
      @RequestBody @Valid SignInRequestDto requestBody) {
    ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
    return response;
  }

  @PostMapping("/email-auth")
  public ResponseEntity<ResponseDto> emailAuth(
      @RequestBody @Valid EmailAuthRequestDto requestBody) {
    ResponseEntity<ResponseDto> response = authService.emailAuth(requestBody);
    return response;
  }

  @PostMapping("/email-auth-check")
  public ResponseEntity<ResponseDto> emailAuthCheck(
      @RequestBody @Valid EmailAuthCheckRequestDto requestBody) {
    ResponseEntity<ResponseDto> response = authService.emailAuthCheck(requestBody);
    return response;
  }

  @PostMapping("/customer-sign-up")
  public ResponseEntity<ResponseDto> signUp(
      @RequestBody @Valid CustomerSignUpRequestDto requestBody) {
    ResponseEntity<ResponseDto> response = authService.signUp(requestBody);
    return response;
  }

  @PostMapping("/designer-sign-up")
  public ResponseEntity<ResponseDto> signUp(
      @RequestBody @Valid DesignerSignUpRequestDto requestBody) {
    ResponseEntity<ResponseDto> response = authService.signUp(requestBody);
    return response;
  }

  @DeleteMapping("/")
  public ResponseEntity<ResponseDto> deleteUser(
      @AuthenticationPrincipal String userId) {
    ResponseEntity<ResponseDto> response = authService.deleteUser(userId);
    return response;
  }

  @PostMapping("/id-found")
  public ResponseEntity<? super GetFindIdResponseDto> idFound(
      @RequestBody @Valid IdFoundRequestDto requestBody) {
    ResponseEntity<? super GetFindIdResponseDto> response = authService.idFound(requestBody);
    return response;
  }

  @PostMapping("/password-found")
  public ResponseEntity<? super GetFindPasswordResponseDto> passwordFound(
      @RequestBody @Valid PasswordFoundRequestDto requestBody) {
    ResponseEntity<? super GetFindPasswordResponseDto> response = authService.passwordFound(requestBody);
    return response;
  }

  @PostMapping("/customer-update")
  public ResponseEntity<ResponseDto> customerUpdate(
      @RequestBody @Valid CustomerUpdateRequestDto requestBody) {
    ResponseEntity<ResponseDto> response = authService.customerUpdate(requestBody);
    return response;
  }

  @PostMapping("/desginer-update")
  public ResponseEntity<ResponseDto> desginerUpdate(
      @RequestBody @Valid DesginerUpdateRequestDto requestBody) {
    ResponseEntity<ResponseDto> response = authService.desginerUpdate(requestBody);
    return response;
  }

}
