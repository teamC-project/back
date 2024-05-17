package com.back.back.dto.request.customer;

import jakarta.validation.constraints.NotBlank;

public class PutCustomerBoardCommentRequestDto {
    @NotBlank
    private String customerBoardComment;
}
