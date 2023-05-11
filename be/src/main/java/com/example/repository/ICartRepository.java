package com.example.repository;

import com.example.dto.ICartDTO;
import com.example.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartRepository extends JpaRepository<Cart, Long> {
    @Query(value = "SELECT p.image as imageProduct,\n" +
            " cd.id as cartDetailId,\n" +
            " p.id as productId,\n" +
            " c.id as cartId,\n" +
            " p.name as nameProduct,\n" +
            " p.price as priceProduct,\n" +
            " SUM(cd.quantity) as quantityCartDetail,\n" +
            " SUM(p.price * cd.quantity) as amountCartDetail\n" +
            "FROM cart c\n" +
            "JOIN account a ON c.account_id = a.account_id\n" +
            "JOIN cart_detail cd ON cd.cart_id = c.id\n" +
            "JOIN product p ON cd.product_id = p.id\n" +
            "WHERE a.account_id = :accountId AND cd.deleted = 0\n" +
            "GROUP BY p.image, cd.id, p.id, c.id, p.name, p.price, cd.quantity", nativeQuery = true)
    List<ICartDTO> getCartByAccountId(@Param("accountId") Long accountId);

    @Query(value = "SELECT p.image as imageProduct,\n" +
            " cd.id as cartDetailId,\n" +
            " p.id as productId,\n" +
            " c.id as cartId,\n" +
            " p.name as nameProduct,\n" +
            " p.price as priceProduct,\n" +
            " cd.date_of_order as dateOfOrder,\n" +
            " SUM(cd.quantity) as quantityCartDetail,\n" +
            " SUM(p.price * cd.quantity) as amountCartDetail\n" +
            "FROM cart c\n" +
            "JOIN account a ON c.account_id = a.account_id\n" +
            "JOIN cart_detail cd ON cd.cart_id = c.id\n" +
            "JOIN product p ON cd.product_id = p.id\n" +
            "WHERE a.account_id = :accountId AND cd.deleted = 1\n" +
            "GROUP BY p.image, cd.id, p.id, c.id, p.name, p.price, cd.quantity", nativeQuery = true)
    List<ICartDTO> getOrderHistory(@Param("accountId") Long accountId);
}
