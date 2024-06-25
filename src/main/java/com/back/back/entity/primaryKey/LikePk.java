package com.back.back.entity.primaryKey;
import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
