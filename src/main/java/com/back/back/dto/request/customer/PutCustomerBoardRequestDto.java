package com.back.back.dto.request.customer;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class PutCustomerBoardRequestDto {

    @NotBlank
    private String customerBoardTitle;

    @NotBlank
    private String customerBoardContents;

    private boolean secret;
    
}
