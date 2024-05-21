package com.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.CustomerBoardCommentEntity;

@Repository
public interface CustomerBoardCommentRepository extends JpaRepository<CustomerBoardCommentEntity, Integer> {
    
    CustomerBoardCommentEntity findByCustomerBoardCommentNumber(int customerBoardCommentNumber);
    
}