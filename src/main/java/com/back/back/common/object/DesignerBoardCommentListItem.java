package com.back.back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.DesignerBoardCommentEntity;

import lombok.Getter;

@Getter
public class DesignerBoardCommentListItem {
  private Integer designerBoardCommentNumber;
  private Integer designerBoardNumber;
  private String designerBoardCommentWriterId;
  private String designerBoardCommentWriteDatetime;
  private String designerBoardCommentContents;
  private Integer designerBoardParentCommentNumber;

  private DesignerBoardCommentListItem(DesignerBoardCommentEntity designerBoardCommentEntity) throws Exception {
    String writeDatetime = ChangeDateFormatUtil
        .changeYYYYMMDDHHMM(designerBoardCommentEntity.getDesignerBoardCommentWriteDatetime());

    this.designerBoardCommentNumber = designerBoardCommentEntity.getDesignerBoardCommentNumber();
    this.designerBoardCommentWriterId = designerBoardCommentEntity.getDesignerBoardCommentWriterId();
    this.designerBoardCommentWriteDatetime = writeDatetime;
    this.designerBoardCommentContents = designerBoardCommentEntity.getDesignerBoardCommentContents();
    this.designerBoardParentCommentNumber = designerBoardCommentEntity.getDesignerBoardParentCommentNumber(); // 부모 댓글
  }

  public static List<DesignerBoardCommentListItem> getList(
      List<DesignerBoardCommentEntity> designerBoardCommentEntities) throws Exception {
    List<DesignerBoardCommentListItem> designerBoardCommentList = new ArrayList<>();

    for (DesignerBoardCommentEntity designerBoardCommentEntity : designerBoardCommentEntities) {
      DesignerBoardCommentListItem designerBoardCommentListItem = new DesignerBoardCommentListItem(
          designerBoardCommentEntity);
      designerBoardCommentList.add(designerBoardCommentListItem);
    }

    return designerBoardCommentList;
  }
}
