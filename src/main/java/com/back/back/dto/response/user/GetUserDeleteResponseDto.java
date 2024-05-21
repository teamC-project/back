// package com.back.back.dto.response.user;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import com.back.back.entity.UserEntity;

// import lombok.Getter;

// @Getter
// public class GetUserDeleteResponseDto {

// public static ResponseEntity<GetSignInUserResponseDto> success(UserEntity userEntity) {
//     GetSignInUserResponseDto responseBody = new GetSignInUserResponseDto(userEntity);
//     return ResponseEntity.status(HttpStatus.OK).body(responseBody);
// }

<<<<<<< HEAD
// public static ResponseEntity<GetSignInUserResponseDto> failure() {
//     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
// }
=======
//     private GetUserDeleteResponseDto(UserEntity userEntity) {
//         super (ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
//         this.userId = userEntity.getUserId();
//         this.userRole = userEntity.getUserRole();
//     }
    
//     public static ResponseEntity<GetSignInUserResponseDto> success (UserEntity userEntity){
//         GetSignInUserResponseDto responseBody = new GetUserDeleteResponseDto(userEntity);
//         return ResponseEntity.status(HttpStatus.OK).body(responseBody);
//     }
>>>>>>> 32888d295d2d4df14d779134ce02a5ee28462bc0

//     }