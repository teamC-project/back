package com.back.back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.CustomerBoardEntity;

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
        
        String writeDatetime = ChangeDateFormatUtil.changeCustomerListDateFormat(customerBoardEntity.getCustomerBoardWriteDatetime());

        this.customerBoardNumber = customerBoardEntity.getCustomerBoardNumber();
        this.customerBoardTitle = customerBoardEntity.getCustomerBoardTitle();
        this.customerBoardWriterId = customerBoardEntity.getCustomerBoardWriterId();
        this.customerBoardWriteDatetime = writeDatetime;
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
