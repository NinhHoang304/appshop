import {Component, OnInit} from '@angular/core';
import {CartService} from '../../../service/cart.service';
import {CartDTO} from '../../../dto/cart-dto';
import Swal from 'sweetalert2';
import {TokenStorageService} from '../../security-authentication/service/token-storage.service';
import {render} from 'creditcardpayments/creditCardPayments';
import {ShareService} from '../../security-authentication/service/share.service';

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
      }
      console.log(this.cartList);
      render({
        id: '#myPaypalButtons',
        currency: 'USD',
        value: this.totalAmount.toString(),
        onApprove: (details) => {
          this.cartService.payment(this.cartList).subscribe(() => {
            Swal.fire({
              title: 'Success!',
              text: 'You are all set!',
              icon: 'success',
              confirmButtonText: 'Ok'
            });
            this.totalAmount = 0;
            this.getCart2();
          });
        }
      });
    });
  }

  getCart2() {
    if (this.tokenStorageService.getToken()) {
      this.userId = this.tokenStorageService.getUser().id;
    }
    this.cartService.getCartByAccountId(this.userId).subscribe(item => {
      this.cartList = item;
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < item.length; i++) {
        this.totalAmount += +item[i].amountCartDetail;
      }
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
          this.totalAmount = 0;
          this.getCart2();
        });
      } else {
        this.cartService.changeQuantity(cartDetailId, this.quantity, this.deleted, productId, cartId).subscribe(next => {
          this.totalAmount = 0;
          this.getCart2();
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
        this.getCart2();
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
      this.totalAmount = 0;
      this.getCart2();
    });
  }

  getInfoDelete(cartDetailId: number, nameProduct: string) {
    this.cartDetailId = cartDetailId;
    this.nameProduct = nameProduct;
  }
}
