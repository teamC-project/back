package com.back.back.dto.request.designer;

import jakarta.validation.constraints.NotBlank;

public class PutCustomerBoardCommentRequestDto {
    @NotBlank
    private String designerBoardComment;
}
