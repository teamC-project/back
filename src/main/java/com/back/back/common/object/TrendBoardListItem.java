package com.back.back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.TrendBoardEntity;

import lombok.Getter;

@Getter
public class TrendBoardListItem {

    private Integer trendBoardNumber;
    private String trendBoardTitle;
    private String trendBoardWriterId;
    private String trendBoardWriteDatetime;
    private Integer trendBoardLikeCount;
	private Integer trendBoardViewCount;
    private String trendBoardThumbnailImage;

    private TrendBoardListItem(TrendBoardEntity trendBoardEntity) throws Exception {

        String writeDatetime = ChangeDateFormatUtil.changeYYMMDD(trendBoardEntity.getTrendBoardWriteDatetime());

        this.trendBoardNumber = trendBoardEntity.getTrendBoardNumber();
        this.trendBoardTitle = trendBoardEntity.getTrendBoardTitle();
        this.trendBoardWriterId = trendBoardEntity.getTrendBoardWriterId();
        this.trendBoardWriteDatetime = writeDatetime;
        this.trendBoardLikeCount = trendBoardEntity.getTrendBoardLikeCount();
        this.trendBoardViewCount = trendBoardEntity.getTrendBoardViewCount();
        this.trendBoardThumbnailImage =trendBoardEntity.getTrendBoardThumbnailImage();
    }

    public static List<TrendBoardListItem> getTrendBoardList(List<TrendBoardEntity> trendBoardEntities) throws Exception {

        List<TrendBoardListItem> trendBoardList = new ArrayList<>();
        
        for (TrendBoardEntity trendBoardEntity : trendBoardEntities) {

            TrendBoardListItem trendBoardListItem = new TrendBoardListItem(trendBoardEntity);
            trendBoardList.add(trendBoardListItem);
        }

        return trendBoardList;
    }
    
}
