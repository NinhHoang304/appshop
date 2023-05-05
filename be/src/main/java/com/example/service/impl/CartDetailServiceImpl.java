package com.example.service.impl;

import com.example.model.CartDetail;
import com.example.repository.ICartDetailRepository;
import com.example.service.ICartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailServiceImpl implements ICartDetailService {
    @Autowired
    private ICartDetailRepository cartDetailRepository;


    @Override
    public void addToCart(CartDetail cartDetail) {
        List<CartDetail> cartDetailList = this.cartDetailRepository.findAll();
        for (int i = 0; i < cartDetailList.size(); i++) {
            if (cartDetail.getProduct().getId() == cartDetailList.get(i).getProduct().getId()) {
                cartDetail.setId(cartDetailList.get(i).getId());
                cartDetail.setQuantity(cartDetail.getQuantity() + cartDetailList.get(i).getQuantity());
                this.cartDetailRepository.save(cartDetail);
            }
        }
        this.cartDetailRepository.save(cartDetail);
    }

    @Override
    public void changeQuantity(CartDetail cartDetail) {
        this.cartDetailRepository.save(cartDetail);
    }

    @Override
    public CartDetail findById(Long id) {
        return this.cartDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        this.cartDetailRepository.deleteById(id);
    }
}
