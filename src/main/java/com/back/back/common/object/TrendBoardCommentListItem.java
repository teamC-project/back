package com.back.back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.TrendBoardCommentEntity;

import lombok.Getter;

@Getter
public class TrendBoardCommentListItem {

    private Integer trendBoardCommentNumber;
    private String trendBoardCommentWriterId;
    private String trendBoardCommentContents;
    private String trendBoardCommentWriteDatetime;
    private String trendBoardParentCommentNumber;

    private TrendBoardCommentListItem(TrendBoardCommentEntity trendBoardCommentEntity) throws Exception {

        String writeDatetime = ChangeDateFormatUtil.changeYYMMDD(trendBoardCommentEntity.getTrendBoardCommentWriteDatetime());

        String writerId = trendBoardCommentEntity.getTrendBoardCommentWriterId();
        writerId = writerId.substring(0, 1) + "*".repeat(writerId.length() - 1);

        this.trendBoardCommentNumber = trendBoardCommentEntity.getTrendBoardCommentNumber();
        this.trendBoardCommentWriterId = writerId;
        this.trendBoardCommentContents = trendBoardCommentEntity.getTrendBoardCommentContents();
        this.trendBoardCommentWriteDatetime = writeDatetime;
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
