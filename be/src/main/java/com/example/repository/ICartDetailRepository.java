package com.example.repository;

import com.example.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartDetailRepository extends JpaRepository<CartDetail, Long> {
}
