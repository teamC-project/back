package com.back.back.common.object;

import java.util.List;
import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.AnnouncementBoardEntity;
import java.util.ArrayList;
import lombok.Getter;

@Getter
public class AnnouncementBoardListItem {
	private Integer announceMentBoardNumber;
	private String announceMentBoardTitle;
	private String announceMentBoardContents;
	private String announceMentBoardWriterId;
	private String announceMentBoardWriteDateTime;
	private Integer announceMentBoardViewCount;

private AnnouncementBoardListItem(AnnouncementBoardEntity announcementBoardEntity) throws Exception {
	String writeDatetime = ChangeDateFormatUtil.changeYYMMDD(announcementBoardEntity.getAnnounceMentBoardWriteDateTime());

	String announceMentBoardWriterId = announcementBoardEntity.getAnnounceMentBoardWriterId();
	announceMentBoardWriterId = announceMentBoardWriterId.substring(0,1) + " +".repeat(announceMentBoardWriterId.length() -1);

	this.announceMentBoardNumber = announcementBoardEntity.getAnnounceMentBoardNumber();
	this.announceMentBoardTitle = announcementBoardEntity.getAnnounceMentBoardTitle();
	this.announceMentBoardContents = announcementBoardEntity.getAnnounceMentBoardContents();
	this.announceMentBoardWriterId = announcementBoardEntity.getAnnounceMentBoardWriterId();
	this.announceMentBoardWriteDateTime = writeDatetime;
	this.announceMentBoardViewCount = announcementBoardEntity.getAnnounceMentBoardViewCount();
}

public static List<AnnouncementBoardListItem> getAnnouncementBoardList(List<AnnouncementBoardEntity> announcementBoardEntities) throws Exception {
	List<AnnouncementBoardListItem> announceMentBoardList = new ArrayList<>();

	for (AnnouncementBoardEntity announcementBoardEntity : announcementBoardEntities) {
		AnnouncementBoardListItem announceMentBoardListItem = new AnnouncementBoardListItem(announcementBoardEntity);
		announceMentBoardList.add(announceMentBoardListItem);

	}
	return announceMentBoardList;
} 

}
