package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.back.back.service.UserService;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.user.GetUserRoleResponseDto;
import com.back.back.dto.request.user.CustomerUpdateRequestDto;
import com.back.back.dto.request.user.DesignerUpdateRequestDto;
import com.back.back.dto.request.user.PasswordChangeRequestDto;
import com.back.back.dto.response.user.GetSignInUserResponseDto;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(userId);
        return response;
    }

    @GetMapping("/role/{userId}")
    public ResponseEntity<? super GetUserRoleResponseDto> getUserRole (
        @PathVariable String userId
        ) {
            ResponseEntity<? super GetUserRoleResponseDto> response = userService.getUserRole(userId);
        return response;
    }

    @PutMapping("/customer-update")
    public ResponseEntity<ResponseDto> customerUpdate(
        @RequestBody @Valid CustomerUpdateRequestDto requestBody,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = userService.customerUpdate(requestBody, userId);
        return response;
    }

    @PutMapping("/designer-update")
    public ResponseEntity<ResponseDto> designerUpdate(
        @RequestBody @Valid DesignerUpdateRequestDto requestBody,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = userService.designerUpdate(requestBody, userId);
        return response;
    }

    @PutMapping("/change-user-password")
    public ResponseEntity<ResponseDto> passwordCheck(
        @RequestBody @Valid PasswordChangeRequestDto requestBody,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = userService.passwordChange(requestBody, userId);
        return response;
    }

    @DeleteMapping("/user-delete")
    public ResponseEntity<ResponseDto> deleteUser(
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = userService.deleteUser(userId);
        return response;
    }

}