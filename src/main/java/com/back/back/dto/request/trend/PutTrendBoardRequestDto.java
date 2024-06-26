package com.back.back.dto.request.trend;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class PutTrendBoardRequestDto {

	@NotBlank
	private String trendBoardTitle;
	
	@NotBlank
	private String trendBoardContents;
	
}
