package com.back.back.entity;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.dto.request.customer.PutCustomerBoardRequestDto;
import com.back.back.dto.request.customer.PostCustomerBoardRequestDto;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "customer_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerBoardNumber;

    private String customerBoardTitle;

    private String customerBoardContents;

    private String customerBoardWriterId;

    private String customerBoardWriteDatetime;

    private Integer customerBoardViewCount;

    private Boolean secret;

    public CustomerBoardEntity(PostCustomerBoardRequestDto dto, String userId) {

        this.customerBoardTitle = dto.getCustomerBoardTitle();
        this.customerBoardContents = dto.getCustomerBoardContents();
        this.customerBoardWriterId = userId;
        this.customerBoardWriteDatetime = ChangeDateFormatUtil.getCurrentDatetiem();
        this.customerBoardViewCount = 0;
        this.secret = dto.isSecret();
    }

    public void increaseViewCount() {

        this.customerBoardViewCount++;
    }

    public void update(PutCustomerBoardRequestDto dto) {
        this.customerBoardTitle = dto.getCustomerBoardTitle();
        this.customerBoardContents = dto.getCustomerBoardContents();
        this.secret = dto.isSecret();
    }
    
}
