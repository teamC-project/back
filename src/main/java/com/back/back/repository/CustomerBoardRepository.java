package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.CustomerBoardEntity;

@Repository
public interface CustomerBoardRepository extends JpaRepository<CustomerBoardEntity, Integer> {
    
    List<CustomerBoardEntity> findByOrderByCustomerBoardNumberDesc();
    
    List<CustomerBoardEntity> findByCustomerBoardTitleContainsOrderByCustomerBoardNumberDesc(String customertitle);
    
    CustomerBoardEntity findByCustomerBoardNumber(int customerBoardNumber);
    
}