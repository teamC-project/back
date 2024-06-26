package com.back.back.dto.response.announcementboard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.entity.AnnouncementBoardEntity;
import com.back.back.common.object.AnnouncementBoardListItem;

import lombok.Getter;

@Getter
public class GetSearchAnnouncementBoardListResponseDto extends ResponseDto {

	private List<AnnouncementBoardListItem> announcementBoardList;
		
	private GetSearchAnnouncementBoardListResponseDto(List<AnnouncementBoardEntity> announcementBoardEntities) throws Exception {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.announcementBoardList = AnnouncementBoardListItem.getAnnouncementBoardList(announcementBoardEntities);
	}

    public static ResponseEntity<GetSearchAnnouncementBoardListResponseDto> success (List<AnnouncementBoardEntity> announcementBoardEntities) throws Exception{
            
        GetSearchAnnouncementBoardListResponseDto responseBody = new GetSearchAnnouncementBoardListResponseDto(announcementBoardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}

