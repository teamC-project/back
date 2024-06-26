package com.back.back.dto.response.loginlog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetTotalVisitorsResponseDto extends ResponseDto {

    private Integer totalVisitors;

    public GetTotalVisitorsResponseDto(Integer totalVisitors) {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.totalVisitors = totalVisitors;
    }

    public static ResponseEntity<GetTotalVisitorsResponseDto> success(Integer totalVisitors) {

        GetTotalVisitorsResponseDto responseBody = new GetTotalVisitorsResponseDto(totalVisitors);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
