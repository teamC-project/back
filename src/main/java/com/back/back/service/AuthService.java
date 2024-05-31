package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.auth.EmailAuthCheckRequestDto;
import com.back.back.dto.request.auth.EmailAuthRequestDto;
import com.back.back.dto.request.auth.IdCheckRequestDto;
import com.back.back.dto.request.auth.PasswordFoundRequestDto;
import com.back.back.dto.request.auth.IdFoundRequestDto;
import com.back.back.dto.request.auth.PasswordChangeRequestDto;
import com.back.back.dto.request.auth.SignInRequestDto;
import com.back.back.dto.request.auth.CustomerSignUpRequestDto;
import com.back.back.dto.request.auth.DesignerSignUpRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.auth.GetFindIdResponseDto;
import com.back.back.dto.response.auth.SignInResponseDto;

import jakarta.validation.Valid;

public interface AuthService {
  ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);

  ResponseEntity<ResponseDto> emailAuth(EmailAuthRequestDto dto);

  ResponseEntity<ResponseDto> emailAuthCheck(EmailAuthCheckRequestDto dto);

  ResponseEntity<ResponseDto> signUp(CustomerSignUpRequestDto dto);

  ResponseEntity<ResponseDto> signUp(DesignerSignUpRequestDto dto);

  ResponseEntity<ResponseDto> idFoundEmailAuth(EmailAuthRequestDto dto);
  
  ResponseEntity<? super GetFindIdResponseDto> idFound(IdFoundRequestDto dto);

  ResponseEntity<? super GetFindIdResponseDto> passwordFound(@Valid PasswordFoundRequestDto requestBody);

  ResponseEntity<ResponseDto> resetPassword(String email, PasswordChangeRequestDto dto);

  ResponseEntity<ResponseDto> deleteUser(String userId);

  ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto);
}