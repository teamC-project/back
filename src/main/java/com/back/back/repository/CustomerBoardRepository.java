package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.CustomerBoardEntity;

@Repository
public interface CustomerBoardRepository extends JpaRepository<CustomerBoardEntity, Integer> {
    
    List<CustomerBoardEntity> findByOrderByCustomerBoardNumberDesc();
    
<<<<<<< HEAD
    List<CustomerBoardEntity> findByCustomerBoardTitleContainsOrderByCustomerBoardNumberDesc(String customertitle);
=======
    List<CustomerBoardEntity> findByCustomerBoardTitleOrCustomerBoardContentsOrderByCustomerBoardNumberDesc(String title, String content);
>>>>>>> 46d127bca4f7792c7ccf748287f2c28b8df1d82b
    
    CustomerBoardEntity findByCustomerBoardNumber(int customerBoardNumber);
    
}