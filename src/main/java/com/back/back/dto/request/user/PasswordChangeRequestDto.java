package com.back.back.dto.request.user;

import com.back.back.common.util.PasswordPatternUtil;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class PasswordChangeRequestDto {

    @NotBlank
    @Pattern(regexp = PasswordPatternUtil.PASSWORDPATTERN)
    private String userPassword;

}
