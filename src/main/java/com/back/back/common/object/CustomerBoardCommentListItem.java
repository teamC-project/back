package com.back.back.common.object;

import java.util.List;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.CustomerBoardCommentEntity;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class CustomerBoardCommentListItem {
    private Integer customerBoardCommentNumber;
    private String customerBoardCommentWriterId;
    private String customerBoardCommentWriteDatetime;
    private String customerBoardCommentContents;

    private CustomerBoardCommentListItem(CustomerBoardCommentEntity customerBoardCommentEntity) throws Exception {
        String writeDatetime = ChangeDateFormatUtil.changeYYMMDD(customerBoardCommentEntity.getCustomerBoardCommentWriteDatetime());

        String writerId = customerBoardCommentEntity.getCustomerBoardCommentWriterId();
        writerId =
        writerId.substring(0, 1) + 
        "*".repeat(writerId.length() - 1);

        this.customerBoardCommentNumber = customerBoardCommentEntity.getCustomerBoardCommentNumber();
        this.customerBoardCommentWriterId = writerId;
        this.customerBoardCommentWriteDatetime = writeDatetime;
        this.customerBoardCommentContents = customerBoardCommentEntity.getCustomerBoardCommentContents();

    }

    public static List<CustomerBoardCommentListItem>getList(List<CustomerBoardCommentEntity> customerBoardCommentEntities) throws Exception {
        List<CustomerBoardCommentListItem> customerBoardCommentList = new ArrayList<>();

        for (CustomerBoardCommentEntity customerBoardCommentEntity: customerBoardCommentEntities) {
            CustomerBoardCommentListItem customerBoardCommentListItem = new CustomerBoardCommentListItem(customerBoardCommentEntity);
            customerBoardCommentList.add(customerBoardCommentListItem);
        }

        return customerBoardCommentList;
    }
}
