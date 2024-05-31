package com.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.CustomerBoardImageEntity;

@Repository
public interface CustomerBoardImageRepository extends JpaRepository <CustomerBoardImageEntity, Integer> {
  
}