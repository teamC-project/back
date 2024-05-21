package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.dto.request.auth.CustomerSignUpRequestDto;
import com.back.back.dto.request.auth.DesignerSignUpRequestDto;
import com.back.back.dto.request.auth.EmailAuthCheckRequestDto;
import com.back.back.dto.request.auth.EmailAuthRequestDto;
import com.back.back.dto.request.auth.SignInRequestDto;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.auth.SignInResponseDto;
import com.back.back.dto.response.user.DeleteUserDeleteResponseDto;
import com.back.back.dto.response.user.GetInformationUpdateResponseDto;
import com.back.back.service.AuthService;
import com.back.back.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn (
        @RequestBody @Valid SignInRequestDto requestBody
    ) {
        ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }

    @PostMapping("/email-auth")
    public ResponseEntity<ResponseDto> emailAuth (
        @RequestBody @Valid EmailAuthRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response =authService.emailAuth(requestBody);
        return response;
    }

    @PostMapping("/email-auth-check")
    public ResponseEntity<ResponseDto> emailAuthCheck (
        @RequestBody @Valid EmailAuthCheckRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = authService.emailAuthCheck(requestBody);
        return response;
    }

    @PostMapping("/customer-sign-up")
    public ResponseEntity<ResponseDto> signUp (
        @RequestBody @Valid CustomerSignUpRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = authService.signUp(requestBody);
        // System.out.println(requestBody);
        return response;
    }

    @PostMapping("/designer-sign-up")
    public ResponseEntity<ResponseDto> signUp (
        @RequestBody @Valid DesignerSignUpRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = authService.signUp(requestBody);
        return response;
    }

    @DeleteMapping("/")
    public ResponseEntity<? super DeleteUserDeleteResponseDto> getUserDelete (
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<? super DeleteUserDeleteResponseDto> response = userService.getdeleteUser(userId);
        return response;
    }

    @GetMapping("/")
    public ResponseEntity< GetInformationUpdateResponseDto> getUserUpdate (
        
    )

}