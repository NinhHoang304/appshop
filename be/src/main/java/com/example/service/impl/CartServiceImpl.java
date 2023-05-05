package com.example.service.impl;

import com.example.model.CartDetail;
import com.example.repository.ICartRepository;
import com.example.dto.ICartDTO;
import com.example.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private ICartRepository cartRepository;
    @Override
    public List<ICartDTO> getCartByAccountId(Long id) {
        return this.cartRepository.getCartByAccountId(id);
    }

}