package com.back.back.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
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
import com.back.back.entity.CustomerBoardCommentEntity;
import com.back.back.entity.CustomerBoardEntity;
import com.back.back.entity.UserEntity;
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
            if (!isExistUser) 
            return ResponseDto.authenticationFailed();
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
            if (!isExistUser) 
            return ResponseDto.authenticationFailed();
            Optional<CustomerBoardEntity> customerBoardOptional = customerBoardRepository.findById(customerBoardNumber);

            if (!customerBoardOptional.isPresent())
            return ResponseDto.noExistBoard();
            CustomerBoardCommentEntity customerBoardCommentEntity;

            if (dto.getCustomerBoardParentCommentNumber() != null) {
                Optional<CustomerBoardCommentEntity> parentCommentOptional = customerBoardCommentRepository.findById(dto.getCustomerBoardParentCommentNumber());
                if (!parentCommentOptional.isPresent()) 
                return ResponseDto.noExistBoard();
                customerBoardCommentEntity = new CustomerBoardCommentEntity(dto, customerBoardNumber, userId, dto.getCustomerBoardParentCommentNumber());
            } else {
                customerBoardCommentEntity = new CustomerBoardCommentEntity(dto, customerBoardNumber, userId, null); 
            }

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
    public ResponseEntity<? super GetSearchCustomerBoardListResponseDto> getSearchCustomerBoardList(String customersearchWord) {

        try {
            List<CustomerBoardEntity> customerBoardEntities = customerBoardRepository.findByCustomerBoardTitleContainsOrderByCustomerBoardNumberDesc(customersearchWord);
            return GetSearchCustomerBoardListResponseDto.success(customerBoardEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetCustomerBoardResponseDto> getCustomerBoard(int customerBoardNumber, String userId) {

        try {
            CustomerBoardEntity customerBoardEntity = customerBoardRepository.findByCustomerBoardNumber(customerBoardNumber);
            if (customerBoardEntity == null) 
            return ResponseDto.noExistBoard();

            UserEntity userEntity = userRepository.findByUserId(userId);
            if (userEntity == null) 
            return ResponseDto.authenticationFailed();

            String userRole = userEntity.getUserRole();
            boolean isSecret = customerBoardEntity.getSecret();
            String writerId = customerBoardEntity.getCustomerBoardWriterId();

            if (isSecret && userRole.equals("ROLE_CUSTOMER") && !userId.equals(writerId)) {
                return ResponseDto.authorizationFailed();
            }
            return GetCustomerBoardResponseDto.success(customerBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    
    @Override
    public ResponseEntity<? super GetCustomerBoardCommentListResponseDto> getCustomerBoardCommentList(int customerBoardNumber ) {  

        try {
            List<CustomerBoardCommentEntity> customerBoardCommentEntities = customerBoardCommentRepository.findByCustomerBoardNumberOrderByCustomerBoardCommentNumberDesc(customerBoardNumber);
            return GetCustomerBoardCommentListResponseDto.success(customerBoardCommentEntities);

        } catch (Exception  exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetCustomerBoardCommentResponseDto> getCustomerBoardComment(int customerBoardCommentNumber) {

        try {
            CustomerBoardCommentEntity customerBoardCommentEntity = customerBoardCommentRepository.findByCustomerBoardCommentNumber(customerBoardCommentNumber);
            if (customerBoardCommentEntity == null)
            return ResponseDto.noExistBoard();

            return GetCustomerBoardCommentResponseDto.success(customerBoardCommentEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> putCustomerBoard(PutCustomerBoardRequestDto dto, int customerBoardNumber, String userId) {

        try {
            CustomerBoardEntity customerBoardEntity =  customerBoardRepository.findByCustomerBoardNumber(customerBoardNumber);

            if (customerBoardEntity == null) 
            return ResponseDto.noExistBoard();

            String writerId = customerBoardEntity != null ? customerBoardEntity.getCustomerBoardWriterId() : null;
            boolean isWriter = writerId != null && userId.equals(writerId);

            if (!isWriter) 
            return ResponseDto.authorizationFailed();

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

            if (customerBoardCommentEntity == null) 
            return ResponseDto.noExistBoard();

            String writerId = customerBoardCommentEntity != null ? customerBoardCommentEntity.getCustomerBoardCommentWriterId() :null;
            boolean isWriter = writerId != null && userId.equals(writerId);

            if (!isWriter) 
            return ResponseDto.authorizationFailed();

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

            if (customerBoardEntity == null) 
            return ResponseDto.noExistBoard();

            UserEntity userEntity = userRepository.findByUserId(userId);

            if (userEntity == null) 
            return ResponseDto.authenticationFailed();

            String writerId = customerBoardEntity.getCustomerBoardWriterId();
            String userRole = userEntity.getUserRole();

            boolean isWriter = userId.equals(writerId);
            boolean isAdmin = userRole.equals("ROLE_ADMIN");

            if (!isWriter && !isAdmin) return ResponseDto.authorizationFailed();
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

            if (customerBoardCommentEntity == null) 
            return ResponseDto.noExistBoard();
    
            UserEntity userEntity = userRepository.findByUserId(userId);

            if (userEntity == null) 
            return ResponseDto.authenticationFailed();
    
            String writerId = customerBoardCommentEntity.getCustomerBoardCommentWriterId();
            String userRole = userEntity.getUserRole();

            boolean isWriter = userId.equals(writerId);
            boolean isAdmin = userRole.equals("ROLE_ADMIN");
    
            if (!isWriter && !isAdmin) 
            return ResponseDto.authorizationFailed();

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
            
            if (customerBoardEntity == null) 
            return ResponseDto.noExistBoard();

            customerBoardEntity.increaseViewCount();
            customerBoardRepository.save(customerBoardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

}