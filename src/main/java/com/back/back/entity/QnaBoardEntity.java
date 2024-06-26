package com.back.back.entity;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.dto.request.qna.PutQnaBoardRequestDto;
import com.back.back.dto.request.qna.PostQnaBoardRequestDto;

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
@Table(name = "qna_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QnaBoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer qnaBoardNumber;

    private Boolean qnaBoardStatus;

    private String qnaBoardTitle;

    private String qnaBoardContents;

    private String qnaBoardWriterId;

    private String qnaBoardWriteDatetime;

    private Integer qnaBoardViewCount;

    private String qnaBoardComment;

    public QnaBoardEntity(PostQnaBoardRequestDto dto, String userId) {

        this.qnaBoardTitle = dto.getQnaBoardTitle();
        this.qnaBoardStatus = false;
        this.qnaBoardContents = dto.getQnaBoardContents();
        this.qnaBoardWriterId = userId;
        this.qnaBoardWriteDatetime = ChangeDateFormatUtil.getCurrentDatetiem();
        this.qnaBoardViewCount = 0;
    }

    public void increaseQnaViewCount() {

        this.qnaBoardViewCount++;
    }

    public void updateQnaBoard(PutQnaBoardRequestDto dto) {

        this.qnaBoardTitle = dto.getQnaBoardTitle();
        this.qnaBoardContents = dto.getQnaBoardContents();
    }
    
}
