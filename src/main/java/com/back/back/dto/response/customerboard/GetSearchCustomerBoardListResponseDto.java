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
public class GetSearchCustomerBoardListResponseDto extends ResponseDto {

    private List<CustomerBoardListItem> customerBoardList;

    private GetSearchCustomerBoardListResponseDto (List<CustomerBoardEntity> customerBoardEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.customerBoardList = CustomerBoardListItem.getList(customerBoardEntities);
    }

    public static ResponseEntity<GetSearchCustomerBoardListResponseDto> success (List<CustomerBoardEntity> customerBoardEntities) throws Exception {

        GetSearchCustomerBoardListResponseDto responseBody = new GetSearchCustomerBoardListResponseDto(customerBoardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
