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

    public CustomerBoardCommentEntity (PostCustomerBoardCommentRequestDto dto, String userId) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String customerBoardCommentWriteDatetime = simpleDateFormat.format(now);

        this.customerBoardCommentContents = dto.getCustomerBoardCommentContents();
        this.customerBoardCommentWriterId = userId;
        this.customerBoardCommentWriteDatetime = customerBoardCommentWriteDatetime;

    }

    public void update (PutCustomerBoardCommentRequestDto dto) {
        this.customerBoardCommentContents = dto.getCustomerBoardCommentContents();
    }
}
