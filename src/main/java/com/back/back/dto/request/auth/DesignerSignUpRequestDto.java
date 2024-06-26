package com.back.back.dto.request.auth;

import com.back.back.common.util.EmailPatternUtil;
import com.back.back.common.util.PasswordPatternUtil;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DesignerSignUpRequestDto {

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

    @NotBlank
    private String userImage;

    @NotBlank
    String userCompanyName;
    
    private String joinPath;

    private String snsId;
}
