package com.back.back.dto.request.auth;

import com.back.back.common.constant.PatternConstant;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class PasswordReSetRequestDto {

    @NotBlank
    private String userId;
    
    @NotBlank
    @Pattern(regexp = PatternConstant.PASSWORDPATTERN)
    private String userPassword;

}
