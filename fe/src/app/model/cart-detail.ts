import {Cart} from './cart';
import {Product} from './product';

export interface CartDetail {
  quantity?: number;
  deleted?: boolean;
  cart?: Cart;
  product?: Product;
}
