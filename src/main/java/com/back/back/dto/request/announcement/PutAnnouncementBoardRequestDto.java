package com.back.back.dto.request.announcement;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class PutAnnouncementBoardRequestDto {
    
	@NotBlank
	private String announcementBoardTitle;

	@NotBlank
	private String announcementBoardContents;
	
}
