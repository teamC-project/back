package com.back.back.service.implimentation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.user.DeleteUserDeleteResponseDto;
import com.back.back.entity.UserEntity;
import com.back.back.repository.UserRepository;
import com.back.back.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

  private final UserRepository userRepository;

  @Override
  public ResponseEntity<? super DeleteUserDeleteResponseDto> getdeleteUser(String userId) {
    try {
      UserEntity userEntity = userRepository.findBySnsId(userId);
      if (userEntity == null) return ResponseDto.authorizationFailed();

      userRepository.save(userEntity);
    
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

  @Override
  public ResponseEntity<GetInformationUpdateResponseDto> getUpdateUser(String userId) {
    try{
      UserEntity userEntity = userRepository.findByUserId(userId);
      // if (userEntity == null) return ResponseDto.

      // userRepository.save(userEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      // return ResponseDto.databaseError();
    }

    // return ResponseDto.success();
		return null;
  }

}
