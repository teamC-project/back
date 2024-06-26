package com.back.back.common.object;

import com.back.back.entity.TrendBoardImageEntity;

import lombok.Getter;

@Getter
public class TrendBoardImageListItem {

    private Integer trendBoardImageNumber;
    private String trendBoardImageUrl;

    private TrendBoardImageListItem(TrendBoardImageEntity trendBoardImageEntity) throws Exception {
        
        trendBoardImageNumber = trendBoardImageEntity.getTrendBoardImageNumber();
        trendBoardImageUrl = trendBoardImageEntity.getTrendBoardImageUrl();
    }

}
