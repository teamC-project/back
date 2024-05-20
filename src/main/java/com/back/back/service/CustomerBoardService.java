package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.customer.PostCustomerBoardCommentRequestDto;
import com.back.back.dto.request.customer.PostCustomerBoardRequestDto;
import com.back.back.dto.response.ResponseDto;

public interface CustomerBoardService {
    ResponseEntity<ResponseDto> postCustomerBoard(PostCustomerBoardRequestDto dto, String userId);
    ResponseEntity<ResponseDto> postCustomerBoardComment(PostCustomerBoardCommentRequestDto dto, int customerBoardNumber);
}
