package com.back.back.dto.request.designer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCustomerBoardRequestDto {
    @NotBlank
    private String designerBoardTitle;
    @NotBlank
    private String designerBoardContents;

}
