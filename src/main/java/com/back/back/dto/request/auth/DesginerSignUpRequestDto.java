package com.back.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DesginerSignUpRequestDto {
<<<<<<< HEAD
  @NotBlank
  private String userId;
  @NotBlank
  @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,15}$")
  private String userPassword;
  @NotBlank
  @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
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
  @NotBlank
  private String userRole;
  @NotBlank
  private String joinPath;

  private String snsId;
=======
    @NotBlank
    private String userId;
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,15}$")
    private String userPassword;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
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
    @NotBlank
    private String userRole;
    @NotBlank 
    private String joinPath;
>>>>>>> 31982f94a35b5e3b78129b3cbc1c51736af8a4cb
}
