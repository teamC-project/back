package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.AnnouncementBoardEntity;


@Repository
<<<<<<< HEAD
public interface AnnouncementBoardRepository extends JpaRepository <AnnouncementBoardEntity, Integer> {

    List<AnnouncementBoardEntity> findByOrderByAnnouncementBoardNumberDesc();
    List<AnnouncementBoardEntity> findByAnnouncementBoardTitleOrderByAnnouncementBoardNumberDesc(String announcementBoardTitle);
    AnnouncementBoardEntity findByAnnouncementBoardNumber(Integer announcementBoardNumber);
=======
public interface AnnounceMentBoardRepository extends JpaRepository <AnnouncementBoardEntity, Integer> {

    List<AnnouncementBoardEntity> findByOrderByAnnouncementNumberDesc();
    List<AnnouncementBoardEntity> findByTitleContainsOrderByAnnouncementBoardNumberDesc(String announceMentTitle);
    AnnouncementBoardEntity findByAnnouncementBoardNumber(Integer announceMentNumber);
>>>>>>> 44fca5349da5c0d03521ca57b33ed5892a9027a6
}
