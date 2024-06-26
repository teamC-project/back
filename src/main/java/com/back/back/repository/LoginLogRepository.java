package com.back.back.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.back.back.entity.LoginLogEntity;

@Repository
public interface LoginLogRepository extends JpaRepository<LoginLogEntity, Integer> {
    
    long count();

    int countByLoginDate(String loginDate);

    LoginLogEntity findByLoginId(String loginId);
    
}