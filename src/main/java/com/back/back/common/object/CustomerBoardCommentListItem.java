package com.back.back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.CustomerBoardCommentEntity;

import lombok.Getter;

@Getter
public class CustomerBoardCommentListItem {
  private Integer customerBoardCommentNumber;
  private String customerBoardCommentWriterId;
  private String customerBoardCommentWriteDatetime;
  private String customerBoardCommentContents;
  private Integer customerBoardParentCommentNumber;

  private CustomerBoardCommentListItem(CustomerBoardCommentEntity customerBoardCommentEntity) throws Exception {
    String writeDatetime = ChangeDateFormatUtil
        .changeYYYYMMDDHHMM(customerBoardCommentEntity.getCustomerBoardCommentWriteDatetime());

    this.customerBoardCommentNumber = customerBoardCommentEntity.getCustomerBoardCommentNumber();
    this.customerBoardCommentWriterId = customerBoardCommentEntity.getCustomerBoardCommentWriterId();
    this.customerBoardCommentWriteDatetime = writeDatetime;
    this.customerBoardCommentContents = customerBoardCommentEntity.getCustomerBoardCommentContents();
    this.customerBoardParentCommentNumber = customerBoardCommentEntity.getCustomerBoardParentCommentNumber(); // 부모 댓글
                                                                                                              // 번호 설정

  }

  public static List<CustomerBoardCommentListItem> getList(
      List<CustomerBoardCommentEntity> customerBoardCommentEntities) throws Exception {
    List<CustomerBoardCommentListItem> customerBoardCommentList = new ArrayList<>();

    for (CustomerBoardCommentEntity customerBoardCommentEntity : customerBoardCommentEntities) {
      CustomerBoardCommentListItem customerBoardCommentListItem = new CustomerBoardCommentListItem(
          customerBoardCommentEntity);
      customerBoardCommentList.add(customerBoardCommentListItem);
    }

    return customerBoardCommentList;
  }
}
