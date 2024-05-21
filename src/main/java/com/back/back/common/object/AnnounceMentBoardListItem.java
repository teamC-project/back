package com.back.back.common.object;

import java.util.List;
import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.AnnouncementBoardEntity;
import java.util.ArrayList;
import lombok.Getter;

@Getter
public class AnnouncementBoardListItem {
<<<<<<< HEAD
	private Integer announceMentBoardNumber;
	private String announceMentBoardTitle;
	private String announceMentBoardContents;
	private String announceMentBoardWriterId;
	private String announceMentBoardWriteDateTime;
	private Integer announceMentBoardViewCount;

private AnnouncementBoardListItem(AnnouncementBoardEntity announcementBoardEntity) throws Exception {
	String writeDatetime = ChangeDateFormatUtil.changeYYMMDD(announcementBoardEntity.getAnnounceMentBoardWriteDateTime());
=======
	private Integer announcementBoardNumber;
	private String announcementBoardTitle;
	private String announcementBoardContents;
	private String announcementBoardWriterId;
	private String announcementBoardWriteDateTime;
	private Integer announcementBoardViewCount;

private AnnouncementBoardListItem(AnnouncementBoardEntity announcementBoardEntity) throws Exception {
	String writeDatetime = ChangeDateFormatUtil.changeYYMMDD(announcementBoardEntity.getAnnouncementBoardWriteDateTime());
>>>>>>> 97a21643a440a31601363b460738b873ee41fbf9

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
<<<<<<< HEAD
	List<AnnouncementBoardListItem> announceMentBoardList = new ArrayList<>();

	for (AnnouncementBoardEntity announcementBoardEntity : announcementBoardEntities) {
		AnnouncementBoardListItem announceMentBoardListItem = new AnnouncementBoardListItem(announcementBoardEntity);
		announceMentBoardList.add(announceMentBoardListItem);
=======
	List<AnnouncementBoardListItem> announcementBoardList = new ArrayList<>();

	for (AnnouncementBoardEntity announcementBoardEntity : announcementBoardEntities) {
		AnnouncementBoardListItem announcementBoardListItem = new AnnouncementBoardListItem(announcementBoardEntity);
		announcementBoardList.add(announcementBoardListItem);
>>>>>>> 97a21643a440a31601363b460738b873ee41fbf9

	}
	return announcementBoardList;
} 

}