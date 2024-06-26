package com.back.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.back.back.entity.CustomerBoardEntity;
import com.back.back.common.util.ChangeDateFormatUtil;

import lombok.Getter;

@Getter
public class CustomerBoardListItem {

    private Integer customerBoardNumber;
    private String customerBoardTitle;
    private String customerBoardWriterId;
    private String customerBoardWriteDatetime;
    private Integer customerBoardViewCount;
    private Boolean secret;

    private CustomerBoardListItem(CustomerBoardEntity customerBoardEntity) throws Exception {

        this.customerBoardNumber = customerBoardEntity.getCustomerBoardNumber();
        this.customerBoardTitle = customerBoardEntity.getCustomerBoardTitle();
        this.customerBoardWriterId = customerBoardEntity.getCustomerBoardWriterId();
        this.customerBoardWriteDatetime = ChangeDateFormatUtil.changeListDateFormat(customerBoardEntity.getCustomerBoardWriteDatetime());
        this.customerBoardViewCount = customerBoardEntity.getCustomerBoardViewCount();
        this.secret = customerBoardEntity.getSecret();
    }

    public static List<CustomerBoardListItem> getList(List<CustomerBoardEntity> customerBoardEntities) throws Exception {

        List<CustomerBoardListItem> customerBoardList = new ArrayList<>();
        for (CustomerBoardEntity customerBoardEntity : customerBoardEntities) {
            
            CustomerBoardListItem customerBoardListItem = new CustomerBoardListItem(customerBoardEntity);
            customerBoardList.add(customerBoardListItem);
        }
        return customerBoardList;
    }

}
