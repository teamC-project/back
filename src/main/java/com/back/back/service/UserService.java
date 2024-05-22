package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;

public interface UserService {

    ResponseEntity<ResponseDto> deleteUser(String userId);

}
