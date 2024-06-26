package com.back.back.entity;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.dto.request.customer.PutCustomerBoardCommentRequestDto;
import com.back.back.dto.request.customer.PostCustomerBoardCommentRequestDto;

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
@Table(name="customer_board_comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBoardCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerBoardCommentNumber;

    private Integer customerBoardNumber;

    private String customerBoardCommentContents;

    private String customerBoardCommentWriterId;

    private String customerBoardCommentWriteDatetime;

    private Integer customerBoardParentCommentNumber;

    public CustomerBoardCommentEntity (PostCustomerBoardCommentRequestDto dto, Integer customerBoardNumber, String userId) {

        this.customerBoardNumber = customerBoardNumber;
        this.customerBoardCommentContents = dto.getCustomerBoardCommentContents();
        this.customerBoardCommentWriterId = userId;
        this.customerBoardCommentWriteDatetime = ChangeDateFormatUtil.getCurrentDatetiem();
        this.customerBoardParentCommentNumber = null;
    }

    public CustomerBoardCommentEntity(PostCustomerBoardCommentRequestDto dto, Integer customerBoardNumber, String userId, Integer parentCommentNumber) {

        this.customerBoardNumber = customerBoardNumber;
        this.customerBoardCommentContents = dto.getCustomerBoardCommentContents();
        this.customerBoardCommentWriterId = userId;
        this.customerBoardCommentWriteDatetime = ChangeDateFormatUtil.getCurrentDatetiem();
        this.customerBoardParentCommentNumber = parentCommentNumber;
    }

    public void update (PutCustomerBoardCommentRequestDto dto) {
        
        this.customerBoardCommentContents = dto.getCustomerBoardCommentContents();
    }

}
