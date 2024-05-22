package com.back.back.service.implimentation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import com.back.back.dto.request.trend.PostTrendBoardRequestDto;
import com.back.back.dto.request.trend.PutTrendBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.trendboard.GetSearchTrendBoardListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardListResponseDto;
import com.back.back.dto.response.trendboard.GetTrendBoardResponseDto;
import com.back.back.entity.TrendBoardEntity;

import com.back.back.repository.TrendBoardRepository;
import com.back.back.repository.UserRepository;
import com.back.back.service.TrendBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrendBoardServiceImplementation implements TrendBoardService {
	private final TrendBoardRepository trendBoardRepository;
	private final UserRepository userRepository;

	@Override
	public ResponseEntity<ResponseDto> postTrendBoard(PostTrendBoardRequestDto dto, String userId) {
		try {
			boolean isExistUser = userRepository.existsByUserId(userId);
			if(!isExistUser) return ResponseDto.authenticationFailed();

			TrendBoardEntity trendBoardEntity = new TrendBoardEntity(dto, userId);
			trendBoardRepository.save(trendBoardEntity);

		} catch(Exception exception) {
				exception.printStackTrace();
				return ResponseDto.databaseError();
		}
		return ResponseDto.success();
	}

	@Override
	public ResponseEntity<? super GetTrendBoardListResponseDto> getTrendBoardList() {
		
		try {
					List<TrendBoardEntity> trendBoardEntity = trendBoardRepository.findByOrderByTrendBoardNumberDesc();
					return GetTrendBoardListResponseDto.success(trendBoardEntity);
		} catch (Exception exception) {
				exception.printStackTrace();
				return ResponseDto.databaseError();
		}
	}

	@Override
	public ResponseEntity<? super GetSearchTrendBoardListResponseDto> getSearchTrendBoardList(
			String trendBoardSearchWord) {
				try {				
					List<TrendBoardEntity> trendBoardEntities = trendBoardRepository.findByTrendBoardTitleOrderByTrendBoardNumberDesc(trendBoardSearchWord);
					return GetSearchTrendBoardListResponseDto.success(trendBoardEntities);

				} catch(Exception exception) {
						exception.printStackTrace();
						return ResponseDto.databaseError();
				}
	}

	@Override
	public ResponseEntity<? super GetTrendBoardResponseDto> getTrendBoard(int trendBoardNumber) {

		try {
			TrendBoardEntity trendBoardEntity = trendBoardRepository.findByTrendBoardNumber(trendBoardNumber);
			if(trendBoardEntity == null) return ResponseDto.noExistBoard();
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
					if (trendBoardEntity == null) return ResponseDto.noExistBoard();

					String writerId = trendBoardEntity.getTrendBoardWriterId();
					boolean isWriter = userId.equals(writerId);
					if (!isWriter) return ResponseDto.authorizationFailed();

					trendBoardEntity.updateTrendBoard(dto);
					trendBoardRepository.save(trendBoardEntity);
			} catch(Exception exception) {
					exception.printStackTrace();
					return ResponseDto.databaseError();
			}
			return ResponseDto.success();
	}

	@Override
	public ResponseEntity<ResponseDto> increaseTrendBoardLikeCount(int trendBoardNumber) {

		try {
			TrendBoardEntity trendBoardEntity = trendBoardRepository.findByTrendBoardNumber(trendBoardNumber);
			if (trendBoardEntity == null) return ResponseDto.noExistBoard();

			trendBoardEntity.increaseTrendBoardLikeCount();
			trendBoardRepository.save(trendBoardEntity);
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
			return ResponseDto.success();
	}

	@Override
	public ResponseEntity<ResponseDto> decreaseTrendBoardLikeCount(int trendBoardNumber) {
		try {
			TrendBoardEntity trendBoardEntity = trendBoardRepository.findByTrendBoardNumber(trendBoardNumber);
			if (trendBoardEntity == null) return ResponseDto.noExistBoard();

			trendBoardEntity.decreaseTrendBoardLikeCount();
			trendBoardRepository.save(trendBoardEntity);
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
			return ResponseDto.success();
	}

	
}
