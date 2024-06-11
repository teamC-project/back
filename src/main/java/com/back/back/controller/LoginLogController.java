package com.back.back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.back.back.service.LoginLogService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/login-log")
@RequiredArgsConstructor
public class LoginLogController {

  private final LoginLogService loginLogService;

  @GetMapping("/total-visitors")
  public int getTotalVisitors() {
    return loginLogService.getTotalVisitors();
  }

  @GetMapping("/visitors-today")
  public int getVisitorsToday() {
    return loginLogService.getVisitorsToday();
  }
}