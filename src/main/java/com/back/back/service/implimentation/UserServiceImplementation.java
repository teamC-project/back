package com.back.back.service.implimentation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.back.dto.response.ResponseDto;
import com.back.back.entity.UserEntity;
import com.back.back.repository.UserRepository;
import com.back.back.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

  private final UserRepository userRepository;

  @Override
  public ResponseEntity<ResponseDto> deleteUser(String userId) {

    try {
      UserEntity userEntity = userRepository.findByUserId(userId);
      if (userEntity == null) return ResponseDto.authorizationFailed();

      userRepository.delete(userEntity);
    
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

<<<<<<< HEAD
=======
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

>>>>>>> 31c1e4bda90c87aa823e5ed244f076a33cc7cf35
}
