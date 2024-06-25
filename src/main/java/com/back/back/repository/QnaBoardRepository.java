package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.QnaBoardEntity;

@Repository
public interface QnaBoardRepository extends JpaRepository<QnaBoardEntity, Integer> {
<<<<<<< HEAD
	List<QnaBoardEntity> findByOrderByQnaBoardNumberDesc();
	List<QnaBoardEntity> findByQnaBoardTitleContainsOrderByQnaBoardNumberDesc(String qnaTitle);
	QnaBoardEntity findByQnaBoardNumber(Integer qnaBoardNumber);
=======

    QnaBoardEntity findByQnaBoardNumber(Integer qnaBoardNumber);
>>>>>>> 8233bf14626911f72de1b65a4c0c6356778ad8a4

    List<QnaBoardEntity> findByOrderByQnaBoardNumberDesc();
    List<QnaBoardEntity> findByQnaBoardTitleContainsOrderByQnaBoardNumberDesc(String qnaTitle);
    
}
