package com.back.back.dto.request.user;

import com.back.back.common.util.PasswordPatternUtil;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PasswordChangeRequestDto {

    @NotBlank
    @Pattern(regexp = PasswordPatternUtil.PASSWORDPATTERN)
    private String userPassword;
}
