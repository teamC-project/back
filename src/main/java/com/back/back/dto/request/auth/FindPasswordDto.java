package com.back.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindPasswordDto {
  @NotBlank
  public String userEmail;
  @NotBlank
  public String authNumber;
}
