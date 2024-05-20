package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.dto.request.customer.PostCustomerBoardCommentRequestDto;
import com.back.back.dto.request.customer.PostCustomerBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.service.CustomerBoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customer_board")
@RequiredArgsConstructor
public class CustomerBoardController {

    private final CustomerBoardService customerBoardService;

    @PostMapping("/")
    ResponseEntity<ResponseDto> postCustomerBoard (
        @RequestBody @Valid PostCustomerBoardRequestDto requestBody,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = customerBoardService.postCustomerBoard(requestBody, userId);
        return response;
    }

    @PostMapping("/{designBoardNumber}/comment")
    public ResponseEntity<ResponseDto> postCustomerBoardComment (
        @RequestBody @Valid PostCustomerBoardCommentRequestDto requestBody,
        @PathVariable("customerBoardNumber") int customerBoardNumber
    ) {
        ResponseEntity<ResponseDto> response = customerBoardService.postCustomerBoardComment(requestBody, customerBoardNumber);
        return response;
    }
}
