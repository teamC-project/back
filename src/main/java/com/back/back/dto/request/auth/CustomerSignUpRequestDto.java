package com.back.back.dto.request.auth;

import com.back.back.common.util.EmailPatternUtil;
import com.back.back.common.util.PasswordPatternUtil;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class CustomerSignUpRequestDto {

    @NotBlank
    private String userId;

    @NotBlank
    @Pattern(regexp = PasswordPatternUtil.PASSWORDPATTERN)
    private String userPassword;

    @NotBlank
    @Pattern(regexp = EmailPatternUtil.EMAILPATTERN)
    private String userEmail;

    @NotBlank
    private String authNumber;

    @NotBlank
    private String userGender;
    
    @NotBlank
    private String userAge;

    private String joinPath;

    private String snsId;
    
}
