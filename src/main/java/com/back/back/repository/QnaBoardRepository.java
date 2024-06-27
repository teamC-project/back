package com.back.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.back.back.entity.QnaBoardEntity;

@Repository
public interface QnaBoardRepository extends JpaRepository<QnaBoardEntity, Integer> {

    QnaBoardEntity findByQnaBoardNumber(Integer qnaBoardNumber);

    List<QnaBoardEntity> findByOrderByQnaBoardNumberDesc();
    List<QnaBoardEntity> findByQnaBoardTitleContainsOrderByQnaBoardNumberDesc(String qnaTitle);
    
}
