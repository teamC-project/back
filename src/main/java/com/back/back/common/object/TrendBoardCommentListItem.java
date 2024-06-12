package com.back.back.common.object;

import java.util.List;
import java.util.ArrayList;
import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.TrendBoardCommentEntity;

import lombok.Getter;

@Getter
public class TrendBoardCommentListItem {
  private Integer trendBoardCommentNumber;
  private Integer trendBoardNumber;
  private String trendBoardCommentWriterId;
  private String trendBoardCommentWriteDatetime;
  private String trendBoardCommentContents;
  private String originalTrendBoardCommentWriterId;

  private TrendBoardCommentListItem(TrendBoardCommentEntity trendBoardCommentEntity) throws Exception {
    String writeDatetime = ChangeDateFormatUtil
        .changeYYMMDD(trendBoardCommentEntity.getTrendBoardCommentWriteDatetime());

    String writerId = trendBoardCommentEntity.getTrendBoardCommentWriterId();
    writerId = writerId.substring(0, 1) +
        "*".repeat(writerId.length() - 1);

    this.trendBoardCommentNumber = trendBoardCommentEntity.getTrendBoardCommentNumber();
    this.trendBoardCommentWriterId = writerId;
    this.trendBoardCommentWriteDatetime = writeDatetime;
    this.trendBoardCommentContents = trendBoardCommentEntity.getTrendBoardCommentContents();
    this.originalTrendBoardCommentWriterId = trendBoardCommentEntity.getTrendBoardCommentWriterId();

  }

  public static List<TrendBoardCommentListItem> getList(List<TrendBoardCommentEntity> trendBoardCommentEntities)
      throws Exception {
    List<TrendBoardCommentListItem> trendBoardCommentList = new ArrayList<>();

    for (TrendBoardCommentEntity trendBoardCommentEntity : trendBoardCommentEntities) {
      TrendBoardCommentListItem trendBoardCommentListItem = new TrendBoardCommentListItem(trendBoardCommentEntity);
      trendBoardCommentList.add(trendBoardCommentListItem);
    }

    return trendBoardCommentList;
  }
}
