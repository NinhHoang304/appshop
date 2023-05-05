import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CartDTO} from '../dto/cart-dto';
import {AccountDTO} from '../dto/account-dto';
import {CartDetail} from '../model/cart-detail';
import {CartDetailDTO} from '../dto/cart-detail-dto';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private httpClient: HttpClient) {
  }

  getCartByAccountId(id: number): Observable<CartDTO[]> {
    return this.httpClient.get<CartDTO[]>('http://localhost:8080/api/user/cart/' + id);
  }

  getCartIdByAccountId(accountId: number): Observable<AccountDTO> {
    return this.httpClient.get<AccountDTO>('http://localhost:8080/api/user/cartId/' + accountId);
  }

  addToCart(quantity: number, deleted: boolean, productId: number, cartId: number): Observable<any> {
    return this.httpClient.get<any>('http://localhost:8080/api/user/cart/add/' + quantity + '/' + deleted + '/' + productId + '/' + cartId);
  }

  changeQuantity(cartDetailId: number, quantity: number, deleted: boolean, productId: number, cartId: number): Observable<any> {
    return this.httpClient.get<any>('http://localhost:8080/api/user/cart/add/' + cartDetailId + '/' + quantity + '/' + deleted + '/' + productId + '/' + cartId);
  }

  getCartDetailById(cartDetailId: number): Observable<CartDetailDTO> {
    return this.httpClient.get<CartDetailDTO>('http://localhost:8080/api/user/cartDetail/' + cartDetailId);
  }

  deleteCartById(cartDetailId: number) {
    return this.httpClient.get('http://localhost:8080/api/user/delete/cartDetail/' + cartDetailId);
  }
}
