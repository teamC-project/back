package com.back.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back.entity.AnnouncementBoardEntity;


@Repository
public interface AnnouncementBoardRepository extends JpaRepository <AnnouncementBoardEntity, Integer> {

    List<AnnouncementBoardEntity> findByOrderByAnnouncementBoardNumberDesc();
    List<AnnouncementBoardEntity> findByAnnouncementBoardTitleOrderByAnnouncementBoardNumberDesc(String announcementBoardTitle);
    AnnouncementBoardEntity findByAnnouncementBoardNumber(Integer announcementBoardNumber);}