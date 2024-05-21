package com.back.back.common.object;

import java.util.List;
import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.AnnouncementBoardEntity;
import java.util.ArrayList;
import lombok.Getter;

@Getter
public class AnnouncementBoardListItem {
	private Integer announcementBoardNumber;
	private String announcementBoardTitle;
	private String announcementBoardContents;
	private String announcementBoardWriterId;
	private String announcementBoardWriteDateTime;
	private Integer announcementBoardViewCount;

private AnnouncementBoardListItem(AnnouncementBoardEntity announcementBoardEntity) throws Exception {
	String writeDatetime = ChangeDateFormatUtil.changeYYMMDD(announcementBoardEntity.getAnnouncementBoardWriteDateTime());

	String announcementBoardWriterId = announcementBoardEntity.getAnnouncementBoardWriterId();
	announcementBoardWriterId = announcementBoardWriterId.substring(0,1) + " +".repeat(announcementBoardWriterId.length() -1);

	this.announcementBoardNumber = announcementBoardEntity.getAnnouncementBoardNumber();
	this.announcementBoardTitle = announcementBoardEntity.getAnnouncementBoardTitle();
	this.announcementBoardContents = announcementBoardEntity.getAnnouncementBoardContents();
	this.announcementBoardWriterId = announcementBoardEntity.getAnnouncementBoardWriterId();
	this.announcementBoardWriteDateTime = writeDatetime;
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