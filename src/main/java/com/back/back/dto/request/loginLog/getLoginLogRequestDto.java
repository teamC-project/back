package com.back.back.dto.request.loginLog;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class getLoginLogRequestDto {
  @NotBlank
  private String loginId;
  @NotBlank
  private String loginDate;
}
