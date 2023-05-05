import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../model/product';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private API_URL = 'http://localhost:8080/api/public/product/list';

  constructor(private httpClient: HttpClient) {
  }

  getAllProducts(name: string, categoryId: number, page: number, size: number): Observable<Page<Product>> {
    return this.httpClient.get<Page<Product>>(this.API_URL + '?name=' + name +
      '&categoryId=' + categoryId + '&page=' + page + '&size=' + size);
  }

  getProductById(id: number): Observable<Product> {
    return this.httpClient.get<Product>('http://localhost:8080/api/public/product/detail/' + id);
  }
}

export interface Page<T> {
  content: T[];
  pageable: {
    sort: {
      sorted: boolean;
      unsorted: boolean;
    };
    pageNumber: number;
    pageSize: number;
    offset: number;
    unpaged: boolean;
  };
  totalPages: number;
  totalElements: number;
  last: boolean;
  size: number;
  number: number;
  sort: {
    sorted: boolean;
    unsorted: boolean;
  };
  numberOfElements: number;
  first: boolean;
  empty: boolean;
}
