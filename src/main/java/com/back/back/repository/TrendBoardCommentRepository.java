package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.TrendBoardCommentEntity;

@Repository
public interface TrendBoardCommentRepository extends JpaRepository<TrendBoardCommentEntity, Integer> {
<<<<<<< HEAD
	TrendBoardCommentEntity findByTrendBoardCommentNumber(Integer trendBoardCommentNumber);

	List<TrendBoardCommentEntity> findByTrendBoardNumberOrderByTrendBoardCommentNumberDesc(int trendBoardNumber);
=======
    
    TrendBoardCommentEntity findByTrendBoardCommentNumber(Integer trendBoardCommentNumber);

    List<TrendBoardCommentEntity> findByTrendBoardNumberOrderByTrendBoardCommentNumberDesc(int trendBoardNumber);
    
>>>>>>> 8233bf14626911f72de1b65a4c0c6356778ad8a4
}
