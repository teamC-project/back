// package com.back.back.repository;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.back.back.entity.AnnouncementBoardEntity;


// @Repository
// public interface AnnounceMentBoardRepository extends JpaRepository <AnnouncementBoardEntity, Integer> {

//     List<AnnouncementBoardEntity> findByOrderByAnnouncementNumberDesc();
//     List<AnnouncementBoardEntity> findByTitleContainsOrderByAnnouncementBoardNumberDesc(String announceMentTitle);
//     AnnouncementBoardEntity findByAnnouncementBoardNumber(Integer announceMentNumber);
// }
