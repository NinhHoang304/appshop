package com.example.controller;

import com.example.dto.CartDetailDTO;
import com.example.dto.IAccountDTO;
import com.example.dto.ICartDTO;
import com.example.model.Cart;
import com.example.model.CartDetail;
import com.example.model.Product;
import com.example.service.IAccountService;
import com.example.service.ICartDetailService;
import com.example.service.ICartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user/")
public class CartRestController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private ICartDetailService cartDetailService;

    @GetMapping("cart/{id}")
    public ResponseEntity<List<ICartDTO>> getCartByAccountId(@PathVariable Long id) {
        List<ICartDTO> cartDTOList = this.cartService.getCartByAccountId(id);
        if (cartDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cartDTOList, HttpStatus.OK);
    }

    @GetMapping("cartId/{accountId}")
    public ResponseEntity<IAccountDTO> getCartIdByAccountId(@PathVariable Long accountId) {
        IAccountDTO accountDTO = this.accountService.findCartIdByAccountId(accountId);
        if (accountDTO == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @GetMapping("cart/add/{quantity}/{deleted}/{productId}/{cartId}")
    public ResponseEntity<?> addToCart(@PathVariable int quantity,
                                       @PathVariable boolean deleted,
                                       @PathVariable Long cartId,
                                       @PathVariable Long productId) {
        CartDetail cartDetail = new CartDetail(quantity, deleted, new Product(productId), new Cart(cartId));
        this.cartDetailService.addToCart(cartDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("cart/add/{cartDetailId}/{quantity}/{deleted}/{productId}/{cartId}")
    public ResponseEntity<?> changeQuantity(@PathVariable Long cartDetailId,
                                            @PathVariable int quantity,
                                            @PathVariable boolean deleted,
                                            @PathVariable Long cartId,
                                            @PathVariable Long productId) {
        CartDetail cartDetail = new CartDetail(cartDetailId, quantity, deleted, new Product(productId), new Cart(cartId));
        this.cartDetailService.changeQuantity(cartDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("cartDetail/{cartDetailId}")
    public ResponseEntity<?> getCartDetailById(@PathVariable Long cartDetailId) {
        CartDetail cartDetail = this.cartDetailService.findById(cartDetailId);
        if (cartDetail == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cartDetail, HttpStatus.OK);
    }

    @GetMapping("delete/cartDetail/{cartDetailId}")
    public ResponseEntity<?> deleteCartDetailById(@PathVariable Long cartDetailId) {
        if (cartDetailId != null) {
            this.cartDetailService.delete(cartDetailId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
