package com.back.back.service.implimentation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.back.dto.request.customer.PostCustomerBoardCommentRequestDto;
import com.back.back.dto.request.customer.PostCustomerBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.repository.CustomerBoardRepository;
import com.back.back.service.CustomerBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerBoardServiceImplementation implements CustomerBoardService {

    private final CustomerBoardRepository customerBoardRepository;

    @Override
    public ResponseEntity<ResponseDto> postCustomerBoard(PostCustomerBoardRequestDto dto, String userId) {
        
        try {

            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postCustomerBoardComment(PostCustomerBoardCommentRequestDto dto, int customerBoardNumber) {
        
        try {
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }
    
}
