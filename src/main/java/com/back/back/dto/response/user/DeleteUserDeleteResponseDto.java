package com.back.back.dto.response.user;

import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.entity.UserEntity;

import lombok.Getter;

@Getter
public class DeleteUserDeleteResponseDto extends ResponseDto {

    private String userId;

    private DeleteUserDeleteResponseDto(UserEntity userEntity) {
        super (ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userId = userEntity.getUserId();
    }
}