package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.user.CustomerUpdateRequestDto;
import com.back.back.dto.request.user.DesignerUpdateRequestDto;
import com.back.back.dto.request.user.PasswordChangeRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.user.GetSignInUserResponseDto;
import com.back.back.dto.response.user.GetUserRoleResponseDto;

public interface UserService {

<<<<<<< HEAD
  ResponseEntity<ResponseDto> deleteUser(String userId);

  ResponseEntity<ResponseDto> customerUpdate(CustomerUpdateRequestDto requestBody, String userId);

  ResponseEntity<ResponseDto> designerUpdate(DesignerUpdateRequestDto requestBody, String userId);

  ResponseEntity<ResponseDto> passwordChange(PasswordChangeRequestDto requestBody, String userId);

  ResponseEntity<? super GetUserRoleResponseDto> getUserRole(String userId);
=======
    ResponseEntity<ResponseDto> deleteUser(String userId);
    ResponseEntity<ResponseDto> customerUpdate(CustomerUpdateRequestDto dto, String userId);
    ResponseEntity<ResponseDto> designerUpdate(DesignerUpdateRequestDto dto, String userId);
    ResponseEntity<ResponseDto> passwordChange(PasswordChangeRequestDto dto, String userId);
    
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId);
    ResponseEntity<? super GetUserRoleResponseDto> getUserRole(String userId);
>>>>>>> 2aa9870673635b7543d476b45066f2d7d60f70d1

}
