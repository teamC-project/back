package com.back.back.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerUpdateRequestDto {

    @NotBlank
    private String userGender;
    
    @NotBlank
    private String userAge;
}