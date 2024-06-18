package com.back.back.common.object;
import java.util.ArrayList;
import java.util.List;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.AnnouncementBoardEntity;

import lombok.Getter;

@Getter
public class AnnouncementBoardListItem {
	private Integer announcementBoardNumber;
	private String announcementBoardTitle;
	private String announcementBoardContents;
	private String announcementBoardWriterId;
	private String announcementBoardWriteDatetime;
	private Integer announcementBoardViewCount;

private AnnouncementBoardListItem(AnnouncementBoardEntity announcementBoardEntity) throws Exception {
	String writeDatetime = ChangeDateFormatUtil.changeYYMMDD(announcementBoardEntity.getAnnouncementBoardWriteDatetime());

	String announcementBoardWriterId = announcementBoardEntity.getAnnouncementBoardWriterId();

	this.announcementBoardNumber = announcementBoardEntity.getAnnouncementBoardNumber();
	this.announcementBoardTitle = announcementBoardEntity.getAnnouncementBoardTitle();
	this.announcementBoardWriterId = announcementBoardWriterId;
	this.announcementBoardWriteDatetime = writeDatetime;
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