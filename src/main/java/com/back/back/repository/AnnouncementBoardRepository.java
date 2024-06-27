package com.back.back.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.back.back.entity.AnnouncementBoardEntity;

@Repository
public interface AnnouncementBoardRepository extends JpaRepository <AnnouncementBoardEntity, Integer> {

    AnnouncementBoardEntity findByAnnouncementBoardNumber(Integer announcementBoardNumber);

    List<AnnouncementBoardEntity> findByOrderByAnnouncementBoardNumberDesc();
    List<AnnouncementBoardEntity> findByAnnouncementBoardTitleContainsOrderByAnnouncementBoardNumberDesc(String announcementBoardTitle);

}
