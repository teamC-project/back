package com.back.back.dto.request.loginLog;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class getLoginLogRequestDto {

    @NotBlank
    private String loginId;

    @NotBlank
    private String loginDate;
    
}
