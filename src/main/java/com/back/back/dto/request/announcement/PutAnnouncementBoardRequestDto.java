package com.back.back.dto.request.announcement;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutAnnouncementBoardRequestDto {
    
	@NotBlank
	private String announcementBoardTitle;

	@NotBlank
	private String announcementBoardContents;
}
