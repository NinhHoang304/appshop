import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {Product} from '../../../model/product';
import {CategoryService} from '../../../service/category.service';
import {Category} from '../../../model/category';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
  productPage: Product[];
  categoryList: Category[];
  currentPage = 0;
  totalPages = 0;
  size = 8;
  categoryId = 0;
  nameSearch = '';

  constructor(private productService: ProductService,
              private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.view();
    this.getAllProducts();
    this.getAllCategory();
  }

  getAllProducts() {
    this.productService.getAllProducts(this.nameSearch, this.categoryId, this.currentPage, this.size).subscribe(item => {
      console.log(item);
      this.productPage = item.content;
      this.totalPages = item.totalPages;
    });
  }

  getAllCategory() {
    this.categoryService.getAllCategory().subscribe(item => {
      this.categoryList = item;
    });
  }

  view(): void {
    window.scrollTo(0, 0);
  }

  searchByName(value: string) {
    this.nameSearch = value;
    this.currentPage = 0;
    this.getAllProducts();
  }

  getCategoryId(id: number) {
    this.categoryId = id;
    this.getAllProducts();
  }

  getAll() {
    this.nameSearch = '';
    this.categoryId = 0;
    this.currentPage = 0;
    this.getAllProducts();
  }

  loadMore(): void {
    this.size += 4;
    this.getAllProducts();
  }
  showLoadMore(): boolean {
    return this.currentPage < this.totalPages - 1;
  }
}
