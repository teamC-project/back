package com.back.back.common.object;

import com.back.back.entity.DesignerBoardEntity;

import lombok.Getter;

@Getter
public class DesignerBoardListItem {
    private Integer designerBoardNumber;
    private String designerBoardTitle;
    private String designerBoardWriterId;
    private String designerBoardWriteDatetime;
    private Integer designerBoardViewCount;

    private DesignerBoardListItem(DesignerBoardEntity designerBoardEntity) throws Exception {

    }
}
