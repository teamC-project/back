package com.back.back.common.object;

import com.back.back.entity.CustomerBoardImageEntity;

import lombok.Getter;

@Getter
public class CustomerBoardImageListItem {
    
    private String customerBoardImageUrl;
    private Integer customerBoardImageNumber;

    private CustomerBoardImageListItem(CustomerBoardImageEntity customerBoardImageEntity) throws Exception {

        customerBoardImageUrl = customerBoardImageEntity.getCustomerBoardImageUrl();
        customerBoardImageNumber = customerBoardImageEntity.getCustomerBoardImageNumber();
    }
    
}
