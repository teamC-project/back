package com.back.back.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InformationUpdateRequestDto {
    @NotBlank
    private String userId;
    private String userEmail;
    private String userGender;
    private String userAge;
    private String userImage;
    private String userCompanyName;
}
