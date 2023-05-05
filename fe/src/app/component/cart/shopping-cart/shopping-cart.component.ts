import {Component, OnInit} from '@angular/core';
import {CartService} from '../../../service/cart.service';
import {CartDTO} from '../../../dto/cart-dto';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';
import {TokenStorageService} from '../../security-authentication/service/token-storage.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {
  cartList: CartDTO[];
  quantity: number;
  deleted = false;
  cartDetailId = 0;
  nameProduct = '';
  totalAmount = 0;
  userId: number;

  constructor(private cartService: CartService,
              private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.view();
    this.getCart();
  }

  getCart() {
    if (this.tokenStorageService.getToken()) {
      this.userId = this.tokenStorageService.getUser().id;
    }
    this.cartService.getCartByAccountId(this.userId).subscribe(item => {
      this.cartList = item;
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < item.length; i++) {
        this.totalAmount += +item[i].amountCartDetail;
        console.log('asdasd' + item[i]);
      }
      console.log(this.cartList);
    });
  }

  view(): void {
    window.scrollTo(0, 0);
  }

  subtract(cartDetailId: number, productId: number, cartId: number) {
    this.cartService.getCartDetailById(cartDetailId).subscribe(item => {
      this.quantity = item.quantity;
      this.deleted = item.deleted;
      this.quantity--;
      if (this.quantity === 0) {
        this.cartService.deleteCartById(cartDetailId).subscribe(next => {
          this.getCart();
        });
      } else {
        this.cartService.changeQuantity(cartDetailId, this.quantity, this.deleted, productId, cartId).subscribe(next => {
          this.totalAmount = 0;
          this.getCart();
        });
      }
    });
  }

  add(cartDetailId: number, productId: number, cartId: number) {
    this.cartService.getCartDetailById(cartDetailId).subscribe(item => {
      this.quantity = item.quantity;
      this.deleted = item.deleted;
      this.quantity++;
      this.cartService.changeQuantity(cartDetailId, this.quantity, this.deleted, productId, cartId).subscribe(next => {
        this.totalAmount = 0;
        this.getCart();
      });
    });
  }

  deleteCartDetail(cartDetailId: number) {
    this.cartService.deleteCartById(cartDetailId).subscribe(next => {
      Swal.fire({
        title: 'Success!',
        text: 'Do you want to continue',
        icon: 'success',
        confirmButtonText: 'Ok'
      });
      this.getCart();
    });
  }

  getInfoDelete(cartDetailId: number, nameProduct: string) {
    this.cartDetailId = cartDetailId;
    this.nameProduct = nameProduct;
  }
}
