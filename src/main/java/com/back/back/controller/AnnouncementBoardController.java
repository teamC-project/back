// package com.back.back.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.back.back.dto.request.announcement.PostAnnouncementBoardRequestDto;
// import com.back.back.dto.request.announcement.PutAnnouncementBoardRequestDto;
// import com.back.back.dto.response.ResponseDto;
// import com.back.back.dto.response.announcementboard.GetAnnouncementBoardListResponseDto;
// import com.back.back.dto.response.announcementboard.GetAnnouncementBoardResponseDto;
// import com.back.back.dto.response.announcementboard.GetSearchAnnouncementBoardListResponseDto;
// import com.back.back.service.AnnouncementBoardService;

// import jakarta.validation.Valid;
// import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("/api/v1/announcement_board")
// @RequiredArgsConstructor
// public class AnnouncementBoardController {
//     private final AnnouncementBoardService announcementBoardService;

//     @PostMapping("/")
//     ResponseEntity<ResponseDto> postAnnouncementBoard (
//         @RequestBody @Valid PostAnnouncementBoardRequestDto requestBody,
//         @AuthenticationPrincipal String userId
//     ) {
//         ResponseEntity<ResponseDto> response = announcementBoardService.postAnnouncementBoard(requestBody, userId);
// 		return response;
//     }

//     @PutMapping("/{announcementBoardNumber}")
//     public ResponseEntity<ResponseDto> putAnnouncementBoard (
//         @RequestBody @Valid PutAnnouncementBoardRequestDto requestBody,
//         @PathVariable("announceMentBoardNumber") int announceMentBoardNumber,
//         @AuthenticationPrincipal String userId
//     ) {
//         ResponseEntity<ResponseDto> response = announcementBoardService.putAnnouncementBoard(requestBody, announceMentBoardNumber, userId);
//         return response;
//     }

// 	@GetMapping("/list")
// 	public ResponseEntity<? super GetAnnouncementBoardListResponseDto> getAnnouncementBoardList() {
//     ResponseEntity< ? super GetAnnouncementBoardListResponseDto> response = announcementBoardService.getAnnouncementBoardList();
// 	return response;
// 	}

//     @GetMapping("/list/{searchWord}")
//     public ResponseEntity<? super GetSearchAnnouncementBoardListResponseDto> getSearchAnnouncementBoardList(
//         @RequestParam("searchWord") String searchWord
//     ) {
//         ResponseEntity <? super GetSearchAnnouncementBoardListResponseDto> response = announcementBoardService.getSearchAnnouncementBoardList(searchWord);
//         return response;
//     }

//     @GetMapping("/{announceMentBoardNumber}") 
//     public ResponseEntity<? super GetAnnouncementBoardResponseDto> getAnnouncementBoard(
//         @PathVariable("announcementBoardNumber") int announceMentBoardNumber
//     ) {
//         ResponseEntity<? super GetAnnouncementBoardResponseDto> response = announcementBoardService.getAnnounceMentBoard(announceMentBoardNumber);
//         return response;
//     }

//     @GetMapping("/{announceMentBoardNumber}")
//     public ResponseEntity<ResponseDto> increaseAnnouncementBoardViewCount(
//         @PathVariable("announceMentBoardNumber") int announceMentBoardNumber,
//         @AuthenticationPrincipal String userId
//     ) {
//                 ResponseEntity<ResponseDto> response = announcementBoardService.increaseAnnouncementBoardViewCount(announceMentBoardNumber);
//                 return response;
//     }
// }