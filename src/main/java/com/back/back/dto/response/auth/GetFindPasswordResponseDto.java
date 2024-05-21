package com.back.back.dto.response.auth;

import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.entity.UserEntity;

import lombok.Getter;

@Getter
public class GetFindPasswordResponseDto extends ResponseDto {
  private String userPassword;

  private GetFindPasswordResponseDto(UserEntity userEntity) {
    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    this.userPassword = userEntity.getUserPassword();
  }
}
