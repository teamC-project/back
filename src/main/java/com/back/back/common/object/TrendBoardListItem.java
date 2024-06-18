package com.back.back.common.object;

import java.util.List;
import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.TrendBoardEntity;
import java.util.ArrayList;
import lombok.Getter;

@Getter
public class TrendBoardListItem {
  private Integer trendBoardNumber;
  private String trendBoardTitle;
  private String trendBoardContents;
  private String trendBoardWriterId;
  private String trendBoardWriteDatetime;
  private String trendBoardThumbnailImage;
  private Integer trendBoardLikeCount;
	private Integer trendBoardViewCount;

  private TrendBoardListItem(TrendBoardEntity trendBoardEntity) throws Exception {
    String writeDatetime = ChangeDateFormatUtil.changeYYMMDD(
        trendBoardEntity.getTrendBoardWriteDatetime());

    String trendBoardWriterId = trendBoardEntity.getTrendBoardWriterId();
    trendBoardWriterId = trendBoardWriterId.substring(0, 1) + " +".repeat(trendBoardWriterId.length() - 1);

    this.trendBoardNumber = trendBoardEntity.getTrendBoardNumber();
    this.trendBoardTitle = trendBoardEntity.getTrendBoardTitle();
    this.trendBoardContents = trendBoardEntity.getTrendBoardContents();
    this.trendBoardWriterId = trendBoardEntity.getTrendBoardWriterId();
    this.trendBoardWriteDatetime = writeDatetime;
    this.trendBoardLikeCount = trendBoardEntity.getTrendBoardLikeCount();
		this.trendBoardViewCount = trendBoardEntity.getTrendBoardViewCount();
		this.trendBoardThumbnailImage =trendBoardEntity.getTrendBoardThumbnailImage();
  }

  public static List<TrendBoardListItem> getTrendBoardList(
      List<TrendBoardEntity> trendBoardEntities) throws Exception {
    List<TrendBoardListItem> trendBoardList = new ArrayList<>();

    for (TrendBoardEntity trendBoardEntity : trendBoardEntities) {
      TrendBoardListItem trendBoardListItem = new TrendBoardListItem(trendBoardEntity);
      trendBoardList.add(trendBoardListItem);
    }
    return trendBoardList;
  }
}
