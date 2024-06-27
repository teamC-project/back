package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.back.entity.LikeEntity;
import com.back.back.entity.primaryKey.LikePk;

import jakarta.transaction.Transactional;

public interface LikeRepository extends JpaRepository<LikeEntity, LikePk> {
	
	boolean existsByUserIdAndTrendBoardNumber(String userId, Integer trendBoardNumber);

	List<LikeEntity> findByTrendBoardNumber(int trendBoardNumber);

	@Transactional
	void deleteByTrendBoardNumber(Integer trendBoardNumber);

}
