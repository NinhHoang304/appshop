import {Component, OnInit} from '@angular/core';
import {Product} from '../../../model/product';
import {ProductService} from '../../../service/product.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {TokenStorageService} from '../../security-authentication/service/token-storage.service';
import {ShareService} from '../../security-authentication/service/share.service';
import {CartService} from '../../../service/cart.service';
import {Cart} from '../../../model/cart';
import {CartDetail} from '../../../model/cart-detail';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  product: Product;
  id: number;
  role: string;
  isLoggedIn = false;
  username: string;
  currentUser: string;
  nameEmployee: string;
  userId: number;
  cartId: number;
  quantity = 1;
  deleted = false;
  cartDetail: CartDetail;
  isDisabled: boolean;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private tokenStorageService: TokenStorageService,
              private shareService: ShareService,
              private cartService: CartService) {
  }

  ngOnInit(): void {
    this.view();
    this.getProductById();
    this.shareService.getClickEvent().subscribe(() => {
      this.loadHeader();
    });
    this.loadHeader();
  }

  loadHeader(): void {
    if (this.tokenStorageService.getToken()) {
      this.currentUser = this.tokenStorageService.getUser().username;
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
    }
    this.isLoggedIn = this.username != null;
    this.getUsernameAccount();
  }

  getUsernameAccount() {
    if (this.tokenStorageService.getToken()) {
      this.nameEmployee = this.tokenStorageService.getUser().name;
      this.userId = this.tokenStorageService.getUser().id;
      this.getCartIdByAccountId();
    }
  }

  getProductById() {
    this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
      this.id = +param.get('id');
      this.productService.getProductById(this.id).subscribe(item => {
        console.log('asd' + item);
        this.product = item;
      });
    });
  }

  getCartIdByAccountId() {
    this.cartService.getCartIdByAccountId(this.userId).subscribe(item => {
      this.cartId = item.cartId;
    });
  }

  view(): void {
    window.scrollTo(0, 0);
  }

  subtract() {
    if (this.quantity <= 1) {
      this.quantity = 1;
    } else {
      this.quantity--;
    }
  }

  add() {
    this.quantity++;
  }


  addToCart(id: number) {
    this.cartService.getCartIdByAccountId(this.userId).subscribe(item => {
      this.cartId = item.cartId;
      console.log('asd22' + this.cartId);
      this.cartService.addToCart(this.quantity, this.deleted, id, this.cartId).subscribe(next => {
        Swal.fire({
          title: 'Add Item To Cart Success!',
          text: 'Do you want to continue',
          icon: 'success',
          confirmButtonText: 'Ok'
        });
      });
    });
  }

  changeQuantity(event) {
    if (isNaN(event.target.value) || event.target.value < 0) {
      alert('Number invalid');
      this.quantity = 1;
    }
  }
}
