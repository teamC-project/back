package com.back.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.back.back.dto.request.designer.PostDesignerBoardRequestDto;
import com.back.back.dto.request.designer.PutDesignerBoardRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "designer_board")
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
    private String designerBoardComment;
    private Integer designerBoardViewCount;

    public DesignerBoardEntity(PostDesignerBoardRequestDto dto, String userId) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String designerBoardWriteDatetime = simpleDateFormat.format(now);

        this.designerBoardTitle = dto.getDesignerBoardTitle();
        this.designerBoardContents = dto.getDesignerBoardContents();
        this.designerBoardWriterId = userId;
        this.designerBoardWriteDatetime = designerBoardWriteDatetime;
        this.designerBoardViewCount = 0;
    }

    public void DesignerIncreaseViewCount() {
        this.designerBoardViewCount++;  
    }

    public void update (PutDesignerBoardRequestDto dto) {
        this.designerBoardTitle = dto.getDesignerBoardTitle();
        this.designerBoardContents = dto.getDesignerBoardContents();
    }

}
