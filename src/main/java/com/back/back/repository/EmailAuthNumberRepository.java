package com.back.back.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.back.back.entity.EmailAuthNumberEntity;

@Repository
public interface EmailAuthNumberRepository extends JpaRepository<EmailAuthNumberEntity, String> {

    boolean existsByEmailAndAuthNumber(String email, String authNumber);
    
}
