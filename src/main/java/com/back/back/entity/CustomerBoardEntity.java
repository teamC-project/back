package com.back.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.back.back.dto.request.customer.PostCustomerBoardRequestDto;
import com.back.back.dto.request.customer.PutCustomerBoardRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "customer_board")
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
    private String customerBoardComment;
    private Integer customerBoardViewCount;

    public CustomerBoardEntity(PostCustomerBoardRequestDto dto, String userId) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String customerBoardWriteDatetime = simpleDateFormat.format(now);

        this.customerBoardTitle = dto.getCustomerBoardTitle();
        this.customerBoardContents = dto.getCustomerBoardContents();
        this.customerBoardWriterId = userId;
        this.customerBoardWriteDatetime = customerBoardWriteDatetime;
        this.customerBoardViewCount = 0;
    }

    public void CustomerIncreaseViewCount() {
        this.customerBoardViewCount++;  
    }

    public void update (PutCustomerBoardRequestDto dto) {
        this.customerBoardTitle = dto.getCustomerBoardTitle();
        this.customerBoardContents = dto.getCustomerBoardContents();
    }

}
