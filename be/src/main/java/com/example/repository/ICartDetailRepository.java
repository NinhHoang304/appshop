package com.example.repository;

import com.example.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICartDetailRepository extends JpaRepository<CartDetail, Long> {
    @Transactional
    @Modifying
    @Query(value = "update cart_detail set deleted = 1 where id = :cartDetailId ", nativeQuery = true)
    void changeStatusDeleted(@Param("cartDetailId") Long cartDetailId);
}
