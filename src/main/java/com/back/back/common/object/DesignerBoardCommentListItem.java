package com.back.back.common.object;

import java.util.List;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.DesignerBoardCommentEntity;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class DesignerBoardCommentListItem {
  private Integer designerBoardCommentNumber;
  private Integer designerBoardNumber;
  private String designerBoardCommentWriterId;
  private String designerBoardCommentWriteDatetime;
  private String designerBoardCommentContents;

  private DesignerBoardCommentListItem(DesignerBoardCommentEntity designerBoardCommentEntity) throws Exception {
    String writeDatetime = ChangeDateFormatUtil
        .changeYYMMDD(designerBoardCommentEntity.getDesignerBoardCommentWriteDatetime());



    this.designerBoardCommentNumber = designerBoardCommentEntity.getDesignerBoardCommentNumber();
    this.designerBoardCommentWriterId = designerBoardCommentEntity.getDesignerBoardCommentWriterId();
    this.designerBoardCommentWriteDatetime = writeDatetime;
    this.designerBoardCommentContents = designerBoardCommentEntity.getDesignerBoardCommentContents();

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
