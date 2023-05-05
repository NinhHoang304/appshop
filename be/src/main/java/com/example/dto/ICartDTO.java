package com.example.dto;

public interface ICartDTO {
    Long getProductId();
    Long getCartId();
    Long getCartDetailId();
    String getImageProduct();
    String getNameProduct();
    double getPriceProduct();
    int getQuantityCartDetail();
    int getAmountCartDetail();
}
