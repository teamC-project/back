package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.auth.EmailAuthCheckRequestDto;
import com.back.back.dto.request.auth.EmailAuthRequestDto;
import com.back.back.dto.request.auth.IdCheckRequestDto;
import com.back.back.dto.request.auth.PasswordFoundRequestDto;
import com.back.back.dto.request.auth.IdFoundRequestDto;
import com.back.back.dto.request.auth.PasswordCheckRequestDto;
import com.back.back.dto.request.auth.PasswordReSetRequestDto;
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
  
  ResponseEntity<ResponseDto> passwordFoundEmailAuth(EmailAuthRequestDto dto);

  ResponseEntity<ResponseDto> passwordFound(@Valid PasswordFoundRequestDto requestBody);

  ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto);

  ResponseEntity<ResponseDto> resetPassword(@Valid PasswordReSetRequestDto requestBody);

  ResponseEntity<ResponseDto> passwordCheck(PasswordCheckRequestDto dto);
}