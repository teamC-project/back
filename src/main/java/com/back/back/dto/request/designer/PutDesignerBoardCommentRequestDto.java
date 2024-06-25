package com.back.back.dto.request.designer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutDesignerBoardCommentRequestDto {
    
    @NotBlank
    private String designerBoardCommentContents;
}
