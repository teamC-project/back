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
	private Integer announcementBoardNumber;
	private String announcementBoardTitle;
	private String announcementBoardContents;
	private String announcementBoardWriterId;
	private String announcementBoardWriteDatetime;
	private Integer announcementBoardViewCount;

	private GetAnnouncementBoardResponseDto(AnnouncementBoardEntity announcementBoardEntity) throws Exception {
		super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
		String writeDateTime = ChangeDateFormatUtil.changeYYYYMMDD(announcementBoardEntity.getAnnouncementBoardWriteDatetime());

		this.announcementBoardNumber = announcementBoardEntity.getAnnouncementBoardNumber();
		this.announcementBoardTitle = announcementBoardEntity.getAnnouncementBoardTitle();
		this.announcementBoardWriterId = announcementBoardEntity.getAnnouncementBoardWriterId();
		this.announcementBoardWriteDatetime = writeDateTime;
		this.announcementBoardViewCount = announcementBoardEntity.getAnnouncementBoardViewCount();
		this.announcementBoardContents = announcementBoardEntity.getAnnouncementBoardContents();
	}

		public static ResponseEntity<GetAnnouncementBoardResponseDto> success (AnnouncementBoardEntity announcementBoardEntity) throws Exception {
			GetAnnouncementBoardResponseDto responseBody = new GetAnnouncementBoardResponseDto(announcementBoardEntity);
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
}
