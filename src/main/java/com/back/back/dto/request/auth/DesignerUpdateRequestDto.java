package com.back.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DesignerUpdateRequestDto {
  @NotBlank
  private String userGender;
  @NotBlank
  private String userAge;
  @NotBlank
  private String userImage;
  @NotBlank
  private String userCompanyName;
}
