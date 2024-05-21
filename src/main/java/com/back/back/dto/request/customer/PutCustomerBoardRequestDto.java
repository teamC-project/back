package com.back.back.dto.request.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutCustomerBoardRequestDto {
    @NotBlank
    private String customerBoardTitle;
    @NotBlank
    private String customerBoardContents;


}
