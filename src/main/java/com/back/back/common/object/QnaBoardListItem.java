package com.back.back.common.object;

import java.util.List;
import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.QnaBoardEntity;
import java.util.ArrayList;
import lombok.Getter;

@Getter
public class QnaBoardListItem {
	private Integer qnaBoardNumber;
	private Boolean qnaBoardStatus;
	private String qnaBoardTitle;
	private String qnaBoardContents;
	private String qnaBoardWriterId;
	private String qnaBoardWriteDatetime;
	private Integer qnaBoardViewCount;
	private String qnaBoardComment;

	private QnaBoardListItem(QnaBoardEntity qnaBoardEntity) throws Exception {
		String writeDatetime = ChangeDateFormatUtil.changeYYMMDD(qnaBoardEntity.getQnaBoardWriteDatetime());

		String qnaBoardWriterId = qnaBoardEntity.getQnaBoardWriterId();
		qnaBoardWriterId = qnaBoardWriterId.substring(0,1) + " +".repeat(qnaBoardWriterId.length() - 1);

		this.qnaBoardNumber = qnaBoardEntity.getQnaBoardNumber();
		this.qnaBoardStatus = qnaBoardEntity.getQnaBoardStatus();
		this.qnaBoardTitle = qnaBoardEntity.getQnaBoardTitle();
		this.qnaBoardWriterId = qnaBoardEntity.getQnaBoardWriterId();
		this.qnaBoardWriteDatetime = writeDatetime;
		this.qnaBoardViewCount = qnaBoardEntity.getQnaBoardViewCount();

	}

	public static List<QnaBoardListItem> getQnaBoardList(List<QnaBoardEntity>qnaBoardEntities) throws Exception {
		List<QnaBoardListItem> qnaBoardList = new ArrayList<>();

		for ( QnaBoardEntity qnaBoardEntity : qnaBoardEntities) {
			QnaBoardListItem qnaBoardListItem = new QnaBoardListItem(qnaBoardEntity);
				qnaBoardList.add(qnaBoardListItem);
		}
		return qnaBoardList;
	}
}
