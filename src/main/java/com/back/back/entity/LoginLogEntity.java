package com.back.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.back.back.dto.request.loginLog.getLoginLogRequestDto;
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

@Entity(name = "logninLog")
@Table(name = "login_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginLogEntity {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sequence;
	private String loginId;
	private String loginDate;

	public LoginLogEntity(getLoginLogRequestDto dto , String userId) {
		Date now = Date.from(Instant.now());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String loginDate = simpleDateFormat.format(now);

		this.loginId = dto.getLoginId();
		this.loginDate = loginDate;
	} 

	// public void increaseTrendBoardLikeCount() {
	// 	this.trendBoardLikeCount++;
	// }

	// public void decreaseTrendBoardLikeCount() {
	// 	this.trendBoardLikeCount--;
	// }

}
