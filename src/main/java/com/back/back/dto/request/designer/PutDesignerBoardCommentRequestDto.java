package com.back.back.dto.request.designer;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class PutDesignerBoardCommentRequestDto {
    
    @NotBlank
    private String designerBoardCommentContents;

}
