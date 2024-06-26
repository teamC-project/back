package com.back.back.entity;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.dto.request.trend.PutTrendBoardCommentRequestDto;
import com.back.back.dto.request.trend.PostTrendBoardCommentRequestDto;

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
@Table(name = "trend_board_comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrendBoardCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trendBoardCommentNumber;

    private Integer trendBoardNumber;

    private String trendBoardCommentWriterId;

    private String trendBoardCommentContents;

    private String trendBoardCommentWriteDatetime;

    private Integer trendBoardParentCommentNumber;

    public TrendBoardCommentEntity(PostTrendBoardCommentRequestDto dto, Integer trendBoardNumber, String userId) {

        this.trendBoardNumber = trendBoardNumber;
        this.trendBoardCommentContents = dto.getTrendBoardCommentContents();
        this.trendBoardCommentWriterId = userId;
        this.trendBoardCommentWriteDatetime = ChangeDateFormatUtil.getCurrentDatetiem();
        this.trendBoardParentCommentNumber = null;
    }

    public void update(PutTrendBoardCommentRequestDto dto) {
        
    this.trendBoardCommentContents = dto.getTrendBoardCommentContents();
    }
    
}
