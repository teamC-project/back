package com.back.back.service;

import org.springframework.http.ResponseEntity;
import com.back.back.dto.request.auth.CustomerUpdateRequestDto;
import com.back.back.dto.request.auth.DesignerUpdateRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.user.GetSignInUserResponseDto;


public interface UserService {
  ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId);

  ResponseEntity<ResponseDto> deleteUser(String userId);

  ResponseEntity<ResponseDto> customerUpdate(CustomerUpdateRequestDto requestBody, String userId);

  ResponseEntity<ResponseDto> designerUpdate(DesignerUpdateRequestDto requestBody, String userId);
}
