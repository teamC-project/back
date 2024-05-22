package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.auth.EmailAuthCheckRequestDto;
import com.back.back.dto.request.auth.EmailAuthRequestDto;
import com.back.back.dto.request.auth.PasswordFoundRequestDto;
import com.back.back.dto.request.auth.IdFoundRequestDto;
import com.back.back.dto.request.auth.SignInRequestDto;
import com.back.back.dto.request.user.CustomerUpdateRequestDto;
import com.back.back.dto.request.user.DesginerUpdateRequestDto;
import com.back.back.dto.request.auth.CustomerSignUpRequestDto;
import com.back.back.dto.request.auth.DesignerSignUpRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.auth.GetFindIdResponseDto;
import com.back.back.dto.response.auth.GetFindPasswordResponseDto;
import com.back.back.dto.response.auth.SignInResponseDto;

public interface AuthService {
    ResponseEntity<? super SignInResponseDto> signIn (SignInRequestDto dto);
    ResponseEntity<ResponseDto> emailAuth (EmailAuthRequestDto dto);
    ResponseEntity<ResponseDto> emailAuthCheck (EmailAuthCheckRequestDto dto);
    ResponseEntity<ResponseDto> signUp (CustomerSignUpRequestDto dto);
    ResponseEntity<ResponseDto> signUp (DesignerSignUpRequestDto dto);
    
    ResponseEntity<? super GetFindIdResponseDto> idFound (IdFoundRequestDto dto);
    ResponseEntity<? super GetFindPasswordResponseDto> findPassword (PasswordFoundRequestDto dto);

    ResponseEntity<ResponseDto> deleteUser(String userId);

    ResponseEntity<ResponseDto> customerUpdate(CustomerUpdateRequestDto dto);
    ResponseEntity<ResponseDto> desginerUpdate(DesginerUpdateRequestDto dto);
}