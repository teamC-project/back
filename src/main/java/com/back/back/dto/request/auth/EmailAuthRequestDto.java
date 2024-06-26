package com.back.back.dto.request.auth;

import com.back.back.common.util.EmailPatternUtil;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailAuthRequestDto {
    
    @NotBlank
    @Pattern(regexp = EmailPatternUtil.EMAILPATTERN)
    private String userEmail;

}
