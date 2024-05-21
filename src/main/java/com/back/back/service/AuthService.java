package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.auth.EmailAuthCheckRequestDto;
import com.back.back.dto.request.auth.EmailAuthRequestDto;
import com.back.back.dto.request.auth.SignInRequestDto;
import com.back.back.dto.request.auth.CustomerSignUpRequestDto;
import com.back.back.dto.request.auth.DesginerSignUpRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.auth.SignInResponseDto;

public interface AuthService {
    ResponseEntity<? super SignInResponseDto> signIn (SignInRequestDto dto);
    ResponseEntity<ResponseDto> emailAuth (EmailAuthRequestDto dto);
    ResponseEntity<ResponseDto> emailAuthCheck (EmailAuthCheckRequestDto dto);
    ResponseEntity<ResponseDto> signUp (CustomerSignUpRequestDto dto);
    ResponseEntity<ResponseDto> signUp (DesginerSignUpRequestDto dto);
}