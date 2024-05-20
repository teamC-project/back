package com.back.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.back.back.dto.request.announcement.PostAnnouncementBoardRequestDto;
import com.back.back.dto.request.announcement.PutAnnouncementBoardRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "announcementBoard")
@Table(name = "announcement_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementBoardEntity {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer announceMentBoardNumber;
	private String announceMentBoardTitle;
	private String announceMentBoardContents;
	private String announceMentBoardWriterId;
	private String announceMentBoardWriteDateTime;
	private Integer announceMentBoardViewCount;

	public AnnouncementBoardEntity(PostAnnouncementBoardRequestDto dto, String userId) {
		Date now =Date.from(Instant.now());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss"
		);
		String writeDatetime = simpleDateFormat.format(now);

		this.announceMentBoardTitle = dto.getAnnouncementBoardTitle();
		this.announceMentBoardContents = dto.getAnnouncementBoardContents();
		this.announceMentBoardWriterId = userId;
		this.announceMentBoardWriteDateTime = writeDatetime;
		this.announceMentBoardViewCount = 0;
	}

	public void increaseAnnoucementBoardViewCount () {
		this.announceMentBoardViewCount++;
	}

	public void updateAnnouncementBoard(PutAnnouncementBoardRequestDto dto) {
		this.announceMentBoardTitle = dto.getAnnouncementBoardTitle();
		this.announceMentBoardContents =  dto.getAnnouncementBoardContents();
	}
}
