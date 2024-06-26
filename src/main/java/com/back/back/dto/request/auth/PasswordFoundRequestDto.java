package com.back.back.dto.request.auth;

import com.back.back.common.util.EmailPatternUtil;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class PasswordFoundRequestDto {

    @NotBlank
    private String userId;

    @NotBlank
    @Pattern(regexp = EmailPatternUtil.EMAILPATTERN)
    private String userEmail;
    
    @NotBlank
    private String authNumber;
    
}
