package com.back.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.back.back.common.util.ChangeDateFormatUtil;
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

@Entity
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
	private String trendBoardWriteDatetime;
	private Integer trendBoardLikeCount;
	private Integer trendBoardViewCount;
	private String trendBoardThumbnailImage;

	public TrendBoardEntity(PostTrendBoardRequestDto dto , String userId) {

		this.trendBoardTitle = dto.getTrendBoardTitle();
		this.trendBoardContents = dto.getTrendBoardContents();
		this.trendBoardWriterId = userId;
		this.trendBoardWriteDatetime = ChangeDateFormatUtil.getCurrentDatetiem();
		this.trendBoardLikeCount = 0;
		this.trendBoardViewCount = 0;
		this.trendBoardThumbnailImage = dto.getTrendBoardThumbnailImage();
	} 

	public void increaseTrendBoardLikeCount() {
		this.trendBoardLikeCount++;
	}

	public void decreaseTrendBoardLikeCount() {
		this.trendBoardLikeCount--;
	}
	public void increaseTrendBoardViewCount() {
		this.trendBoardViewCount++;
	}

	public void updateTrendBoard (PutTrendBoardRequestDto dto ) {
		this.trendBoardTitle = dto.getTrendBoardTitle();
		this.trendBoardContents = dto.getTrendBoardContents();
	}

}
