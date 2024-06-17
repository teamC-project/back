package com.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.back.entity.LikeEntity;
import com.back.back.entity.primaryKey.LikePk;

import jakarta.transaction.Transactional;

public interface LikeRepository extends JpaRepository<LikeEntity, LikePk> {
	boolean existsByUserIdAndTrendBoardNumber(String userId, Integer trendBoardNumber);

	@Transactional
	void deleteByTrendBoardNumber(Integer trendBoardNumber);
}
