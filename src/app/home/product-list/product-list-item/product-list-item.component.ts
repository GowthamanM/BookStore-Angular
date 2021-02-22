import { Component, OnInit } from '@angular/core';
import { Productmodel } from 'src/app/model/productmodel';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list-item',
  templateUrl: './product-list-item.component.html',
  styleUrls: ['./product-list-item.component.css']
})
export class ProductListItemComponent implements OnInit {

  products:Productmodel[]=[];

  constructor(private productService:ProductService) { 
    this.productService.getProduct().subscribe(data => this.products = data);
    console.log(this.products);
  }

  ngOnInit(): void {
  }

}
