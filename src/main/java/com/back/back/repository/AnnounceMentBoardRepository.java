package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.AnnouncementBoardEntity;


@Repository
public interface AnnouncementBoardRepository extends JpaRepository <AnnouncementBoardEntity, Integer> {

    List<AnnouncementBoardEntity> findByOrderByAnnouncementNumberDesc();
    List<AnnouncementBoardEntity> findByTitleContainsOrderByAnnouncementBoardNumberDesc(String announcementTitle);
    AnnouncementBoardEntity findByAnnouncementBoardNumber(Integer announcementNumber);
=======
<<<<<<< HEAD
public interface AnnouncementBoardRepository extends JpaRepository <AnnouncementBoardEntity, Integer> {

    List<AnnouncementBoardEntity> findByOrderByAnnouncementBoardNumberDesc();
    List<AnnouncementBoardEntity> findByAnnouncementBoardTitleOrderByAnnouncementBoardNumberDesc(String announcementBoardTitle);
<<<<<<< HEAD
    AnnouncementBoardEntity findByAnnouncementBoardNumber(Integer announcementBoardNumber);
=======
public interface AnnounceMentBoardRepository extends JpaRepository <AnnouncementBoardEntity, Integer> {

    List<AnnouncementBoardEntity> findByOrderByAnnouncementNumberDesc();
    List<AnnouncementBoardEntity> findByTitleContainsOrderByAnnouncementBoardNumberDesc(String announceMentTitle);
    AnnouncementBoardEntity findByAnnouncementBoardNumber(Integer announceMentNumber);
>>>>>>> 44fca5349da5c0d03521ca57b33ed5892a9027a6
>>>>>>> 97a21643a440a31601363b460738b873ee41fbf9
}
=======
    AnnouncementBoardEntity findByAnnouncementBoardNumber(Integer announcementBoardNumber);}
>>>>>>> f1092834252e6f8764dc4e797fab3c1bc49173f8
