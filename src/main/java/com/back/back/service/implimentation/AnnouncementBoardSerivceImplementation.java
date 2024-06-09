package com.back.back.service.implimentation;


import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.back.dto.request.announcement.PostAnnouncementBoardRequestDto;
import com.back.back.dto.request.announcement.PutAnnouncementBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.announcementboard.GetAnnouncementBoardListResponseDto;
import com.back.back.dto.response.announcementboard.GetAnnouncementBoardResponseDto;
import com.back.back.dto.response.announcementboard.GetSearchAnnouncementBoardLIstResponseDto;
import com.back.back.entity.AnnouncementBoardEntity;
import com.back.back.repository.AnnouncementBoardRepository;
import com.back.back.repository.UserRepository;
import com.back.back.service.AnnouncementBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnnouncementBoardSerivceImplementation implements AnnouncementBoardService {

    private final AnnouncementBoardRepository announcementBoardRepository;
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<ResponseDto> postAnnouncementBoard(PostAnnouncementBoardRequestDto dto, String userId) {
        try {

            boolean isExistUser = userRepository.existsByUserId(userId);
            if(!isExistUser) return ResponseDto.authenticationFailed();

            AnnouncementBoardEntity announcementBoardEntity = new AnnouncementBoardEntity(dto, userId);
            announcementBoardRepository.save(announcementBoardEntity); 

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
    @Override
    public ResponseEntity<? super GetAnnouncementBoardListResponseDto> getAnnouncementBoardList() {
        try {
            List<AnnouncementBoardEntity> announcementBoardEntity = announcementBoardRepository.findByOrderByAnnouncementBoardNumberDesc();
            return GetAnnouncementBoardListResponseDto.success(announcementBoardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

    }
    @Override
    public ResponseEntity<? super GetSearchAnnouncementBoardLIstResponseDto> getSearchAnnouncementBoardList(String announcementBoardSearchWord) {
		try {

			List<AnnouncementBoardEntity> announcementBoardEntities = announcementBoardRepository.findByAnnouncementBoardTitleOrderByAnnouncementBoardNumberDesc(announcementBoardSearchWord);
			return GetSearchAnnouncementBoardLIstResponseDto.success(announcementBoardEntities);

	} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
	}
    }
    @Override
    public ResponseEntity<? super GetAnnouncementBoardResponseDto> getAnnouncementBoard(int announcementBoardNumber) {
		try {
			AnnouncementBoardEntity announcementBoardEntity = announcementBoardRepository.findByAnnouncementBoardNumber(announcementBoardNumber);
            if (announcementBoardEntity == null) return ResponseDto.noExistBoard();
            return GetAnnouncementBoardResponseDto.success(announcementBoardEntity);
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
    }
    @Override
    public ResponseEntity<ResponseDto> putAnnouncementBoard(PutAnnouncementBoardRequestDto dto,
            int announcementBoardNumber, String userId) {
            
        try {
            AnnouncementBoardEntity announcementBoardEntity = announcementBoardRepository.findByAnnouncementBoardNumber(announcementBoardNumber);
            if (announcementBoardEntity == null ) return ResponseDto.noExistBoard();

            String writerId  = announcementBoardEntity.getAnnouncementBoardWriterId();
            boolean isWriter = userId.equals(writerId);
            if (!isWriter) return ResponseDto.authorizationFailed();

            announcementBoardEntity.updateAnnouncementBoard(dto);
            announcementBoardRepository.save(announcementBoardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
    @Override
    public ResponseEntity<ResponseDto> increaseAnnouncementBoardViewCount(int announcementBoardNumber) {
        try {

            AnnouncementBoardEntity announcementBoardEntity = announcementBoardRepository.findByAnnouncementBoardNumber(announcementBoardNumber);
            if (announcementBoardEntity == null) return ResponseDto.noExistBoard();
        
            announcementBoardEntity.increaseAnnoucementBoardViewCount();
            announcementBoardRepository.save(announcementBoardEntity);
        
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    } 
}