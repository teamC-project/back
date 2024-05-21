// package com.back.back.controller;

<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.dto.response.user.DeleteUserDeleteResponseDto;
import com.back.back.service.UserService;
=======
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.back.back.dto.response.user.GetSignInUserResponseDto;
// import com.back.back.service.UserService;
>>>>>>> 46d127bca4f7792c7ccf748287f2c28b8df1d82b

// import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("/api/v1/user")
// @RequiredArgsConstructor
// public class UserController {

//   private final UserService userService;

<<<<<<< HEAD
  @GetMapping("/api/v1/auth/user_delete")
  public ResponseEntity<? super DeleteUserDeleteResponseDto> getUserDelete (
    @AuthenticationPrincipal String userId
  ) {
    ResponseEntity<? super DeleteUserDeleteResponseDto> response = userService(userId);
    return response;
  }

}
=======
//   @GetMapping("/")
//   public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser (
//       @AuthenticationPrincipal String userId 
//   ) {
//       ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(userId);
//       return response;
//   }

//   @DeleteMapping("/")
//   public ResponseEntity<?> getUserDelete (
//     @AuthenticationPrincipal String userId
//   ) {
//     ResponseEntity<?> response = userService.
//   }

// }
>>>>>>> 46d127bca4f7792c7ccf748287f2c28b8df1d82b
