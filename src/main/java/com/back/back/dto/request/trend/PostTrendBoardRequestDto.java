package com.back.back.dto.request.trend;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostTrendBoardRequestDto {
	@NotBlank
	private String trendBoardTitle;
	@NotBlank
	private String trendBoardContents;
	@NotNull
	private List<String> trendBoardUrlList;
}
