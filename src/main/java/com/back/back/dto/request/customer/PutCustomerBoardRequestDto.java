package com.back.back.dto.request.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
    
    @NotNull
    private boolean secret;
    
}
