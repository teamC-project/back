package com.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.TrendBoardImageEntity;

@Repository
public interface TrendBoardImageRepository extends JpaRepository <TrendBoardImageEntity, Integer> {
	
}
