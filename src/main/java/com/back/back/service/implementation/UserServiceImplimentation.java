package com.back.back.service.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.back.dto.request.auth.CustomerSignUpRequestDto;
import com.back.back.dto.request.auth.CustomerUpdateRequestDto;
import com.back.back.dto.request.auth.DesignerUpdateRequestDto;
import com.back.back.dto.request.auth.PasswordCheckRequestDto;
import com.back.back.dto.request.auth.PasswordFoundRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.user.GetSignInUserResponseDto;
import com.back.back.entity.UserEntity;
import com.back.back.repository.UserRepository;
import com.back.back.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplimentation implements UserService {

  private final UserRepository userRepository;


  @Override
  public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId) {
    UserEntity userEntity = null;

    try {
      userEntity = userRepository.findByUserId(userId);
      if (userEntity == null) return ResponseDto.authenticationFailed();
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return GetSignInUserResponseDto.success(userEntity);
  }

  @Override
  public ResponseEntity<ResponseDto> customerUpdate(CustomerUpdateRequestDto dto, String userId) {
    try {
      UserEntity userEntity = userRepository.findByUserId(userId);
      if (userEntity == null) return ResponseDto.noExistId();

      userEntity.update(dto);
      userRepository.save(userEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

  @Override
  public ResponseEntity<ResponseDto> designerUpdate(DesignerUpdateRequestDto dto, String userId) {
    try {
      UserEntity userEntity = userRepository.findByUserId(userId);
      if (userEntity == null) return ResponseDto.noExistId();

      userEntity.update(dto);
      userRepository.save(userEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

  @Override
  public ResponseEntity<ResponseDto> deleteUser(String userId) {
    try {
      UserEntity userEntity = userRepository.findByUserId(userId);
      if (userEntity == null) return ResponseDto.noExistId();

      userRepository.delete(userEntity);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }


  @Override
  public ResponseEntity<ResponseDto> passwordCheck(PasswordCheckRequestDto dto) {
    
    try {
      
      String userPassword =dto.getUserPassword();

      boolean existedUserPassword = userRepository.existsByUserPassword(userPassword);
      if (existedUserPassword)
        return ResponseDto.noExistPassword();
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }


}

