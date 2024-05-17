package com.back.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.back.back.dto.request.trend.PostTrendBoardRequestDto;
import com.back.back.dto.request.trend.PutTrendBoardRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "trendBoard")
@Table(name = "trend_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrendBoardEntity {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trendBoardNumber;
	private String trendBoardTitle;
	private String trendBoardContents;
	private String trendBoardWriterId;
	private String trendBoardWriteDateTime;
	private Integer trendBoardLikeCount;


	public TrendBoardEntity(PostTrendBoardRequestDto dto , String userId) {
		Date now = Date.from(Instant.now());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String trendBoardWriteDatetime = simpleDateFormat.format(now);

		this.trendBoardTitle = dto.getTrendBoardTitle();
		this.trendBoardContents = dto.getTrendBoardContents();
		this.trendBoardWriterId = userId;
		this.trendBoardWriteDateTime = trendBoardWriteDatetime;
		this.trendBoardLikeCount = 0;
	} 

	public void TrendIncreaseLikeCount() {
		this.trendBoardLikeCount++;
	}

	public void TrendDecreaseLikeCount() {
		this.trendBoardLikeCount--;
	}

	public void updateTrendBoard (PutTrendBoardRequestDto dto ) {
		this.trendBoardTitle = dto.getTrendBoardTitle();
		this.trendBoardContents = dto.getTrendBoardContents();
	}
}
