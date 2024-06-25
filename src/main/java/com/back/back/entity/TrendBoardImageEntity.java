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

@Entity
@Table(name = "trend_board_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrendBoardImageEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trendBoardImageNumber;
	private String trendBoardImageUrl;
	private Integer trendBoardNumber;

	public TrendBoardImageEntity(Integer trendBoardNumber, String trendBoardImageUrl) {
		this.trendBoardNumber = trendBoardNumber;
		this.trendBoardImageUrl = trendBoardImageUrl;
	}
}


