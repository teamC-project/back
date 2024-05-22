package com.back.back.dto.response.announcementboard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.back.back.common.object.AnnouncementBoardListItem;
import com.back.back.dto.response.ResponseCode;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.ResponseMessage;
import com.back.back.entity.AnnouncementBoardEntity;

import lombok.Getter;

@Getter
public class GetSearchAnnouncementBoardListResponseDto extends ResponseDto {
			private List<AnnouncementBoardListItem> announcementBoardList;
		
			private GetSearchAnnouncementBoardListResponseDto(List<AnnouncementBoardEntity> announcementBoardEntities) throws Exception {
				super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
				this.announcementBoardList = AnnouncementBoardListItem.getAnnouncementBoardList(announcementBoardEntities);
			}
<<<<<<< HEAD

			public static ResponseEntity<GetSearchAnnouncementBoardListResponseDto>
			success (List<AnnouncementBoardEntity> announcementBoardEntities) throws Exception{
				GetSearchAnnouncementBoardListResponseDto responseBody = new GetSearchAnnouncementBoardListResponseDto(announcementBoardEntities);
				return ResponseEntity.status(HttpStatus.OK).body(responseBody);
			}
}
=======
      
      public static ResponseEntity<GetSearchAnnouncementBoardListResponseDto>
      success (List<AnnouncementBoardEntity> announcementBoardEntities) throws Exception{
        GetSearchAnnouncementBoardListResponseDto responseBody = new GetSearchAnnouncementBoardListResponseDto(announcementBoardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
      }
    }
    
>>>>>>> 97c62b7b9db2154356dd05eedaa9b3680e541b98
