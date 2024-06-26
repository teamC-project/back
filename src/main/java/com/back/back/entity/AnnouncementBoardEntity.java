package com.back.back.entity;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.dto.request.announcement.PutAnnouncementBoardRequestDto;
import com.back.back.dto.request.announcement.PostAnnouncementBoardRequestDto;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "announcement_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementBoardEntity {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer announcementBoardNumber;

	private String announcementBoardTitle;

	private String announcementBoardContents;

	private String announcementBoardWriterId;
	
	private String announcementBoardWriteDatetime;
	
	private Integer announcementBoardViewCount;

	public AnnouncementBoardEntity(PostAnnouncementBoardRequestDto dto, String userId) {

		this.announcementBoardTitle = dto.getAnnouncementBoardTitle();
		this.announcementBoardContents = dto.getAnnouncementBoardContents();
		this.announcementBoardWriterId = userId;
		this.announcementBoardWriteDatetime = ChangeDateFormatUtil.getCurrentDatetiem();
		this.announcementBoardViewCount = 0;
	}

	public void increaseAnnouncementBoardViewCount () {

		this.announcementBoardViewCount++;
	}

	public void updateAnnouncementBoard(PutAnnouncementBoardRequestDto dto) {

		this.announcementBoardTitle = dto.getAnnouncementBoardTitle();
		this.announcementBoardContents =  dto.getAnnouncementBoardContents();
	}

}
