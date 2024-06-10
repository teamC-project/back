package com.back.back.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.back.dto.request.auth.CustomerUpdateRequestDto;
import com.back.back.dto.request.auth.DesignerUpdateRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.user.GetSignInUserResponseDto;

@Service
public interface UserService {
  
  ResponseEntity<? super GetSignInUserResponseDto> getSignInUser (String userId);

  ResponseEntity<ResponseDto> deleteUser(String userId);

  ResponseEntity<ResponseDto> customerUpdate(CustomerUpdateRequestDto dto);

  ResponseEntity<ResponseDto> designerUpdate(DesignerUpdateRequestDto dto);
}

