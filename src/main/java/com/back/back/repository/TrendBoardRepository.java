package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.TrendBoardEntity;
@Repository
public interface TrendBoardRepository extends JpaRepository<TrendBoardEntity, Integer> {
  List<TrendBoardEntity> findByOrderByTrendBoardNumberDesc();

  List<TrendBoardEntity> findByTrendBoardTitleOrderByTrendBoardNumberDesc(String trendBoardTitle);

  TrendBoardEntity findByTrendBoardNumber(Integer trendBoardNumber);
	boolean existsByTrendBoardNumber(Integer trendBoardNumber);
	
}
