import {Component, OnInit} from '@angular/core';
import {Product} from '../../../model/product';
import {ProductService} from '../../../service/product.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {TokenStorageService} from '../../security-authentication/service/token-storage.service';
import {ShareService} from '../../security-authentication/service/share.service';

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

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private tokenStorageService: TokenStorageService,
              private shareService: ShareService) {
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

  view(): void {
    window.scrollTo(0, 0);
  }
}
