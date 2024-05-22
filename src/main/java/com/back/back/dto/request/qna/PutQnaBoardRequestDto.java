package com.back.back.dto.request.qna;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutQnaBoardRequestDto {
	@NotBlank
	private String qnaBoardTitle;
	@NotBlank
	private String qnaBoardContents;
}
