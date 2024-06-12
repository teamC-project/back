package com.back.back.common.object;

import com.back.back.entity.CustomerBoardImageEntity;

import lombok.Getter;

@Getter
public class CustomerBoardImageListItem {
  private Integer customerBoardImageNumber;
  private String customerBoardImageUrl;

  private CustomerBoardImageListItem(CustomerBoardImageEntity customerBoardImageEntity) throws Exception {
    customerBoardImageNumber = customerBoardImageEntity.getCustomerBoardImageNumber();
    customerBoardImageUrl = customerBoardImageEntity.getCustomerBoardImageUrl();
  }
}
