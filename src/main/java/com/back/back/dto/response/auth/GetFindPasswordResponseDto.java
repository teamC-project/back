// package com.back.back.dto.response.auth;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import com.back.back.dto.response.ResponseCode;
// import com.back.back.dto.response.ResponseDto;
// import com.back.back.dto.response.ResponseMessage;
// import com.back.back.entity.UserEntity;

// import lombok.Getter;

// @Getter
// public class GetFindPasswordResponseDto extends ResponseDto {
//   private String userPassword;

//   private GetFindPasswordResponseDto(UserEntity userEntity) {
//     super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
//     this.userPassword = userEntity.getUserPassword();
//   }

//     public static ResponseEntity<GetFindPasswordResponseDto> success(String resetPassword) {
//       GetFindPasswordResponseDto responseBody = new GetFindPasswordResponseDto(resetPassword);
//     return ResponseEntity.status(HttpStatus.OK).body(responseBody);
//   }
// }
