package com.back.back.dto.response.announcementboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.entity.AnnouncementBoardEntity;


import lombok.Getter;

@Getter
public class GetAnnouncementBoardResponseDto extends ResponseDto {
	private Integer announceMentBoardNumber;
	private String announceMentBoardTitle;
	private String announceMentBoardContents;
	private String announceMentBoardWriterId;
	private String announceMentBoardWriteDateTime;
	private Integer announceMentBoardViewCount;

	private GetAnnouncementBoardResponseDto(AnnouncementBoardEntity announcementBoardEntity) throws Exception {
		super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
		String writeDateTime = ChangeDateFormatUtil.changeYYYYMMDD(announcementBoardEntity.getAnnounceMentBoardWriteDateTime());

		this.announceMentBoardNumber = announcementBoardEntity.getAnnounceMentBoardNumber();
		this.announceMentBoardTitle = announcementBoardEntity.getAnnounceMentBoardTitle();
		this.announceMentBoardWriterId = announcementBoardEntity.getAnnounceMentBoardWriterId();
		this.announceMentBoardWriteDateTime = writeDateTime;
		this.announceMentBoardViewCount = announcementBoardEntity.getAnnounceMentBoardViewCount();
		this.announceMentBoardContents = announcementBoardEntity.getAnnounceMentBoardContents();
	}

		public static ResponseEntity<GetAnnouncementBoardResponseDto> success (AnnouncementBoardEntity announcementBoardEntity) throws Exception {
			GetAnnouncementBoardResponseDto responseBody = new GetAnnouncementBoardResponseDto(announcementBoardEntity);
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
}
