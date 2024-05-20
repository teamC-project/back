package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.customer.PostCustomerBoardCommentRequestDto;
import com.back.back.dto.request.customer.PostCustomerBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.customerboard.GetCustomerBoardListResponseDto;
import com.back.back.dto.response.customerboard.GetCustomerBoardResponseDto;
import com.back.back.dto.response.customerboard.GetSearchCustomerBoardListResponseDto;

public interface CustomerBoardService {
    ResponseEntity<ResponseDto> postCustomerBoard(PostCustomerBoardRequestDto dto, String userId);
    ResponseEntity<ResponseDto> postCustomerBoardComment(PostCustomerBoardCommentRequestDto dto, int customerBoardNumber);
    ResponseEntity<? super GetCustomerBoardListResponseDto> getCustomerBoardList();
    ResponseEntity<? super GetSearchCustomerBoardListResponseDto> getSearchCustomerBoardList(String searchWord);
}
