package com.back.back.service;

import org.springframework.http.ResponseEntity;

import com.back.back.dto.request.announcement.PostAnnouncementBoardRequestDto;
import com.back.back.dto.request.announcement.PutAnnouncementBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.announcementboard.GetAnnouncementBoardListResponseDto;
import com.back.back.dto.response.announcementboard.GetAnnouncementBoardResponseDto;
import com.back.back.dto.response.announcementboard.GetSearchAnnouncementBoardListResponseDto;

public interface AnnouncementBoardService {
<<<<<<< HEAD
	ResponseEntity<ResponseDto> postAnnouncementBoard(PostAnnouncementBoardRequestDto dto , String userId);
	ResponseEntity<? super GetAnnouncementBoardListResponseDto> getAnnouncementBoardList();
	ResponseEntity<? super GetSearchAnnouncementBoardListResponseDto> getSearchAnnouncementBoardList(String announcementBoardSearchWord);
	ResponseEntity<? super GetAnnouncementBoardResponseDto> getAnnouncementBoard(int announcementBoardNumber);
	ResponseEntity<ResponseDto> putAnnouncementBoard(PutAnnouncementBoardRequestDto dto, int announcementBoardNumber, String userId);
	ResponseEntity<ResponseDto> deleteAnnouncementBoard(int announcementBoardNumber, String userId);
	ResponseEntity<ResponseDto> increaseAnnouncementBoardViewCount(int announcementBoardNumber);
=======

    ResponseEntity<ResponseDto> postAnnouncementBoard(PostAnnouncementBoardRequestDto dto , String userId);
    ResponseEntity<ResponseDto> putAnnouncementBoard(PutAnnouncementBoardRequestDto dto, int announcementBoardNumber, String userId);
    ResponseEntity<ResponseDto> deleteAnnouncementBoard(int announcementBoardNumber, String userId);
    ResponseEntity<ResponseDto> increaseAnnouncementBoardViewCount(int announcementBoardNumber);

    ResponseEntity<? super GetAnnouncementBoardListResponseDto> getAnnouncementBoardList();
    ResponseEntity<? super GetSearchAnnouncementBoardListResponseDto> getSearchAnnouncementBoardList(String announcementBoardSearchWord);
    ResponseEntity<? super GetAnnouncementBoardResponseDto> getAnnouncementBoard(int announcementBoardNumber);
    
>>>>>>> 8233bf14626911f72de1b65a4c0c6356778ad8a4
}