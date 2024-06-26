package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back.service.LoginLogService;
import com.back.back.dto.response.loginlog.GetTotalVisitorsResponseDto;
import com.back.back.dto.response.loginlog.GetVisitorsTodayResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/login-log")
@RequiredArgsConstructor
public class LoginLogController {

    private final LoginLogService loginLogService;

    @GetMapping("/total-visitors")
    public ResponseEntity<? super GetTotalVisitorsResponseDto> getTotalVisitors() {
        return loginLogService.getTotalVisitors(null);
    }

    @GetMapping("/visitors-today")
    public ResponseEntity<? super GetVisitorsTodayResponseDto> getVisitorsToday() {
        return loginLogService.getVisitorsToday(null);
    }
    
}