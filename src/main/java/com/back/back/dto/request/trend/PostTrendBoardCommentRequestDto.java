package com.back.back.dto.request.trend;

import jakarta.validation.constraints.NotBlank;

public class PostTrendBoardCommentRequestDto {
	@NotBlank
	private String trendBoardComment;
}
