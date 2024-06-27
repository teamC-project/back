package com.back.back.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.back.back.entity.UserEntity;
import com.back.back.service.UserService;
import com.back.back.dto.response.ResponseDto;
import com.back.back.repository.UserRepository;
import com.back.back.dto.response.user.GetUserRoleResponseDto;
import com.back.back.dto.request.user.CustomerUpdateRequestDto;
import com.back.back.dto.request.user.DesignerUpdateRequestDto;
import com.back.back.dto.request.user.PasswordChangeRequestDto;
import com.back.back.dto.response.user.GetSignInUserResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplimentation implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId) {

		UserEntity userEntity = null;

		try {
			userEntity = userRepository.findByUserId(userId);
			if (userEntity == null) 
			return ResponseDto.authenticationFailed();

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
			if (userEntity == null) 
			return ResponseDto.noExistId();

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
			if (userEntity == null) 
			return ResponseDto.noExistId();

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
			if (userEntity == null) 
			return ResponseDto.noExistId();

			userRepository.delete(userEntity);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> passwordChange(PasswordChangeRequestDto dto, String userId) {

		try {
			UserEntity userEntity = userRepository.findByUserId(userId);

			if (userEntity == null) 
			return ResponseDto.noExistId();
			
			String userPassword =dto.getUserPassword();
			String encodedPassword = passwordEncoder.encode(userPassword);
			userEntity.setUserPassword(encodedPassword);
			
			userRepository.save(userEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetUserRoleResponseDto> getUserRole(String userId) {

		try {
			UserEntity userEntity = userRepository.findByUserId(userId);
			if (userEntity == null) 
			return ResponseDto.noExistId();
			return GetUserRoleResponseDto.success(userEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
    }

}

