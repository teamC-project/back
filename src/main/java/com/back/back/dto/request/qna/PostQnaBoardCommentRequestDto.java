package com.back.back.dto.request.qna;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class PostQnaBoardCommentRequestDto {

    @NotBlank
    private String qnaBoardComment;
    
}
