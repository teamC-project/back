package com.back.back.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import com.back.back.entity.UserEntity;
import com.back.back.dto.response.ResponseDto;
import com.back.back.repository.UserRepository;
import com.back.back.entity.DesignerBoardEntity;
import com.back.back.service.DesignerBoardService;
import com.back.back.entity.DesignerBoardCommentEntity;
import com.back.back.repository.DesignerBoardRepository;
import com.back.back.repository.DesignerBoardCommentRepository;
import com.back.back.dto.request.designer.PutDesignerBoardRequestDto;
import com.back.back.dto.request.designer.PostDesignerBoardRequestDto;
import com.back.back.dto.request.designer.PutDesignerBoardCommentRequestDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardResponseDto;
import com.back.back.dto.request.designer.PostDesignerBoardCommentRequestDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardListResponseDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardCommentResponseDto;
import com.back.back.dto.response.designerboard.GetSearchDesignerBoardListResponseDto;
import com.back.back.dto.response.designerboard.GetDesignerBoardCommentListResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DesignerBoardServiceImplementation implements DesignerBoardService {

    private final UserRepository userRepository;
    private final DesignerBoardRepository designerBoardRepository;
    private final DesignerBoardCommentRepository designerBoardCommentRepository;

    @Override
    public ResponseEntity<ResponseDto> postDesignerBoard(PostDesignerBoardRequestDto dto, String userId) {

        try {
            boolean isExistUser = userRepository.existsById(userId);
            if (!isExistUser) 
            return ResponseDto.authenticationFailed();
            DesignerBoardEntity designerBoardEntity = new DesignerBoardEntity(dto, userId);
            designerBoardRepository.save(designerBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postDesignerBoardComment(PostDesignerBoardCommentRequestDto dto, int designerBoardNumber, String userId) {

        try {
            boolean isExistUser = userRepository.existsById(userId);

            if (!isExistUser) 
            return ResponseDto.authenticationFailed();

            Optional<DesignerBoardEntity> designerBoardOptional = designerBoardRepository.findById(designerBoardNumber);

            if (!designerBoardOptional.isPresent())
            return ResponseDto.noExistBoard();

            DesignerBoardCommentEntity designerBoardCommentEntity;

            if (dto.getDesignerBoardParentCommentNumber() != null) {
                Optional<DesignerBoardCommentEntity> parentCommentOptional = designerBoardCommentRepository.findById(dto.getDesignerBoardParentCommentNumber());
                if (!parentCommentOptional.isPresent()) 
                return ResponseDto.noExistBoard();

                designerBoardCommentEntity = new DesignerBoardCommentEntity(dto, designerBoardNumber, userId, dto.getDesignerBoardParentCommentNumber());
            } else {
                designerBoardCommentEntity = new DesignerBoardCommentEntity(dto, designerBoardNumber, userId, null); 
            }
            designerBoardCommentRepository.save(designerBoardCommentEntity); 

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetDesignerBoardListResponseDto> getDesignerBoardList() {

        try {
            List<DesignerBoardEntity> designerBoardEntities = designerBoardRepository.findByOrderByDesignerBoardNumberDesc();
            return GetDesignerBoardListResponseDto.success(designerBoardEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetSearchDesignerBoardListResponseDto> getSearchDesignerBoardList(String designersearchWord) {

        try {
            List<DesignerBoardEntity> designerBoardEntities = designerBoardRepository.findByDesignerBoardTitleContainsOrderByDesignerBoardNumberDesc(designersearchWord);
            return GetSearchDesignerBoardListResponseDto.success(designerBoardEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetDesignerBoardResponseDto> getDesignerBoard(int designerBoardNumber, String userId) {

        try {
            DesignerBoardEntity designerBoardEntity = designerBoardRepository.findByDesignerBoardNumber(designerBoardNumber);
            if (designerBoardEntity == null) 
            return ResponseDto.noExistBoard();
            return GetDesignerBoardResponseDto.success(designerBoardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetDesignerBoardCommentListResponseDto> getDesignerBoardCommentList(int designerBoardNumber) {  

        try {
            List<DesignerBoardCommentEntity> designerBoardCommentEntities = designerBoardCommentRepository.findByDesignerBoardNumberOrderByDesignerBoardCommentNumberDesc(designerBoardNumber);
            return GetDesignerBoardCommentListResponseDto.success(designerBoardCommentEntities);

        } catch (Exception  exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetDesignerBoardCommentResponseDto> getDesignerBoardComment(int designerBoardCommentNumber) 
	{
        try {
            DesignerBoardCommentEntity designerBoardCommentEntity = designerBoardCommentRepository.findByDesignerBoardCommentNumber(designerBoardCommentNumber);
            if (designerBoardCommentEntity == null) 
            return ResponseDto.noExistBoard();
            return GetDesignerBoardCommentResponseDto.success(designerBoardCommentEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<ResponseDto> putDesignerBoard(PutDesignerBoardRequestDto dto, int designerBoardNumber, String userId) {

        try {
            DesignerBoardEntity designerBoardEntity =  designerBoardRepository.findByDesignerBoardNumber(designerBoardNumber);
            if (designerBoardEntity == null) 
            return ResponseDto.noExistBoard();

            String writerId = designerBoardEntity != null ? designerBoardEntity.getDesignerBoardWriterId() : null;
            boolean isWriter = writerId != null && userId.equals(writerId);
            
            if (!isWriter) 
            return ResponseDto.authorizationFailed();

            designerBoardEntity.update(dto);
            designerBoardRepository.save(designerBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
    
    @Override
    public ResponseEntity<ResponseDto> putDesignerBoardComment(PutDesignerBoardCommentRequestDto dto, int designerBoardCommentNumber, String userId) {

        try {
            DesignerBoardCommentEntity designerBoardCommentEntity = designerBoardCommentRepository.findByDesignerBoardCommentNumber(designerBoardCommentNumber);
            if (designerBoardCommentEntity == null) 
            return ResponseDto.noExistBoard();

            String writerId = designerBoardCommentEntity != null ? designerBoardCommentEntity.getDesignerBoardCommentWriterId() :null;
            boolean isWriter = writerId != null && userId.equals(writerId);
            if (!isWriter) 
            return ResponseDto.authorizationFailed();

            designerBoardCommentEntity.update(dto);
            designerBoardCommentRepository.save(designerBoardCommentEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteDesignerBoard(int designerBoardNumber, String userId) {

        try {
            DesignerBoardEntity designerBoardEntity = designerBoardRepository.findByDesignerBoardNumber(designerBoardNumber);
            if (designerBoardEntity == null) 
            return ResponseDto.noExistBoard();

            UserEntity userEntity = userRepository.findByUserId(userId);
            if (userEntity == null) 
            return ResponseDto.authenticationFailed();

            String writerId = designerBoardEntity.getDesignerBoardWriterId();
            String userRole = userEntity.getUserRole();
            boolean isWriter = userId.equals(writerId);
            boolean isAdmin = userRole.equals("ROLE_ADMIN");

            if (!isWriter && !isAdmin) return ResponseDto.authorizationFailed();
            designerBoardRepository.delete(designerBoardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteDesignerBoardComment(int designerBoardCommentNumber, String userId) {

        try {
            DesignerBoardCommentEntity designerBoardCommentEntity = 
            designerBoardCommentRepository.findByDesignerBoardCommentNumber(designerBoardCommentNumber);
            if (designerBoardCommentEntity == null) 
            return ResponseDto.noExistBoard();

            UserEntity userEntity = userRepository.findByUserId(userId);
            if (userEntity == null) 
            return ResponseDto.authenticationFailed();

            String writerId = designerBoardCommentEntity.getDesignerBoardCommentWriterId();
            String userRole = userEntity.getUserRole();
            boolean isWriter = userId.equals(writerId);
            boolean isAdmin = userRole.equals("ROLE_ADMIN");

            if (!isWriter && !isAdmin) 
            return ResponseDto.authorizationFailed();

            designerBoardCommentRepository.delete(designerBoardCommentEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> increaseViewCount(int designerBoardNumber) {

        try {
            DesignerBoardEntity designerBoardEntity = designerBoardRepository.findByDesignerBoardNumber(designerBoardNumber);
            if (designerBoardEntity == null) 
            return ResponseDto.noExistBoard();

            designerBoardEntity.designerIncreaseViewCount();
            designerBoardRepository.save(designerBoardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

}