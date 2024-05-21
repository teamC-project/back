package com.back.back.dto.request.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutCustomerBoardCommentRequestDto {
    @NotBlank
    private String customerBoardCommentContents;
}
