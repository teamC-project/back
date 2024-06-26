package com.back.back.dto.response.auth;

import com.back.back.entity.UserEntity;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetInformationUpdateResponseDto extends ResponseDto {

    private String userId;
    private String userRole;

    private GetInformationUpdateResponseDto(UserEntity userEntity) {

        super (ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userId = userEntity.getUserId();
        this.userRole = userEntity.getUserRole();
    }

}
