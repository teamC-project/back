package com.back.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.back.back.dto.request.trend.PostTrendBoardCommentRequestDto;
import com.back.back.dto.request.trend.PutTrendBoardCommentRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "trendBoardComment")
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

  public TrendBoardCommentEntity(
      PostTrendBoardCommentRequestDto dto, Integer trendBoardNumber, String userId) {
    Date now = Date.from(Instant.now());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String trendBoardCommentWriteDatetime = simpleDateFormat.format(now);

    this.trendBoardNumber = trendBoardNumber;
    this.trendBoardCommentContents = dto.getTrendBoardCommentContents();
    this.trendBoardCommentWriterId = userId;
    this.trendBoardCommentWriteDatetime = trendBoardCommentWriteDatetime;
  }

  public void update(PutTrendBoardCommentRequestDto dto) {
    this.trendBoardCommentContents = dto.getTrendBoardCommentContents();
  }
}
