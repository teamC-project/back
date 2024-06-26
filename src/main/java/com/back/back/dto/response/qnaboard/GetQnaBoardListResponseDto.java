package com.back.back.dto.response.qnaboard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.entity.QnaBoardEntity;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.common.object.QnaBoardListItem;

import lombok.Getter;

@Getter
public class GetQnaBoardListResponseDto extends ResponseDto {

	private List<QnaBoardListItem> qnaBoardList;

	private GetQnaBoardListResponseDto(List<QnaBoardEntity> qnaBoardEntities) throws Exception {

		super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
		this.qnaBoardList = QnaBoardListItem.getQnaBoardList(qnaBoardEntities);
	}

	public static ResponseEntity<GetQnaBoardListResponseDto> success(List<QnaBoardEntity> qnaBoardEntities) throws Exception{

		GetQnaBoardListResponseDto responseBody = new GetQnaBoardListResponseDto(qnaBoardEntities);
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
	
}
