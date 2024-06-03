package com.back.back.dto.request.trend;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostTrendBoardRequestDto {
	@NotBlank
	private String trendBoardTitle;
	@NotBlank
	private String trendBoardContents;
	// private List<String> trendBoardUrlList;
}
