package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.back.entity.DesignerBoardEntity;

@Repository
public interface DesignerBoardRepository extends JpaRepository<DesignerBoardEntity, Integer> {

    List<DesignerBoardEntity> findByOrderByDesignerBoardNumberDesc();

    List<DesignerBoardEntity> findByDesignerBoardTitleContainsOrderByDesignerBoardNumberDesc(String designerTitle);
    
    DesignerBoardEntity findByDesignerBoardNumber(Integer designerBoardNumber);

    
    
    
}
