package com.example.service;

import com.example.dto.ICartDTO;
import com.example.model.CartDetail;

import java.util.List;

public interface ICartService {
    List<ICartDTO> getCartByAccountId(Long id);
}
