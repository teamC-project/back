package com.back.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.back.back.entity.CustomerBoardEntity;

@Repository
public interface CustomerBoardRepository extends JpaRepository<CustomerBoardEntity, Integer> {

    CustomerBoardEntity findByCustomerBoardNumber(int customerBoardNumber);

    List<CustomerBoardEntity> findByOrderByCustomerBoardNumberDesc();
    List<CustomerBoardEntity> findByCustomerBoardTitleContainsOrderByCustomerBoardNumberDesc(String customertitle);
    
}