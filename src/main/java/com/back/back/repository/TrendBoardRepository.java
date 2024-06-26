package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.TrendBoardEntity;

@Repository
public interface TrendBoardRepository extends JpaRepository<TrendBoardEntity, Integer> {
<<<<<<< HEAD
    
	boolean existsByTrendBoardNumber(Integer trendBoardNumber);

    TrendBoardEntity findByTrendBoardNumber(Integer trendBoardNumber);
    
    List<TrendBoardEntity> findByOrderByTrendBoardNumberDesc();
    List<TrendBoardEntity> findByTrendBoardTitleOrderByTrendBoardNumberDesc(String trendBoardTitle);
    
=======
	List<TrendBoardEntity> findByOrderByTrendBoardNumberDesc();
	List<TrendBoardEntity> findByTrendBoardTitleOrderByTrendBoardNumberDesc(String trendBoardTitle);
	TrendBoardEntity findByTrendBoardNumber(Integer trendBoardNumber);
	boolean existsByTrendBoardNumber(Integer trendBoardNumber);
>>>>>>> c430ef6b1f8c23f3c951503c8b3025ca2245200a
}
