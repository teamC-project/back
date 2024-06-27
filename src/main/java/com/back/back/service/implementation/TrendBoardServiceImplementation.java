package com.back.back.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import com.back.back.entity.LikeEntity;
import com.back.back.entity.TrendBoardEntity;
import com.back.back.dto.response.ResponseDto;
import com.back.back.repository.LikeRepository;
import com.back.back.repository.UserRepository;
import com.back.back.service.TrendBoardService;
import com.back.back.entity.TrendBoardCommentEntity;
import com.back.back.repository.TrendBoardRepository;
import com.back.back.repository.TrendBoardCommentRepository;
import com.back.back.dto.request.trend.PutTrendBoardRequestDto;
import com.back.back.dto.request.trend.PostTrendBoardRequestDto;
import com.back.back.dto.request.trend.PutTrendBoardCommentRequestDto;
import com.back.back.dto.response.trendboard.GetTrendBoardResponseDto;
import com.back.back.dto.request.trend.PostTrendBoardCommentRequestDto;
import com.back.back.dto.response.trendboard.GetTrendBoardListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardCommentResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardLikeListResponseDto;
import com.back.back.dto.response.trendboard.GetSearchTrendBoardListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardCommentListResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrendBoardServiceImplementation implements TrendBoardService {

	private final TrendBoardRepository trendBoardRepository;
	private final TrendBoardCommentRepository trendBoardCommentRepository;
	private final UserRepository userRepository;
	private final LikeRepository likeRepository;

	@Override
	public ResponseEntity<ResponseDto> postTrendBoard(PostTrendBoardRequestDto dto, String userId) {

		try {
			boolean isExistUser = userRepository.existsByUserId(userId);
			if (!isExistUser) 
			return ResponseDto.authenticationFailed();

			TrendBoardEntity trendBoardEntity = new TrendBoardEntity(dto, userId);
			trendBoardRepository.save(trendBoardEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postTrendBoardComment(PostTrendBoardCommentRequestDto dto, int trendBoardNumber, String userId) {

		try {
			boolean isExistUser = userRepository.existsById(userId);
			if (!isExistUser) 
			return ResponseDto.authenticationFailed();
			Optional<TrendBoardEntity> trendBoardOptional = trendBoardRepository.findById(trendBoardNumber);

			if (!trendBoardOptional.isPresent()) 
			return ResponseDto.noExistBoard();

			TrendBoardCommentEntity trendBoardCommentEntity = new TrendBoardCommentEntity(dto, trendBoardNumber, userId);
			trendBoardCommentRepository.save(trendBoardCommentEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetTrendBoardListResponseDto> getTrendBoardList() {

		try {
			List<TrendBoardEntity> trendBoardEntities = trendBoardRepository.findByOrderByTrendBoardNumberDesc();
			return GetTrendBoardListResponseDto.success(trendBoardEntities);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
    }

    @Override
    public ResponseEntity<? super GetSearchTrendBoardListResponseDto> getSearchTrendBoardList(String trendBoardSearchWord) {

		try {
			List<TrendBoardEntity> trendBoardEntities = trendBoardRepository.findByTrendBoardTitleOrderByTrendBoardNumberDesc(trendBoardSearchWord);
			return GetSearchTrendBoardListResponseDto.success(trendBoardEntities);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
    }

    @Override
    public ResponseEntity<? super GetTrendBoardResponseDto> getTrendBoard(int trendBoardNumber) {

		try {
			TrendBoardEntity trendBoardEntity = trendBoardRepository.findByTrendBoardNumber(trendBoardNumber);
			if (trendBoardEntity == null) 
			return ResponseDto.noExistBoard();
			return GetTrendBoardResponseDto.success(trendBoardEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
    }

    @Override
    public ResponseEntity<ResponseDto> putTrendBoard(PutTrendBoardRequestDto dto, int trendBoardNumber, String userId) {

		try {
			TrendBoardEntity trendBoardEntity = trendBoardRepository.findByTrendBoardNumber(trendBoardNumber);
			if (trendBoardEntity == null) 
			return ResponseDto.noExistBoard();

			String writerId = trendBoardEntity.getTrendBoardWriterId();
			boolean isTrendWriter = userId.equals(writerId);
			if (!isTrendWriter)	
			return ResponseDto.authorizationFailed();

			trendBoardEntity.updateTrendBoard(dto);
			trendBoardRepository.save(trendBoardEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> putTrendBoardComment(PutTrendBoardCommentRequestDto dto, int trendBoardCommentNumber, String userId) {

		try {
			TrendBoardCommentEntity trendBoardCommentEntity = trendBoardCommentRepository.findByTrendBoardCommentNumber(trendBoardCommentNumber);
			if (trendBoardCommentEntity == null) 
			return ResponseDto.noExistBoard();

			String writerId = trendBoardCommentEntity.getTrendBoardCommentWriterId();
			boolean isWriter = userId.equals(writerId);
			if (!isWriter) return ResponseDto.authorizationFailed();

			trendBoardCommentEntity.update(dto);
			trendBoardCommentRepository.save(trendBoardCommentEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTrendBoard(int trendBoardNumber, String userId) {

		try {
			TrendBoardEntity trendBoardEntity = trendBoardRepository.findByTrendBoardNumber(trendBoardNumber);
			if (trendBoardEntity == null) 
			return ResponseDto.noExistBoard();

			String trendBoardWriterId = trendBoardEntity.getTrendBoardWriterId();
			boolean isTrendWriter = userId.equals(trendBoardWriterId);
			if (!isTrendWriter) 
			return ResponseDto.authorizationFailed();

			trendBoardRepository.delete(trendBoardEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTrendBoardComment(int trendBoardCommentNumber, String userId) {

		try {
			TrendBoardCommentEntity trendBoardCommentEntity = trendBoardCommentRepository.findByTrendBoardCommentNumber(trendBoardCommentNumber);

			if (trendBoardCommentEntity == null) 
			return ResponseDto.noExistBoard();

			String writerId = trendBoardCommentEntity.getTrendBoardCommentWriterId();
			boolean isWriter = userId.equals(writerId);
			if (!isWriter) return ResponseDto.authorizationFailed();

			trendBoardCommentRepository.delete(trendBoardCommentEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetTrendBoardCommentListResponseDto> getTrendBoardCommentList(int trendBoardNumber) {

		try {
			List<TrendBoardCommentEntity> trendBoardCommentEntities = trendBoardCommentRepository.findByTrendBoardNumberOrderByTrendBoardCommentNumberDesc(trendBoardNumber);
			return GetTrendBoardCommentListResponseDto.success(trendBoardCommentEntities);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
    }

    @Override
    public ResponseEntity<? super GetTrendBoardCommentResponseDto> getTrendBoardComment(int trendBoardCommentNumber) {

		try {
			TrendBoardCommentEntity trendBoardCommentEntity = trendBoardCommentRepository.findByTrendBoardCommentNumber(trendBoardCommentNumber);

			if (trendBoardCommentEntity == null)
			return ResponseDto.noExistBoard();
			return GetTrendBoardCommentResponseDto.success(trendBoardCommentEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
    }

	@Override
	public ResponseEntity<ResponseDto> putTrendBoardLike(Integer trendBoardNumber, String userId) {

		try {
			TrendBoardEntity trendBoardEntity = trendBoardRepository.findByTrendBoardNumber(trendBoardNumber);
			if (trendBoardEntity == null) 
			return ResponseDto.noExistBoard();

			boolean isExistUser = userRepository.existsByUserId(userId);
			if (!isExistUser)
			return ResponseDto.authenticationFailed();

			boolean isLike = likeRepository.existsByUserIdAndTrendBoardNumber(userId, trendBoardNumber);
			LikeEntity likeEntity = new LikeEntity(userId, trendBoardNumber);

			if (isLike) {
			likeRepository.delete(likeEntity);
			trendBoardEntity.decreaseTrendBoardLikeCount();
			} else {
			likeRepository.save(likeEntity);
			trendBoardEntity.increaseTrendBoardLikeCount();
			}

			trendBoardRepository.save(trendBoardEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
	}

	@Override
	public ResponseEntity<ResponseDto> increaseTrendBoardViewCount(int trendBoardNumber) {

		try {
			TrendBoardEntity trendBoardEntity = trendBoardRepository.findByTrendBoardNumber(trendBoardNumber);
			if (trendBoardEntity == null)
			return ResponseDto.noExistBoard();

			trendBoardEntity.increaseTrendBoardViewCount();
			trendBoardRepository.save(trendBoardEntity);
		} 
		catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return ResponseDto.success();
	}

	@Override
	public ResponseEntity<? super GetTrendBoardLikeListResponseDto> getTrendBoardLikeList(Integer trendBoardNumber) {

		List<LikeEntity> likeEntities = new ArrayList<>();

		try {
		boolean existsedTrendBoard = trendBoardRepository.existsByTrendBoardNumber(trendBoardNumber);
		if (!existsedTrendBoard) 
		return GetTrendBoardLikeListResponseDto.noExistBoard();

		likeEntities = likeRepository.findByTrendBoardNumber(trendBoardNumber);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return GetTrendBoardLikeListResponseDto.success(likeEntities);
	}

	@Override
	public ResponseEntity<ResponseDto> deleteTrendBoardLikeList(int trendBoardNumber) {

		try {
			likeRepository.deleteByTrendBoardNumber(trendBoardNumber);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
			return ResponseDto.success();
	}

}