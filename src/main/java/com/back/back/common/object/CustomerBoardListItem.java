package com.back.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.back.back.entity.CustomerBoardEntity;

import lombok.Getter;

@Getter
public class CustomerBoardListItem {
    private Integer customerBoardNumber;
    private String customerBoardTitle;
    private String customerBoardWriterId;
    private String customerBoardWriteDatetime;
    private Integer customerBoardViewCount;

    private CustomerBoardListItem(CustomerBoardEntity customerBoardEntity) throws Exception {

    }

    public static List<CustomerBoardListItem>getList(List<CustomerBoardEntity> customerBoardEntities) throws Exception {
        List<CustomerBoardListItem> customerBoardList = new ArrayList<>();

        for (CustomerBoardEntity customerBoardEntity: customerBoardEntities) {
            CustomerBoardListItem customerBoardListItem = new CustomerBoardListItem(customerBoardEntity);
            customerBoardList.add(customerBoardListItem);
        }

        return customerBoardList;
    }
}
