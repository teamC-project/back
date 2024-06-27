package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.customer.PostCustomerBoardCommentRequestDto;
import com.back.back.dto.request.customer.PostCustomerBoardRequestDto;
import com.back.back.dto.request.customer.PutCustomerBoardCommentRequestDto;
import com.back.back.dto.request.customer.PutCustomerBoardRequestDto;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.customerboard.GetCustomerBoardCommentListResponseDto;
import com.back.back.dto.response.customerboard.GetCustomerBoardCommentResponseDto;
import com.back.back.dto.response.customerboard.GetCustomerBoardListResponseDto;
import com.back.back.dto.response.customerboard.GetCustomerBoardResponseDto;
import com.back.back.dto.response.customerboard.GetSearchCustomerBoardListResponseDto;

public interface CustomerBoardService {

    ResponseEntity<ResponseDto> increaseViewCount(int customerBoardNumber);
    ResponseEntity<ResponseDto> deleteCustomerBoard(int customerBoardNumber, String userId);
    ResponseEntity<ResponseDto> postCustomerBoard(PostCustomerBoardRequestDto dto, String userId);
    ResponseEntity<ResponseDto> deleteCustomerBoardComment(int customerBoardCommentNumber, String userId);
    ResponseEntity<ResponseDto> putCustomerBoard(PutCustomerBoardRequestDto dto, int customerBoardNumber, String userId);
    ResponseEntity<ResponseDto> postCustomerBoardComment(PostCustomerBoardCommentRequestDto dto, int customerBoardNumber, String userId);
    ResponseEntity<ResponseDto> putCustomerBoardComment(PutCustomerBoardCommentRequestDto dto, int customerBoardCommentNumber, String userId);
    
    ResponseEntity<? super GetCustomerBoardListResponseDto> getCustomerBoardList();
    ResponseEntity<? super GetSearchCustomerBoardListResponseDto> getSearchCustomerBoardList(String searchWord);
    ResponseEntity<? super GetCustomerBoardResponseDto> getCustomerBoard(int customerBoardNumber, String userId);
    ResponseEntity<? super GetCustomerBoardCommentListResponseDto> getCustomerBoardCommentList(int customerBoardNumber);
    ResponseEntity<? super GetCustomerBoardCommentResponseDto> getCustomerBoardComment(int customerBoardCommentNumber);
    
}
