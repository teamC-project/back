package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.request.announcement.PutAnnouncementBoardRequestDto;
import com.back.back.dto.request.announcement.PostAnnouncementBoardRequestDto;
import com.back.back.dto.response.announcementboard.GetAnnouncementBoardResponseDto;
import com.back.back.dto.response.announcementboard.GetAnnouncementBoardListResponseDto;
import com.back.back.dto.response.announcementboard.GetSearchAnnouncementBoardListResponseDto;

public interface AnnouncementBoardService {

	ResponseEntity<ResponseDto> increaseAnnouncementBoardViewCount(int announcementBoardNumber);
	ResponseEntity<ResponseDto> deleteAnnouncementBoard(int announcementBoardNumber, String userId);
	ResponseEntity<ResponseDto> postAnnouncementBoard(PostAnnouncementBoardRequestDto dto , String userId);
	ResponseEntity<ResponseDto> putAnnouncementBoard(PutAnnouncementBoardRequestDto dto, int announcementBoardNumber, String userId);

	ResponseEntity<? super GetAnnouncementBoardListResponseDto> getAnnouncementBoardList();
	ResponseEntity<? super GetAnnouncementBoardResponseDto> getAnnouncementBoard(int announcementBoardNumber);
	ResponseEntity<? super GetSearchAnnouncementBoardListResponseDto> getSearchAnnouncementBoardList(String announcementBoardSearchWord);

}