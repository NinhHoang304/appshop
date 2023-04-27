import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {Product} from '../../../model/product';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
  productPage: Product[];
  currentPage = 0;
  categoryId = '';
  nameSearch = '';

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.view();
    this.getAllProducts();
  }

  getAllProducts() {
    this.productService.getAllProducts(this.nameSearch, this.categoryId, this.currentPage).subscribe(item => {
      console.log(item);
      this.productPage = item.content;
    });
  }
  view(): void {
    window.scrollTo(0, 0);
  }
}
