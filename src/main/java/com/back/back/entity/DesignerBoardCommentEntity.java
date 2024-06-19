package com.back.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.back.back.dto.request.designer.PostDesignerBoardCommentRequestDto;
import com.back.back.dto.request.designer.PutDesignerBoardCommentRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="designerBoardComment")
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
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String designerBoardCommentWriteDatetime = simpleDateFormat.format(now);

        this.designerBoardNumber = designerBoardNumber;
        this.designerBoardCommentContents = dto.getDesignerBoardCommentContents();
        this.designerBoardCommentWriterId = userId;
        this.designerBoardCommentWriteDatetime = designerBoardCommentWriteDatetime;
        this.designerBoardParentCommentNumber = null;
    }

    // 대댓글 생성 시 사용할 생성자 추가
    public DesignerBoardCommentEntity(PostDesignerBoardCommentRequestDto dto, Integer designerBoardNumber, String userId, Integer parentCommentNumber) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String designerBoardCommentWriteDatetime = simpleDateFormat.format(now);

        this.designerBoardNumber = designerBoardNumber;
        this.designerBoardCommentContents = dto.getDesignerBoardCommentContents();
        this.designerBoardCommentWriterId = userId;
        this.designerBoardCommentWriteDatetime = designerBoardCommentWriteDatetime;
        this.designerBoardParentCommentNumber = parentCommentNumber;
    }

    public void update (PutDesignerBoardCommentRequestDto dto) {
        this.designerBoardCommentContents = dto.getDesignerBoardCommentContents();
    }
}
