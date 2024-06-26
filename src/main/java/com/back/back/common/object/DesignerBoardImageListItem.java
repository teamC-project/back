package com.back.back.common.object;

import com.back.back.entity.DesignerBoardImageEntity;

import lombok.Getter;

@Getter
public class DesignerBoardImageListItem {

    private Integer designerBoardImageNumber;
    private String designerBoardImageUrl;

    private DesignerBoardImageListItem(DesignerBoardImageEntity designerBoardImageEntity) throws Exception {
        
        designerBoardImageNumber = designerBoardImageEntity.getDesignerBoardImageNumber();
        designerBoardImageUrl = designerBoardImageEntity.getDesignerBoardImageUrl();
    }

}
