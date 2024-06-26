package com.back.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.back.back.entity.DesignerBoardCommentEntity;

@Repository
public interface DesignerBoardCommentRepository extends JpaRepository<DesignerBoardCommentEntity, Integer> {
    
    DesignerBoardCommentEntity findByDesignerBoardCommentNumber(Integer designerBoardCommentNumber);

    List<DesignerBoardCommentEntity> findByDesignerBoardNumberOrderByDesignerBoardCommentNumberDesc(int designerBoardNumber);

}
