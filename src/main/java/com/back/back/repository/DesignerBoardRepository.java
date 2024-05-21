// package com.back.back.repository;

// import java.util.List;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
=======
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;
>>>>>>> 32888d295d2d4df14d779134ce02a5ee28462bc0

// import com.back.back.entity.DesignerBoardEntity;

<<<<<<< HEAD
@Repository
public interface DesignerBoardRepository extends JpaRepository<DesignerBoardEntity, Integer> {

    List<DesignerBoardEntity> findByOrderByDesignerBoardNumberDesc();

    List<DesignerBoardEntity> findByDesignerBoardTitleContainsOrderByDesignerBoardNumberDesc(String designerTitle);
    
    DesignerBoardEntity findByDesignerBoardNumber(Integer designerBoardNumber);

    
    
    
}
=======
// @Repository
// public interface DesignerBoardRepository extends JpaRepository<DesignerBoardEntity, Integer> {
//     List<DesignerBoardEntity> findByOrdreByDesignerBoardNumberDesc();

//     @Query(nativeQuery = true)
//     List<DesignerBoardEntity> findByTitleOrContentContainsOrderByDesignerBoardNumberDesc(String keyword, String keyword);

//     DesignerBoardEntity findByDesignerBoardNumber(Integer designerBoardNumber);
// }
>>>>>>> 32888d295d2d4df14d779134ce02a5ee28462bc0
