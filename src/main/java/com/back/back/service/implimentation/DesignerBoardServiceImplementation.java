package com.back.back.service.implimentation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.back.back.dto.request.designer.PostDesignerBoardCommentRequestDto;
import com.back.back.dto.request.designer.PostDesignerBoardRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.repository.DesignerBoardRepository;
import com.back.back.service.DesignerBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DesignerBoardServiceImplementation implements DesignerBoardService {

    private final DesignerBoardRepository designerBoardRepository;

    @Override
    public ResponseEntity<ResponseDto> postDesignerBoard(PostDesignerBoardRequestDto dto, String userId) {
        
        try {

            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postDesignerBoardComment(PostDesignerBoardCommentRequestDto dto, int designerBoardNumber) {
        
        try {
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }
    
}
