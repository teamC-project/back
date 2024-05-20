package com.back.back.service.implimentation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.back.dto.request.qna.PostQnaBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.repository.QnaBoardRepository;
import com.back.back.repository.UserRepository;
import com.back.back.service.QnaBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnaBoardServiceImplementation implements QnaBoardService {

	private final QnaBoardRepository qnaBoardRepository;
	private final UserRepository userRepository;
	@Override
	public ResponseEntity<ResponseDto> postQnaBoard(PostQnaBoardRequestDto dto, String userId) {

		try {

			

		} catch(Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}

	}
	
}
