import {Category} from './category';

export interface Product {
  id?: number;
  code?: string;
  name?: string;
  price?: number;
  quantity?: number;
  brand?: string;
  description?: string;
  image?: string;
  deleted?: boolean;
  category?: Category;
}
