package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.back.back.dto.response.ResponseDto;
import com.back.back.service.CustomerBoardService;
import com.back.back.dto.request.customer.PutCustomerBoardRequestDto;
import com.back.back.dto.request.customer.PostCustomerBoardRequestDto;
import com.back.back.dto.request.customer.PutCustomerBoardCommentRequestDto;
import com.back.back.dto.response.customerboard.GetCustomerBoardResponseDto;
import com.back.back.dto.request.customer.PostCustomerBoardCommentRequestDto;
import com.back.back.dto.response.customerboard.GetCustomerBoardListResponseDto;
import com.back.back.dto.response.customerboard.GetSearchCustomerBoardListResponseDto;
import com.back.back.dto.response.customerboard.GetCustomerBoardCommentListResponseDto;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customer_board")
@RequiredArgsConstructor
public class CustomerBoardController {

    private final CustomerBoardService customerBoardService;

    @GetMapping("/list")
    public ResponseEntity<? super GetCustomerBoardListResponseDto> getCustomerBoardList(
        ) {
            ResponseEntity<? super GetCustomerBoardListResponseDto> response = customerBoardService.getCustomerBoardList();
        return response;
    }

    @GetMapping("/list/search")
    public ResponseEntity<? super GetSearchCustomerBoardListResponseDto> getSearchDesingerBoardList(
        @RequestParam("word") String word
        ) {
            ResponseEntity<? super GetSearchCustomerBoardListResponseDto> response = customerBoardService.getSearchCustomerBoardList(word);
        return response;
    }

    @GetMapping("/{customerBoardNumber}")
    public ResponseEntity<? super GetCustomerBoardResponseDto> getCustomerBoard(
        @PathVariable("customerBoardNumber") int customerBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity <? super GetCustomerBoardResponseDto> response = customerBoardService.getCustomerBoard(customerBoardNumber, userId);
        return response;
    }

    @GetMapping("/{customerBoardNumber}/comment/list")
    public ResponseEntity<? super GetCustomerBoardCommentListResponseDto> getCustomerBoardCommentList(
        @PathVariable("customerBoardNumber") int customerBoardNumber
        ) {
            ResponseEntity<? super GetCustomerBoardCommentListResponseDto> response = customerBoardService.getCustomerBoardCommentList(customerBoardNumber);
        return response;
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDto> postCustomerBoard (
        @RequestBody @Valid PostCustomerBoardRequestDto requestBody,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = customerBoardService.postCustomerBoard(requestBody, userId);
        return response;
    }

    @PostMapping("/{customerBoardNumber}/comment")
    public ResponseEntity<ResponseDto> postCustomerBoardComment (
        @RequestBody @Valid PostCustomerBoardCommentRequestDto requestBody,
        @PathVariable("customerBoardNumber") int customerBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = customerBoardService.postCustomerBoardComment(requestBody, customerBoardNumber, userId);
        return response;
    }

    @PutMapping("/{customerBoardNumber}")
    public ResponseEntity<ResponseDto> putCustomerBoard (
        @RequestBody @Valid PutCustomerBoardRequestDto requestBody,
        @PathVariable("customerBoardNumber") int customerBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = customerBoardService.putCustomerBoard(requestBody, customerBoardNumber, userId);
        return response;
    }

    @PutMapping("/{customerBoardCommentNumber}/comment")
    public ResponseEntity<ResponseDto> putCustomerBoardComment (
        @RequestBody @Valid PutCustomerBoardCommentRequestDto requestBody,
        @PathVariable("customerBoardCommentNumber") int customerBoardCommentNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = customerBoardService.putCustomerBoardComment(requestBody, customerBoardCommentNumber, userId);
        return response;
    }

    @PatchMapping("/{customerBoardNumber}/increase-view-count")
    public ResponseEntity<ResponseDto> increaseViewCount (
        @PathVariable("customerBoardNumber") int customerBoardNumber
        ) {
            ResponseEntity<ResponseDto> response = customerBoardService.increaseViewCount(customerBoardNumber);
        return response;
    }

    @DeleteMapping("/{customerBoardNumber}")
    public ResponseEntity<ResponseDto> deleteCustomerBoard (
        @PathVariable("customerBoardNumber") int customerBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response =  customerBoardService.deleteCustomerBoard(customerBoardNumber, userId);
        return response;
    }

    @DeleteMapping("/{customerBoardCommentNumber}/comment")
    public ResponseEntity<ResponseDto> deleteCustomerBoardComment (
        @PathVariable("customerBoardCommentNumber") int customerBoardCommentNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response =  customerBoardService.deleteCustomerBoardComment(customerBoardCommentNumber, userId);
        return response;
    }

}