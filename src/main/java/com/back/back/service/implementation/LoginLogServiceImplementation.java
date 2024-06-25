package com.back.back.service.implementation;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.loginlog.GetTotalVisitorsResponseDto;
import com.back.back.dto.response.loginlog.GetVisitorsTodayResponseDto;
import com.back.back.repository.LoginLogRepository;
import com.back.back.service.LoginLogService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginLogServiceImplementation implements LoginLogService {
    private final LoginLogRepository loginLogRepository;

    @Override
    public ResponseEntity<? super GetTotalVisitorsResponseDto> getTotalVisitors(Integer sequence) {
        try {
            long totalVisitors = loginLogRepository.count();
            return GetTotalVisitorsResponseDto.success((int) totalVisitors);
        } 
	    catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetVisitorsTodayResponseDto> getVisitorsToday(String loginDate) {
        try {
            Date now = Date.from(Instant.now());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String todayDate = simpleDateFormat.format(now);
            int visitorsToday = loginLogRepository.countByLoginDate(todayDate);
            return GetVisitorsTodayResponseDto.success(visitorsToday);
    } 
	    catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
    }
    }
}