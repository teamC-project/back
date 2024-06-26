package com.back.back.entity;

import com.back.back.entity.primaryKey.LikePk;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "like_table")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(LikePk.class)
public class LikeEntity {
    
	@Id
	private String userId;

	@Id
	private int trendBoardNumber;
	
}
