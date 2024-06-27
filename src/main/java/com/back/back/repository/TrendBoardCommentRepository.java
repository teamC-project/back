package com.back.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.back.back.entity.TrendBoardCommentEntity;

@Repository
public interface TrendBoardCommentRepository extends JpaRepository<TrendBoardCommentEntity, Integer> {
    
    TrendBoardCommentEntity findByTrendBoardCommentNumber(Integer trendBoardCommentNumber);

    List<TrendBoardCommentEntity> findByTrendBoardNumberOrderByTrendBoardCommentNumberDesc(int trendBoardNumber);
    
}
