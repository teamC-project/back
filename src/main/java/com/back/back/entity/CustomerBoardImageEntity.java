package com.back.back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "customerBoardImage")
@Table(name = "customer_board_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBoardImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerBoardImageNumber;
    private String customerBoardImageUrl;
    private Integer customerBoardNumber;

    public CustomerBoardImageEntity(Integer customerBoardNumber, String customerBoardImageUrl) {
        this.customerBoardNumber = customerBoardNumber;
        this.customerBoardImageUrl = customerBoardImageUrl;
    }
}
