package com.back.back.dto.request.customer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCustomerBoardRequestDto {

    @NotBlank
    private String customerBoardTitle;

    @NotBlank
    private String customerBoardContents;

    @NotNull
    private boolean secret;
    
}
