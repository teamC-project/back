package com.back.back.dto.request.trend;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PostTrendBoardCommentRequestDto {
	
	@NotBlank
	private String trendBoardCommentContents;
	
}
