package com.example.service;

import com.example.dto.CartDetailDTO;
import com.example.model.CartDetail;

public interface ICartDetailService {
    void addToCart(CartDetail cartDetail);
    void changeQuantity(CartDetail cartDetail);

    CartDetail findById(Long id);

    void delete(Long id);
}
