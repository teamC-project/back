// package com.back.back.service.implimentation;


// import java.util.List;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;

// import com.back.back.dto.request.announcement.PostAnnouncementBoardRequestDto;
// import com.back.back.dto.request.announcement.PutAnnouncementBoardRequestDto;
// import com.back.back.dto.response.ResponseDto;
// import com.back.back.dto.response.announcementboard.GetAnnouncementBoardListResponseDto;
// import com.back.back.dto.response.announcementboard.GetAnnouncementBoardResponseDto;
// import com.back.back.dto.response.announcementboard.GetSearchAnnouncementBoardListResponseDto;
// import com.back.back.entity.AnnouncementBoardEntity;
// import com.back.back.repository.AnnounceMentBoardRepository;
// import com.back.back.repository.UserRepository;
// import com.back.back.service.AnnouncementBoardService;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class AnnouncementBoardSerivceImplementation implements AnnouncementBoardService {

//     private final AnnounceMentBoardRepository announceMentBoardRepository;
//     private final UserRepository userRepository;
//     @Override
//     public ResponseEntity<ResponseDto> postAnnouncementBoard(PostAnnouncementBoardRequestDto dto, String userId) {
//         try {

//             boolean isExistUser = userRepository.existsByUserId(userId);
//             if(!isExistUser) return ResponseDto.authenticationFailed();

//             AnnouncementBoardEntity announcementBoardEntity = new AnnouncementBoardEntity(dto, userId);
//             announceMentBoardRepository.save(announcementBoardEntity); 

//         } catch (Exception exception) {
//             exception.printStackTrace();
//             return ResponseDto.databaseError();
//         }
//         return ResponseDto.success();
//     }
//     @Override
//     public ResponseEntity<? super GetAnnouncementBoardListResponseDto> getAnnouncementBoardList() {
//         try {
//             List<AnnouncementBoardEntity> announcementBoardEntity = announceMentBoardRepository.findByOrderByAnnouncementNumberDesc();
//             return GetAnnouncementBoardListResponseDto.success(announcementBoardEntity);

//         } catch (Exception exception) {
//             exception.printStackTrace();
//             return ResponseDto.databaseError();
//         }

//     }
//     @Override
//     public ResponseEntity<? super GetSearchAnnouncementBoardListResponseDto> getSearchAnnouncementBoardList(String announceMentSearchWord) {
// 		try {

// 			List<AnnouncementBoardEntity> announcementBoardEntity = announceMentBoardRepository.findByTitleContainsOrderByAnnouncementBoardNumberDesc(announceMentSearchWord);
// 			return GetSearchAnnouncementBoardListResponseDto.success(announcementBoardEntity);

// 	} catch (Exception exception) {
// 			exception.printStackTrace();
// 			return ResponseDto.databaseError();
// 	}
//     }
//     @Override
//     public ResponseEntity<? super GetAnnouncementBoardResponseDto> getAnnounceMentBoard(int announceMentBoardNumber) {
// 		try {
// 			AnnouncementBoardEntity announcementBoardEntity = announceMentBoardRepository.findByAnnouncementBoardNumber(announceMentBoardNumber);
//             if (announcementBoardEntity == null) return ResponseDto.noExistBoard();
//             return GetAnnouncementBoardResponseDto.success(announcementBoardEntity);
// 		} catch (Exception exception) {
// 			exception.printStackTrace();
// 			return ResponseDto.databaseError();
// 		}
//     }
//     @Override
//     public ResponseEntity<ResponseDto> putAnnouncementBoard(PutAnnouncementBoardRequestDto dto,
//             int announceMentBoardNumber, String userId) {
            
//         try {
//             AnnouncementBoardEntity announcementBoardEntity = announceMentBoardRepository.findByAnnouncementBoardNumber(announceMentBoardNumber);
//             if (announcementBoardEntity == null ) return ResponseDto.noExistBoard();

//             String writerId  = announcementBoardEntity.getAnnounceMentBoardWriterId();
//             boolean isWriter = userId.equals(writerId);
//             if (!isWriter) return ResponseDto.authorizationFailed();

//             announcementBoardEntity.updateAnnouncementBoard(dto);
//             announceMentBoardRepository.save(announcementBoardEntity);
//         } catch (Exception exception) {
//             exception.printStackTrace();
//             return ResponseDto.databaseError();
//         }
//         return ResponseDto.success();
//     }
//     @Override
//     public ResponseEntity<ResponseDto> increaseAnnouncementBoardViewCount(int announceMentBoardNumber) {
//         try {

//             AnnouncementBoardEntity announcementBoardEntity = announceMentBoardRepository.findByAnnouncementBoardNumber(announceMentBoardNumber);
//             if (announcementBoardEntity == null) return ResponseDto.noExistBoard();
        
//             announcementBoardEntity.increaseAnnoucementBoardViewCount();
//             announceMentBoardRepository.save(announcementBoardEntity);
        
//         } catch (Exception exception) {
//             exception.printStackTrace();
//             return ResponseDto.databaseError();
//         }
//         return ResponseDto.success();
//     } 
// }
