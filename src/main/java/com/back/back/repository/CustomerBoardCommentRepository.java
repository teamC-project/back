package com.back.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.back.back.entity.CustomerBoardCommentEntity;

@Repository
public interface CustomerBoardCommentRepository extends JpaRepository<CustomerBoardCommentEntity, Integer> {
    
    CustomerBoardCommentEntity findByCustomerBoardCommentNumber(int customerBoardCommentNumber);
    
    List<CustomerBoardCommentEntity> findByCustomerBoardNumberOrderByCustomerBoardCommentNumberDesc(int customerBoardNumber);
    
}
