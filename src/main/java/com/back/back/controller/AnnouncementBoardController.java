package com.back.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.back.back.dto.response.ResponseDto;
import com.back.back.service.AnnouncementBoardService;
import com.back.back.dto.request.announcement.PutAnnouncementBoardRequestDto;
import com.back.back.dto.request.announcement.PostAnnouncementBoardRequestDto;
import com.back.back.dto.response.announcementboard.GetAnnouncementBoardResponseDto;
import com.back.back.dto.response.announcementboard.GetAnnouncementBoardListResponseDto;
import com.back.back.dto.response.announcementboard.GetSearchAnnouncementBoardListResponseDto;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/service/announcement_board")
@RequiredArgsConstructor
public class AnnouncementBoardController {

    private final AnnouncementBoardService announcementBoardService;

    @GetMapping("/")
    public ResponseEntity<? super GetAnnouncementBoardListResponseDto> getAnnouncementBoardList(
        ){
            ResponseEntity< ? super GetAnnouncementBoardListResponseDto> response = announcementBoardService.getAnnouncementBoardList();
        return response;
    }

    @GetMapping("/search")
    public ResponseEntity<? super GetSearchAnnouncementBoardListResponseDto> getSearchAnnouncementBoardList(
        @RequestParam("word") String word
        ) {
            ResponseEntity <? super GetSearchAnnouncementBoardListResponseDto> response = announcementBoardService.getSearchAnnouncementBoardList(word);
        return response;
    }

    @GetMapping("/{announcementBoardNumber}") 
    public ResponseEntity<? super GetAnnouncementBoardResponseDto> getAnnouncementBoard(
        @PathVariable("announcementBoardNumber") int announcementBoardNumber
        ) {
            ResponseEntity<? super GetAnnouncementBoardResponseDto> response = announcementBoardService.getAnnouncementBoard(announcementBoardNumber);
        return response;
    }

    @PostMapping("/write")
    public ResponseEntity<ResponseDto> postAnnouncementBoard (
        @RequestBody @Valid PostAnnouncementBoardRequestDto requestBody,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = announcementBoardService.postAnnouncementBoard(requestBody, userId);
        return response;
    }

    @PutMapping("/{announcementBoardNumber}")
    public ResponseEntity<ResponseDto> putAnnouncementBoard (
        @RequestBody @Valid PutAnnouncementBoardRequestDto requestBody,
        @PathVariable("announcementBoardNumber") int announcementBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response = announcementBoardService.putAnnouncementBoard(requestBody, announcementBoardNumber, userId);
        return response;
    }

	@PatchMapping("/{announcementBoardNumber}/increase_view_count") 
	public ResponseEntity<ResponseDto> increaseAnnouncementBoardViewCount (
        @PathVariable("announcementBoardNumber") int announcementBoardNumber
        ) {
            ResponseEntity<ResponseDto> response  = announcementBoardService.increaseAnnouncementBoardViewCount(announcementBoardNumber);
        return response;
	}

	@DeleteMapping("/{announcementBoardNumber}")
	public ResponseEntity<ResponseDto> deleteAnnouncementBoard (
        @PathVariable("announcementBoardNumber") int announcementBoardNumber,
        @AuthenticationPrincipal String userId
        ) {
            ResponseEntity<ResponseDto> response  = announcementBoardService.deleteAnnouncementBoard(announcementBoardNumber, userId);
        return response;
	}

}