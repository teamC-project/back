package com.back.back.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import com.back.back.entity.QnaBoardEntity;
import com.back.back.service.QnaBoardService;
import com.back.back.dto.response.ResponseDto;
import com.back.back.repository.UserRepository;
import com.back.back.repository.QnaBoardRepository;
import com.back.back.dto.request.qna.PutQnaBoardRequestDto;
import com.back.back.dto.request.qna.PostQnaBoardRequestDto;
import com.back.back.dto.response.qnaboard.GetQnaBoardResponseDto;
import com.back.back.dto.request.qna.PostQnaBoardCommentRequestDto;
import com.back.back.dto.response.qnaboard.GetQnaBoardListResponseDto;
import com.back.back.dto.response.qnaboard.GetSearchQnaBoardListResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnaBoardServiceImplementation implements QnaBoardService {

	private final QnaBoardRepository qnaBoardRepository;
	private final UserRepository userRepository;

	@Override
	public ResponseEntity<ResponseDto> postQnaBoard(PostQnaBoardRequestDto dto, String userId) {

        try {
			boolean isExistUser = userRepository.existsByUserId(userId);
			if (!isExistUser) 
			return ResponseDto.authenticationFailed();

			QnaBoardEntity qnaBoardEntity = new QnaBoardEntity(dto, userId);
			qnaBoardRepository.save(qnaBoardEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
	}

	@Override
	public ResponseEntity<? super GetQnaBoardListResponseDto> getQnaBoardList() {

		try {
			List<QnaBoardEntity> qnaBoardEntities = qnaBoardRepository.findByOrderByQnaBoardNumberDesc();
			return GetQnaBoardListResponseDto.success(qnaBoardEntities);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
	}

	@Override
	public ResponseEntity<? super GetSearchQnaBoardListResponseDto> getSearchQnaBoardList(String qnaSearchWord) {

		try {
			List<QnaBoardEntity> qnaBoardEntities = qnaBoardRepository.findByQnaBoardTitleContainsOrderByQnaBoardNumberDesc(qnaSearchWord);
			return GetSearchQnaBoardListResponseDto.success(qnaBoardEntities);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
	}

	@Override
	public ResponseEntity<? super GetQnaBoardResponseDto> getQnaBoard(int qnaBoardNumber) {

		try {
			QnaBoardEntity qnaBoardEntity = qnaBoardRepository.findByQnaBoardNumber(qnaBoardNumber);
			if (qnaBoardEntity == null)	
			return ResponseDto.noExistBoard();
			return GetQnaBoardResponseDto.success(qnaBoardEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
    }

    @Override
    public ResponseEntity<ResponseDto> increaseQnaViewCount(int qnaBoardNumber) {

		try {
			QnaBoardEntity qnaBoardEntity = qnaBoardRepository.findByQnaBoardNumber(qnaBoardNumber);
			if (qnaBoardEntity == null)	
			return ResponseDto.noExistBoard();

			qnaBoardEntity.increaseQnaViewCount();
			qnaBoardRepository.save(qnaBoardEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
    }

	@Override
	public ResponseEntity<ResponseDto> putQnaBoard(PutQnaBoardRequestDto dto, int qnaBoardNumber, String userId) {

		try {
			QnaBoardEntity qnaBoardEntity = qnaBoardRepository.findByQnaBoardNumber(qnaBoardNumber);
			if (qnaBoardEntity == null) 
			return ResponseDto.noExistBoard();

			String writerId = qnaBoardEntity.getQnaBoardWriterId();
			boolean isWriter = userId.equals(writerId);
			
			if (!isWriter)
			return ResponseDto.authorizationFailed();

			boolean status = qnaBoardEntity.getQnaBoardStatus();
			if (status)
			return ResponseDto.writtenComment();

			qnaBoardEntity.updateQnaBoard(dto);
			qnaBoardRepository.save(qnaBoardEntity);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
    }

	@Override
	public ResponseEntity<ResponseDto> postQnaBoardComment(PostQnaBoardCommentRequestDto dto, int qnaBoardNumber) {

		try {
			QnaBoardEntity qnaBoardEntity = qnaBoardRepository.findByQnaBoardNumber(qnaBoardNumber);
			if (qnaBoardEntity == null) 
			return ResponseDto.noExistBoard();

			boolean qnaBoardStatus = qnaBoardEntity.getQnaBoardStatus();
			if (qnaBoardStatus)
			return ResponseDto.writtenComment();

			String qnaBoardComment = dto.getQnaBoardComment();
			qnaBoardEntity.setQnaBoardStatus(true);
			qnaBoardEntity.setQnaBoardComment(qnaBoardComment);

			qnaBoardRepository.save(qnaBoardEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
    }

	@Override
	public ResponseEntity<ResponseDto> deleteQnaBoard(int qnaBoardNumber, String userId) {

		try {

			QnaBoardEntity qnaBoardEntity = qnaBoardRepository.findByQnaBoardNumber(qnaBoardNumber);
			if (qnaBoardEntity == null) 
			return ResponseDto.noExistBoard();

			String qnaBoardWriterId = qnaBoardEntity.getQnaBoardWriterId();
			boolean isQnaWriter = userId.equals(qnaBoardWriterId);
			if (!isQnaWriter)
			return ResponseDto.authorizationFailed();

			qnaBoardRepository.delete(qnaBoardEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
    }

}
