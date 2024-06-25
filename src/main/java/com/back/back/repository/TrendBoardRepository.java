package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.TrendBoardEntity;

@Repository
public interface TrendBoardRepository extends JpaRepository<TrendBoardEntity, Integer> {
<<<<<<< HEAD
	List<TrendBoardEntity> findByOrderByTrendBoardNumberDesc();
	List<TrendBoardEntity> findByTrendBoardTitleOrderByTrendBoardNumberDesc(String trendBoardTitle);
	TrendBoardEntity findByTrendBoardNumber(Integer trendBoardNumber);
	boolean existsByTrendBoardNumber(Integer trendBoardNumber);
=======
    
	boolean existsByTrendBoardNumber(Integer trendBoardNumber);

    TrendBoardEntity findByTrendBoardNumber(Integer trendBoardNumber);
    
    List<TrendBoardEntity> findByOrderByTrendBoardNumberDesc();
    List<TrendBoardEntity> findByTrendBoardTitleOrderByTrendBoardNumberDesc(String trendBoardTitle);
    
>>>>>>> 8233bf14626911f72de1b65a4c0c6356778ad8a4
}
