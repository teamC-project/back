package com.back.back.entity;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.dto.request.designer.PutDesignerBoardCommentRequestDto;
import com.back.back.dto.request.designer.PostDesignerBoardCommentRequestDto;

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
@Table(name="designer_board_comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DesignerBoardCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer designerBoardCommentNumber;

    private Integer designerBoardNumber;

    private String designerBoardCommentWriterId;

    private String designerBoardCommentContents;

    private String designerBoardCommentWriteDatetime;

    private Integer designerBoardParentCommentNumber;

    public DesignerBoardCommentEntity (PostDesignerBoardCommentRequestDto dto, Integer designerBoardNumber, String userId) {

        this.designerBoardNumber = designerBoardNumber;
        this.designerBoardCommentContents = dto.getDesignerBoardCommentContents();
        this.designerBoardCommentWriterId = userId;
        this.designerBoardCommentWriteDatetime = ChangeDateFormatUtil.getCurrentDatetiem();
        this.designerBoardParentCommentNumber = null;
    }

    public DesignerBoardCommentEntity(PostDesignerBoardCommentRequestDto dto, Integer designerBoardNumber, String userId, Integer parentCommentNumber) {

        this.designerBoardNumber = designerBoardNumber;
        this.designerBoardCommentContents = dto.getDesignerBoardCommentContents();
        this.designerBoardCommentWriterId = userId;
        this.designerBoardCommentWriteDatetime = ChangeDateFormatUtil.getCurrentDatetiem();
        this.designerBoardParentCommentNumber = parentCommentNumber;
    }

    public void update (PutDesignerBoardCommentRequestDto dto) {
        
        this.designerBoardCommentContents = dto.getDesignerBoardCommentContents();
    }
    
}
