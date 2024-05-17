package com.back.back.dto.request.customer;

import jakarta.validation.constraints.NotBlank;

public class PostCustomerBoardCommentRequestDto {
    @NotBlank
    private String customerBoardComment;
}
