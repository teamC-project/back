package com.back.back.entity.primaryKey;

import java.io.Serializable;

import jakarta.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LikePk implements Serializable {
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name ="trend_board_number")
	private int trendBoardNumber;

}
