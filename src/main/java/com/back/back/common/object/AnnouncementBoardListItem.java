package com.back.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.back.back.entity.AnnouncementBoardEntity;
import com.back.back.common.util.ChangeDateFormatUtil;

import lombok.Getter;

@Getter
public class AnnouncementBoardListItem {

	private Integer announcementBoardNumber;
	private String announcementBoardTitle;
	private String announcementBoardWriterId;
	private String announcementBoardWriteDatetime;
	private Integer announcementBoardViewCount;

	private AnnouncementBoardListItem(AnnouncementBoardEntity announcementBoardEntity) throws Exception {

		this.announcementBoardNumber = announcementBoardEntity.getAnnouncementBoardNumber();
		this.announcementBoardTitle = announcementBoardEntity.getAnnouncementBoardTitle();
		this.announcementBoardWriterId = announcementBoardEntity.getAnnouncementBoardWriterId();
		this.announcementBoardWriteDatetime = ChangeDateFormatUtil.changeYYYYMMDDHHMM(announcementBoardEntity.getAnnouncementBoardWriteDatetime());
		this.announcementBoardViewCount = announcementBoardEntity.getAnnouncementBoardViewCount();
	}

	public static List<AnnouncementBoardListItem> getAnnouncementBoardList(List<AnnouncementBoardEntity> announcementBoardEntities) throws Exception {
		
		List<AnnouncementBoardListItem> announcementBoardList = new ArrayList<>();
		for (AnnouncementBoardEntity announcementBoardEntity : announcementBoardEntities) {
			AnnouncementBoardListItem announcementBoardListItem = new AnnouncementBoardListItem(announcementBoardEntity);
			announcementBoardList.add(announcementBoardListItem);
		}
		
	return announcementBoardList;
	} 

}