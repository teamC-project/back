package com.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    boolean existsByUserId(String userId);
    boolean existsByUserPassword(String userPassword);
    boolean existsByUserIdAndUserRole(String userId, String userRole);
    boolean existsByUserEmail(String userEmail);

    UserEntity findByUserId(String userId);
    UserEntity findBySnsId(String snsId);
    UserEntity findByUserEmail(String userEmail);
    
}