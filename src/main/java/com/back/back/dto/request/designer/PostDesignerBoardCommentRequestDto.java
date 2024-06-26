package com.back.back.dto.request.designer;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDesignerBoardCommentRequestDto {

    @NotBlank
    private String designerBoardCommentContents;
    
    private Integer designerBoardParentCommentNumber;
    
}
