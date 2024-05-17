package com.back.back.dto.response.customerboard;

import java.util.List;

import com.back.back.common.object.CustomerBoardListItem;
import com.back.back.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class GetCustomerBoardListResponseDto extends ResponseDto {
    
    private List<CustomerBoardListItem> customerBoardList;

    
} 
