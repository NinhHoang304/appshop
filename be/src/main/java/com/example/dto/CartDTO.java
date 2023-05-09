package com.example.dto;

public class CartDTO {
    private Long productId;
    Long cartId;
    Long cartDetailId;
    String imageProduct;
    String nameProduct;
    double priceProduct;
    int quantityCartDetail;
    int amountCartDetail;

    public CartDTO() {
    }

    public CartDTO(Long productId, Long cartId, Long cartDetailId, String imageProduct, String nameProduct, double priceProduct, int quantityCartDetail, int amountCartDetail) {
        this.productId = productId;
        this.cartId = cartId;
        this.cartDetailId = cartDetailId;
        this.imageProduct = imageProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantityCartDetail = quantityCartDetail;
        this.amountCartDetail = amountCartDetail;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(Long cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getQuantityCartDetail() {
        return quantityCartDetail;
    }

    public void setQuantityCartDetail(int quantityCartDetail) {
        this.quantityCartDetail = quantityCartDetail;
    }

    public int getAmountCartDetail() {
        return amountCartDetail;
    }

    public void setAmountCartDetail(int amountCartDetail) {
        this.amountCartDetail = amountCartDetail;
    }
}
