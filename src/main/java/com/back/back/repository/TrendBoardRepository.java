package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.TrendBoardEntity;

@Repository
public interface TrendBoardRepository extends JpaRepository<TrendBoardEntity, Integer> {

	boolean existsByTrendBoardNumber(Integer trendBoardNumber);

	TrendBoardEntity findByTrendBoardNumber(Integer trendBoardNumber);

	List<TrendBoardEntity> findByOrderByTrendBoardNumberDesc();
	List<TrendBoardEntity> findByTrendBoardTitleOrderByTrendBoardNumberDesc(String trendBoardTitle);

}
