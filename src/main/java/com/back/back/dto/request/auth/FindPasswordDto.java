package com.back.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindPasswordDto {
  @NotBlank
  private String userId;
  @NotBlank
  private String authNumber;
  @NotBlank
  @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,15}$")
  private String userPassword;
  @NotBlank
  @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
  private String userEmail;
}
