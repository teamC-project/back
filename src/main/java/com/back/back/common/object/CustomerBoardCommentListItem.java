package com.back.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.CustomerBoardCommentEntity;

import lombok.Getter;

@Getter
public class CustomerBoardCommentListItem {

    private Integer customerBoardCommentNumber;
    private String customerBoardCommentWriterId;
    private String customerBoardCommentContents;
    private String customerBoardCommentWriteDatetime;
    private Integer customerBoardParentCommentNumber;

    private CustomerBoardCommentListItem(CustomerBoardCommentEntity customerBoardCommentEntity) throws Exception {

        this.customerBoardCommentNumber = customerBoardCommentEntity.getCustomerBoardCommentNumber();
        this.customerBoardCommentWriterId = customerBoardCommentEntity.getCustomerBoardCommentWriterId();
        this.customerBoardCommentContents = customerBoardCommentEntity.getCustomerBoardCommentContents();
        this.customerBoardParentCommentNumber = customerBoardCommentEntity.getCustomerBoardParentCommentNumber(); 
        this.customerBoardCommentWriteDatetime = ChangeDateFormatUtil.changeYYYYMMDDHHMM(customerBoardCommentEntity.getCustomerBoardCommentWriteDatetime());
    }

    public static List<CustomerBoardCommentListItem> getList(List<CustomerBoardCommentEntity> customerBoardCommentEntities) throws Exception {

        List<CustomerBoardCommentListItem> customerBoardCommentList = new ArrayList<>();
        for (CustomerBoardCommentEntity customerBoardCommentEntity : customerBoardCommentEntities) {
            
            CustomerBoardCommentListItem customerBoardCommentListItem = new CustomerBoardCommentListItem(customerBoardCommentEntity);
            customerBoardCommentList.add(customerBoardCommentListItem);
        }

        return customerBoardCommentList;
    }

}
