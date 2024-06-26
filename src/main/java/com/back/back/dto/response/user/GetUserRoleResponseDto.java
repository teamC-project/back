package com.back.back.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.entity.UserEntity;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetUserRoleResponseDto extends ResponseDto {

    private String userId;
    private String userRole;

    private GetUserRoleResponseDto(UserEntity userEntity) {
        
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userId = userEntity.getUserId();
        this.userRole = userEntity.getUserRole();
    }

    public static ResponseEntity<GetUserRoleResponseDto> success (UserEntity userEntity) throws Exception {

        GetUserRoleResponseDto responseBody = new GetUserRoleResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
