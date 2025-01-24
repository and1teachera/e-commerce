import { Component, OnInit } from '@angular/core';
import { Product } from "../../common/product";
import { ProductService } from "../../services/product.service";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  currentCategoryId: number = 1;
  currentCategoryName: string = 'Default Category';
  searchMode: boolean = false;

  constructor(private productService: ProductService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }

  listProducts(): void {
    this.searchMode = this.route.snapshot.paramMap.has('keyword');

    if (this.searchMode) {
      this.handleSearchProducts();
    } else {
      this.handleListProducts();
    }
  }

    handleListProducts(): void {
      const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');
      const hasCategoryName: boolean = this.route.snapshot.paramMap.has('name');

      if (hasCategoryId) {
        this.currentCategoryId = +this.route.snapshot.paramMap.get('id')!;
      } else {
        this.currentCategoryId = 1;
      }

      if (hasCategoryName) {
        this.currentCategoryName = this.route.snapshot.paramMap.get('name')!;
      }

      this.productService.getProductList(this.currentCategoryId).subscribe(
          data => {
            this.products = data;
          }
      );
    }

  private handleSearchProducts() {
    const keyword: string = this.route.snapshot.paramMap.get('keyword')!;

    this.productService.searchProducts(keyword).subscribe(
        data => {
          this.products = data;
        }
    );
  }
}
