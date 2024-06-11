package com.back.back.service.implimentation;

import org.springframework.stereotype.Service;
import com.back.back.repository.LoginLogRepository;
import com.back.back.service.LoginLogService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LoginLogServiceImplimentation implements LoginLogService {

  private final LoginLogRepository loginLogRepository;

  @Override
  public int getTotalVisitors() {
    return (int) loginLogRepository.count();
  }

  @Override
  public int getVisitorsToday() {
    LocalDate today = LocalDate.now();
    return loginLogRepository.countByLoginDate(today);
  }
}