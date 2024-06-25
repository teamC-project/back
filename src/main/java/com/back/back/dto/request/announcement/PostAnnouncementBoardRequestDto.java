package com.back.back.dto.request.announcement;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostAnnouncementBoardRequestDto {
    
	@NotBlank
	public String announcementBoardTitle;
    
	@NotBlank
	public String announcementBoardContents;
}
