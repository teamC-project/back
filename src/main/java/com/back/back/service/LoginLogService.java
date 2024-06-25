package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.loginlog.GetTotalVisitorsResponseDto;
import com.back.back.dto.response.loginlog.GetVisitorsTodayResponseDto;

public interface LoginLogService {

    ResponseEntity<? super GetTotalVisitorsResponseDto> getTotalVisitors(Integer sequence);
    ResponseEntity<? super GetVisitorsTodayResponseDto> getVisitorsToday(String loginDate);
    
}
