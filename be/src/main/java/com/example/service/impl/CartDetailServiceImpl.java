package com.example.service.impl;

import com.example.model.CartDetail;
import com.example.repository.ICartDetailRepository;
import com.example.service.ICartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartDetailServiceImpl implements ICartDetailService {
    @Autowired
    private ICartDetailRepository cartDetailRepository;

    @Transactional
    @Override
    public void addToCart(CartDetail cartDetail) {
        List<CartDetail> cartDetailList = this.cartDetailRepository.findAll();
        for (CartDetail detail : cartDetailList) {
            if (cartDetail.getProduct().getId() == detail.getProduct().getId()) {
                cartDetail.setId(detail.getId());
                cartDetail.setQuantity(cartDetail.getQuantity() + detail.getQuantity());
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
    public void changStatusDeleted(Long id) {
        this.cartDetailRepository.changeStatusDeleted(id);
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
