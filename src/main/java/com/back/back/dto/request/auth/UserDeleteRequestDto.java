package com.back.back.dto.request.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDeleteRequestDto {
    private String userId;
    private String userPassword;
    private String userEmail;
    private String userGender;
    private String userAge;
    private String userCompanyName;
    private String userImage;
}
