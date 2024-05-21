package com.back.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.back.back.common.util.ChangeDateFormatUtil;
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
        String writeDatetime = ChangeDateFormatUtil.changeYYMMDD(designerBoardEntity.getDesignerBoardWriteDatetime());

        String writerId = designerBoardEntity.getDesignerBoardWriterId();
        writerId =
        writerId.substring(0, 1) + 
        "*".repeat(writerId.length() - 1);

        this.designerBoardNumber = designerBoardEntity.getDesignerBoardNumber();
        this.designerBoardTitle = designerBoardEntity.getDesignerBoardTitle();
        this.designerBoardWriterId = writerId;
        this.designerBoardWriteDatetime = writeDatetime;
        this.designerBoardViewCount = designerBoardEntity.getDesignerBoardViewCount();

    }

    public static List<DesignerBoardListItem>getList(List<DesignerBoardEntity> designerBoardEntities) throws Exception {
        List<DesignerBoardListItem> designerBoardList = new ArrayList<>();

        for (DesignerBoardEntity designerBoardEntity: designerBoardEntities) {
            DesignerBoardListItem designerBoardListItem = new DesignerBoardListItem(designerBoardEntity);
            designerBoardList.add(designerBoardListItem);
        }

        return designerBoardList;
    }
}
