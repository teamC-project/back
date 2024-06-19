package com.back.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.back.back.dto.request.customer.PostCustomerBoardCommentRequestDto;
import com.back.back.dto.request.customer.PutCustomerBoardCommentRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="customerBoardComment")
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
    private String customerBoardCommentWriterId;
    private String customerBoardCommentContents;
    private String customerBoardCommentWriteDatetime;
    private Integer customerBoardParentCommentNumber;

    public CustomerBoardCommentEntity (PostCustomerBoardCommentRequestDto dto, Integer customerBoardNumber, String userId) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String customerBoardCommentWriteDatetime = simpleDateFormat.format(now);

        this.customerBoardNumber = customerBoardNumber;
        this.customerBoardCommentContents = dto.getCustomerBoardCommentContents();
        this.customerBoardCommentWriterId = userId;
        this.customerBoardCommentWriteDatetime = customerBoardCommentWriteDatetime;
        this.customerBoardParentCommentNumber = null;
    }

    // 대댓글 생성 시 사용할 생성자 추가
    public CustomerBoardCommentEntity(PostCustomerBoardCommentRequestDto dto, Integer customerBoardNumber, String userId, Integer parentCommentNumber) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String customerBoardCommentWriteDatetime = simpleDateFormat.format(now);

        this.customerBoardNumber = customerBoardNumber;
        this.customerBoardCommentContents = dto.getCustomerBoardCommentContents();
        this.customerBoardCommentWriterId = userId;
        this.customerBoardCommentWriteDatetime = customerBoardCommentWriteDatetime;
        this.customerBoardParentCommentNumber = parentCommentNumber;
    }

    public void update (PutCustomerBoardCommentRequestDto dto) {
        this.customerBoardCommentContents = dto.getCustomerBoardCommentContents();
    }
}
