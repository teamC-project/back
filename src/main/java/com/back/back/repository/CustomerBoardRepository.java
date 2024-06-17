package com.back.back.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.back.back.entity.CustomerBoardEntity;

@Repository
public interface CustomerBoardRepository extends JpaRepository<CustomerBoardEntity, Integer> {
    List<CustomerBoardEntity> findByOrderByCustomerBoardNumberDesc();

    List<CustomerBoardEntity> findByCustomerBoardTitleContainsOrderByCustomerBoardNumberDesc(String customertitle);

    CustomerBoardEntity findByCustomerBoardNumber(int customerBoardNumber);

    // @Query("SELECT cb, COUNT(cbc) AS customerBoardCommentCount " +
    //         "FROM com.back.back.entity.CustomerBoardEntity cb " + // 엔티티 클래스의 전체 경로 추가
    //         "LEFT JOIN com.back.back.entity.CustomerBoardCommentEntity cbc ON cb.customerBoardNumber = cbc.customerBoardNumber " + // 엔티티 클래스의 전체 경로 추가
    //         "GROUP BY cb.customerBoardNumber " +
    //         "ORDER BY cb.customerBoardNumber DESC")
    // List<Object[]> findAllWithCustomerBoardCommentCount();
}