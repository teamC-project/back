package com.back.back.dto.request.designer;

import jakarta.validation.constraints.NotBlank;

public class PutDesignerBoardCommentRequestDto {
    @NotBlank
    private String designerBoardComment;
}
