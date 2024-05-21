package com.back.back.service.implimentation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.user.GetUserDeleteResponseDto;
import com.back.back.entity.UserEntity;
import com.back.back.repository.UserRepository;
import com.back.back.service.UserDeleteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDeleteServiceImplementation implements UserDeleteService {

  private final UserRepository userRepository;

  @Override
  public ResponseEntity<? super GetUserDeleteResponseDto> deleteUser(String userId) {

    try {
      UserEntity userEntity = userRepository.findBySnsId(userId);
      if (userEntity == null) return ResponseDto.IdNonexistent();

      userRepository.save(userEntity);
    
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success();
  }
}
