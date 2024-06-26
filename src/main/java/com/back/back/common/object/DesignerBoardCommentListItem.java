package com.back.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.DesignerBoardCommentEntity;

import lombok.Getter;

@Getter
public class DesignerBoardCommentListItem {

    private Integer designerBoardCommentNumber;
    private String designerBoardCommentWriterId;
    private String designerBoardCommentContents;
    private String designerBoardCommentWriteDatetime;
    private Integer designerBoardParentCommentNumber;

    private DesignerBoardCommentListItem(DesignerBoardCommentEntity designerBoardCommentEntity) throws Exception {

        this.designerBoardCommentNumber = designerBoardCommentEntity.getDesignerBoardCommentNumber();
        this.designerBoardCommentWriterId = designerBoardCommentEntity.getDesignerBoardCommentWriterId();
        this.designerBoardCommentContents = designerBoardCommentEntity.getDesignerBoardCommentContents();
        this.designerBoardCommentWriteDatetime = ChangeDateFormatUtil.changeYYYYMMDDHHMM(designerBoardCommentEntity.getDesignerBoardCommentWriteDatetime());
        this.designerBoardParentCommentNumber = designerBoardCommentEntity.getDesignerBoardParentCommentNumber();
    }

    public static List<DesignerBoardCommentListItem> getList(List<DesignerBoardCommentEntity> designerBoardCommentEntities) throws Exception {

        List<DesignerBoardCommentListItem> designerBoardCommentList = new ArrayList<>();
        for (DesignerBoardCommentEntity designerBoardCommentEntity : designerBoardCommentEntities) {

            DesignerBoardCommentListItem designerBoardCommentListItem = new DesignerBoardCommentListItem(designerBoardCommentEntity);
            designerBoardCommentList.add(designerBoardCommentListItem);
        }

        return designerBoardCommentList;
    }

}
