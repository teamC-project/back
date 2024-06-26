package com.back.back.dto.request.customer;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCustomerBoardCommentRequestDto {

    @NotBlank
    private String customerBoardCommentContents;
    
    private Integer customerBoardParentCommentNumber;

}
