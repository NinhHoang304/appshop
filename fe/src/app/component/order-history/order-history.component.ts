import {Component, OnInit} from '@angular/core';
import {CartService} from '../../service/cart.service';
import {TokenStorageService} from '../security-authentication/service/token-storage.service';
import {CartDTO} from '../../dto/cart-dto';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent implements OnInit {

  cartList: CartDTO[];
  userId: number;

  constructor(private cartService: CartService,
              private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.getOrderHistory();
  }

  getOrderHistory() {
    if (this.tokenStorageService.getToken()) {
      this.userId = this.tokenStorageService.getUser().id;
    }
    this.cartService.getOrderHistory(this.userId).subscribe(item => {
      this.cartList = item;
    });
  }

}
