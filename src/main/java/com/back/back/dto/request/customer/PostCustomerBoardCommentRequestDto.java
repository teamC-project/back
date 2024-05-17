package com.back.back.dto.request.designer;

import jakarta.validation.constraints.NotBlank;

public class PostDesignerBoardCommentRequestDto {
    @NotBlank
    private String designerBoardComment;
}
