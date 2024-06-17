package com.back.back.entity;

import com.back.back.entity.primaryKey.LikePk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name ="likeTable")
@Table(name = "like_table")
@IdClass(LikePk.class)
public class LikeEntity {
	@Id
	private String userId;
	@Id
	private int trendBoardNumber;
}
