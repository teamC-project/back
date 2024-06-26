package com.back.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.back.back.entity.TrendBoardCommentEntity;
import com.back.back.common.util.ChangeDateFormatUtil;

import lombok.Getter;

@Getter
public class TrendBoardCommentListItem {

    private Integer trendBoardCommentNumber;
    private String trendBoardCommentWriterId;
    private String trendBoardCommentContents;
    private String trendBoardCommentWriteDatetime;
    private String trendBoardParentCommentNumber;

    private TrendBoardCommentListItem(TrendBoardCommentEntity trendBoardCommentEntity) throws Exception {

        this.trendBoardCommentNumber = trendBoardCommentEntity.getTrendBoardCommentNumber();
        this.trendBoardCommentWriterId = trendBoardCommentEntity.getTrendBoardCommentWriterId();
        this.trendBoardCommentContents = trendBoardCommentEntity.getTrendBoardCommentContents();
        this.trendBoardCommentWriteDatetime = ChangeDateFormatUtil.changeYYYYMMDDHHMM(trendBoardCommentEntity.getTrendBoardCommentWriteDatetime());
        this.trendBoardParentCommentNumber = trendBoardCommentEntity.getTrendBoardCommentWriterId();
    }

    public static List<TrendBoardCommentListItem> getList(List<TrendBoardCommentEntity> trendBoardCommentEntities) throws Exception {

        List<TrendBoardCommentListItem> trendBoardCommentList = new ArrayList<>();
        for (TrendBoardCommentEntity trendBoardCommentEntity : trendBoardCommentEntities) {
            
            TrendBoardCommentListItem trendBoardCommentListItem = new TrendBoardCommentListItem(trendBoardCommentEntity);
            trendBoardCommentList.add(trendBoardCommentListItem);
        }

        return trendBoardCommentList;
    }

}
