package com.back.back.common.object;

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
}
