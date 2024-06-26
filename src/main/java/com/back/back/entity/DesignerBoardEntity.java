package com.back.back.entity;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.dto.request.designer.PutDesignerBoardRequestDto;
import com.back.back.dto.request.designer.PostDesignerBoardRequestDto;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "designer_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DesignerBoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer designerBoardNumber;

    private String designerBoardTitle;

    private String designerBoardContents;

    private String designerBoardWriterId;

    private String designerBoardWriteDatetime;

    private Integer designerBoardViewCount;

    public DesignerBoardEntity(PostDesignerBoardRequestDto dto, String userId) {

        this.designerBoardTitle = dto.getDesignerBoardTitle();
        this.designerBoardContents = dto.getDesignerBoardContents();
        this.designerBoardWriterId = userId;
        this.designerBoardWriteDatetime = ChangeDateFormatUtil.getCurrentDatetiem();
        this.designerBoardViewCount = 0;
    }

    public void designerIncreaseViewCount() {

        this.designerBoardViewCount++;  
    }

    public void update (PutDesignerBoardRequestDto dto) {

        this.designerBoardTitle = dto.getDesignerBoardTitle();
        this.designerBoardContents = dto.getDesignerBoardContents();
    }
    
}
