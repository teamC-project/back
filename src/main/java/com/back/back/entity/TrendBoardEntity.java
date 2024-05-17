package com.back.back.entity;

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
	private String trendBoardTitleImage;
	private String trendBoardTitle;
	private String trendBoardContents;
	private String trendBoardWriterId;
	private String trendBoardDateTime;
	private Integer trendBoardLikeCount;
}
