package com.back.back.dto.request.trend;

import jakarta.validation.constraints.NotBlank;

public class PutTrendBoardCommentRequestDto {
	@NotBlank
	private String trendBoardComment;
}
