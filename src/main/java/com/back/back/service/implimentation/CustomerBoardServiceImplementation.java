package com.back.back.service.implimentation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.back.dto.request.customer.PostCustomerBoardCommentRequestDto;
import com.back.back.dto.request.customer.PostCustomerBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.repository.CustomerBoardRepository;
import com.back.back.service.CustomerBoardService;
import com.back.back.dto.response.customerboard.GetCustomerBoardListResponseDto;
import com.back.back.dto.response.customerboard.GetCustomerBoardResponseDto;
import com.back.back.dto.response.customerboard.GetSearchCustomerBoardListResponseDto;
import com.back.back.entity.CustomerBoardEntity;

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

    @Override
    public ResponseEntity<? super GetCustomerBoardListResponseDto> getCustomerBoardList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomerBoardList'");
    }

    @Override
    public ResponseEntity<? super GetSearchCustomerBoardListResponseDto> getSearchCustomerBoardList(String searchWord) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSearchCustomerBoardList'");
    }
    @Override
    public  ResponseEntity<? super GetCustomerBoardListResponseDto> getCustomerBoard(int customerBoardNumber)   {
        try{

            CustomerBoardEntity customerBoardEntity = customerBoardRepository.findByOrdreByCustomerBoardNumberDesc(customerBoardNumber);
            if (customerBoardEntity == null) return ResponseDto.noExistBoard();

            return GetCustomerBoardResponseDto.success(customerBoardEntity);


        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
    
        }

    }

    
}
