package com.back.back.dto.response.customerboard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.entity.CustomerBoardEntity;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.common.object.CustomerBoardListItem;

import lombok.Getter;

@Getter
public class GetCustomerBoardListResponseDto extends ResponseDto {
    
    private List<CustomerBoardListItem> customerboardList;

    private GetCustomerBoardListResponseDto (List<CustomerBoardEntity> customerBoardEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.customerboardList = CustomerBoardListItem.getList(customerBoardEntities);
    }

    public static ResponseEntity<GetCustomerBoardListResponseDto> success (List<CustomerBoardEntity> customerBoardEntities) throws Exception {
        GetCustomerBoardListResponseDto responseBody = new GetCustomerBoardListResponseDto(customerBoardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
} 
