package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.user.CustomerUpdateRequestDto;
import com.back.back.dto.request.user.DesignerUpdateRequestDto;
import com.back.back.dto.request.user.PasswordChangeRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.user.GetSignInUserResponseDto;
import com.back.back.dto.response.user.GetUserRoleResponseDto;


public interface UserService {
  ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId);

  ResponseEntity<ResponseDto> deleteUser(String userId);

  ResponseEntity<ResponseDto> customerUpdate(CustomerUpdateRequestDto requestBody, String userId);

  ResponseEntity<ResponseDto> designerUpdate(DesignerUpdateRequestDto requestBody, String userId);

  ResponseEntity<ResponseDto> passwordChange(PasswordChangeRequestDto dto, String userId);

  ResponseEntity<? super GetUserRoleResponseDto> getUserRole(String userId);

}
