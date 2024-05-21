package com.back.back.dto.response.user;

import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.entity.UserEntity;

import lombok.Getter;

@Getter
public class GetUserDeleteResponseDto extends ResponseDto {

    private String userId;
    private String userRole;

    private GetUserDeleteResponseDto(UserEntity userEntity) {
        super (ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userId = userEntity.getUserId();
        this.userRole = userEntity.getUserRole();
    }
}