package com.back.back.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.QnaBoardEntity;

@Repository
public interface QnaBoardRepository extends JpaRepository <QnaBoardEntity, Integer> {

<<<<<<< HEAD
	List<QnaBoardEntity> findByOrderByQnaBoardNumberDesc();
	List<QnaBoardEntity> findByQnaBoardTitleOrderByQnaBoardNumberDesc(String qnaTitle);
	QnaBoardEntity findByQnaBoardNumber(Integer qnaBoardNumber);
}
=======
// List<QnaBoardEntity> findByOrderByQnaBoardNumberDesc();
// List<QnaBoardEntity> findByTitleContainsOrderByQnaBoardNumberDesc(String qnaTitle);
// QnaBoardEntity findByQnaNumber(Integer qnaBoardNumber);
// }
>>>>>>> 44fca5349da5c0d03521ca57b33ed5892a9027a6
