package com.back.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.back.back.entity.DesignerBoardEntity;

@Repository
public interface DesignerBoardRepository extends JpaRepository<DesignerBoardEntity, Integer> {

    DesignerBoardEntity findByDesignerBoardNumber(Integer designerBoardNumber);

    List<DesignerBoardEntity> findByOrderByDesignerBoardNumberDesc();
    List<DesignerBoardEntity> findByDesignerBoardTitleContainsOrderByDesignerBoardNumberDesc(String designerTitle);
    
}
