package com.back.back.dto.request.qna;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostQnaBoardCommentRequestDto {

    @NotBlank
    private String qnaBoardComment;
}
