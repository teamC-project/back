package com.back.back.dto.request.Find;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindIdRequestDto {
  @NotBlank
  private String userEmail;
  @NotBlank
  private String authNumber;
}
