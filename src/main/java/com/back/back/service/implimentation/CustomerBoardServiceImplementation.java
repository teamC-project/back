package com.back.back.service.implimentation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.back.dto.request.customer.PostCustomerBoardCommentRequestDto;
import com.back.back.dto.request.customer.PostCustomerBoardRequestDto;
import com.back.back.dto.request.customer.PutCustomerBoardCommentRequestDto;
import com.back.back.dto.request.customer.PutCustomerBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.customerboard.GetCustomerBoardListResponseDto;
import com.back.back.dto.response.customerboard.GetCustomerBoardResponseDto;
import com.back.back.dto.response.customerboard.GetSearchCustomerBoardListResponseDto;
import com.back.back.entity.CustomerBoardCommentEntity;
import com.back.back.entity.CustomerBoardEntity;
import com.back.back.repository.CustomerBoardCommentRepository;
import com.back.back.repository.CustomerBoardRepository;
import com.back.back.repository.UserRepository;
import com.back.back.service.CustomerBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerBoardServiceImplementation implements CustomerBoardService {

    private final CustomerBoardRepository customerBoardRepository;
    private final CustomerBoardCommentRepository customerBoardCommentRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseDto> postCustomerBoard(PostCustomerBoardRequestDto dto, String userId) {
        
        try {

            boolean isExistUser = userRepository.existsById(userId);
            if (!isExistUser) return ResponseDto.authenticationFailed();

            CustomerBoardEntity customerBoardEntity = new CustomerBoardEntity(dto, userId);
            customerBoardRepository.save(customerBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }

    @Override
    public ResponseEntity<ResponseDto> postCustomerBoardComment(PostCustomerBoardCommentRequestDto dto, int customerBoardNumber, String userId) {
        
        try {

            boolean isExistUser = userRepository.existsById(userId);
            if (!isExistUser) return ResponseDto.authenticationFailed();

            CustomerBoardCommentEntity customerBoardCommentEntity = new CustomerBoardCommentEntity(dto, userId);
            customerBoardCommentRepository.save(customerBoardCommentEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }

    @Override
    public ResponseEntity<? super GetCustomerBoardListResponseDto> getCustomerBoardList() {
        
        try {

            List<CustomerBoardEntity> customerBoardEntities = customerBoardRepository.findByOrderByCustomerBoardNumberDesc();
            return GetCustomerBoardListResponseDto.success(customerBoardEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

    }

    @Override
    public ResponseEntity<? super GetSearchCustomerBoardListResponseDto> getSearchCustomerBoardList(String searchWord) {
        
        try {

            List<CustomerBoardEntity> customerBoardEntities = customerBoardRepository.findByCustomerBoardTitleOrCustomerBoardContentsOrderByCustomerBoardNumberDesc(searchWord, searchWord);
            return GetSearchCustomerBoardListResponseDto.success(customerBoardEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
    }

    @Override
    public ResponseEntity<? super GetCustomerBoardResponseDto> getCustomerBoard(int customerBoardNumber) {
        
        try {

            CustomerBoardEntity customerBoardEntity = customerBoardRepository.findByCustomerBoardNumber(customerBoardNumber);
            if (customerBoardEntity == null) return ResponseDto.noExistBoard();

            return GetCustomerBoardResponseDto.success(customerBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

    }

    @Override
    public ResponseEntity<ResponseDto> putCustomerBoard(PutCustomerBoardRequestDto dto, int customerBoardNumber, String userId) {
        
        try {

            CustomerBoardEntity customerBoardEntity =  customerBoardRepository.findByCustomerBoardNumber(customerBoardNumber);
            if (customerBoardEntity == null) return ResponseDto.noExistBoard();

            String writerId = customerBoardEntity.getCustomerBoardWriterId();
            boolean isWriter = userId.equals(writerId);
            if (!isWriter) return ResponseDto.authorizationFailed();

            customerBoardEntity.update(dto);
            customerBoardRepository.save(customerBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }

    @Override
    public ResponseEntity<ResponseDto> putCustomerBoardComment(PutCustomerBoardCommentRequestDto dto, int customerBoardCommentNumber, String userId) {
        
        try {

            CustomerBoardCommentEntity customerBoardCommentEntity = customerBoardCommentRepository.findByCustomerBoardCommentNumber(customerBoardCommentNumber);
            if (customerBoardCommentEntity == null) return ResponseDto.noExistBoard();

            String writerId = customerBoardCommentEntity.getCustomerBoardCommentWriterId();
            boolean isWriter = userId.equals(writerId);
            if (!isWriter) return ResponseDto.authorizationFailed();

            customerBoardCommentEntity.update(dto);
            customerBoardCommentRepository.save(customerBoardCommentEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }


    @Override
    public ResponseEntity<ResponseDto> deleteCustomerBoard(int customerBoardNumber, String userId) {
        
        try {

            CustomerBoardEntity customerBoardEntity = customerBoardRepository.findByCustomerBoardNumber(customerBoardNumber);
            if (customerBoardEntity == null) return ResponseDto.noExistBoard();

            String writerId = customerBoardEntity.getCustomerBoardWriterId();
            boolean isWriter = userId.equals(writerId);
            if (!isWriter) return ResponseDto.authorizationFailed();

            customerBoardRepository.delete(customerBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }

    @Override
    public ResponseEntity<ResponseDto> deleteCustomerBoardComment(int customerBoardCommentNumber, String userId) {
        
        try {

            CustomerBoardCommentEntity customerBoardCommentEntity = 
            customerBoardCommentRepository.findByCustomerBoardCommentNumber(customerBoardCommentNumber);
            if (customerBoardCommentEntity == null) return ResponseDto.noExistBoard();

            String writerId = customerBoardCommentEntity.getCustomerBoardCommentWriterId();
            boolean isWriter = userId.equals(writerId);
            if (!isWriter) return ResponseDto.authorizationFailed();

            customerBoardCommentRepository.delete(customerBoardCommentEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }

    @Override
    public ResponseEntity<ResponseDto> increaseViewCount(int customerBoardNumber) {
        
        try {

            CustomerBoardEntity customerBoardEntity = customerBoardRepository.findByCustomerBoardNumber(customerBoardNumber);
            if (customerBoardEntity == null) return ResponseDto.noExistBoard();

            customerBoardEntity.increaseViewCount();
            customerBoardRepository.save(customerBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();

    }
    
}