package com.back.back.dto.request.user;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class DesignerUpdateRequestDto {

    @NotBlank
    private String userGender;

    @NotBlank
    private String userAge;

    private String userImage;

    @NotBlank
    private String userCompanyName;
    
}
