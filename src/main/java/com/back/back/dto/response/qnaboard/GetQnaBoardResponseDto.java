package com.back.back.dto.response.qnaboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.entity.QnaBoardEntity;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.common.util.ChangeDateFormatUtil;

import lombok.Getter;

@Getter
public class GetQnaBoardResponseDto extends ResponseDto{
	
	private Integer qnaBoardNumber;
	private Boolean qnaBoardStatus;
	private String qnaBoardTitle;
	private String qnaBoardContents;
	private String qnaBoardWriterId;
	private String qnaBoardWriteDatetime;
	private Integer qnaBoardViewCount;
	private String qnaBoardComment;

	private GetQnaBoardResponseDto(QnaBoardEntity qnaBoardEntity) throws Exception {

		super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
		this.qnaBoardNumber = qnaBoardEntity.getQnaBoardNumber();
		this.qnaBoardStatus = qnaBoardEntity.getQnaBoardStatus();
		this.qnaBoardTitle = qnaBoardEntity.getQnaBoardTitle();
		this.qnaBoardContents = qnaBoardEntity.getQnaBoardContents();
		this.qnaBoardWriterId = qnaBoardEntity.getQnaBoardWriterId();
		this.qnaBoardWriteDatetime = ChangeDateFormatUtil.changeYYYYMMDDHHMM(qnaBoardEntity.getQnaBoardWriteDatetime());
		this.qnaBoardViewCount = qnaBoardEntity.getQnaBoardViewCount();
		this.qnaBoardComment = qnaBoardEntity.getQnaBoardComment();
	}

	public static ResponseEntity<GetQnaBoardResponseDto> success (QnaBoardEntity qnaBoardEntity) throws Exception {

		GetQnaBoardResponseDto responseBody = new GetQnaBoardResponseDto(qnaBoardEntity);
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}

}
