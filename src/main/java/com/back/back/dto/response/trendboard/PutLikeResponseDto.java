package com.back.back.dto.response.trendboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class PutLikeResponseDto extends ResponseDto {
	
	private PutLikeResponseDto(String code, String message) {
		
		super(code, message);
	}

	public static ResponseEntity<PutLikeResponseDto> success(String code, String message) {

		PutLikeResponseDto responseBody = new PutLikeResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}

}