package com.back.back.common.object;

import com.back.back.entity.DesignerBoardImageEntity;

import lombok.Getter;

@Getter
public class DesignerBoardImageListItem {

    private String designerBoardImageUrl;
    private Integer designerBoardImageNumber;

    private DesignerBoardImageListItem(DesignerBoardImageEntity designerBoardImageEntity) throws Exception {
        
        designerBoardImageUrl = designerBoardImageEntity.getDesignerBoardImageUrl();
        designerBoardImageNumber = designerBoardImageEntity.getDesignerBoardImageNumber();
    }

}
