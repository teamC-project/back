package com.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.back.entity.LoginLogEntity;

import java.time.LocalDate;

@Repository
public interface LoginLogRepository extends JpaRepository<LoginLogEntity, Integer> {

  @Query("SELECT COUNT(l) FROM loginLog l")
  long count();

  @Query("SELECT COUNT(l) FROM loginLog l WHERE l.loginDate = :loginDate")
  Integer countByLoginDate(LocalDate loginDate);
}