package com.back.back.dto.request.customer;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class PutCustomerBoardCommentRequestDto {
    
    @NotBlank
    private String customerBoardCommentContents;

}
