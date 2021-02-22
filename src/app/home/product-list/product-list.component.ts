import { Component, OnInit } from '@angular/core';
import { Productmodel } from 'src/app/model/productmodel';
import { ProductListService } from './product-list.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products:Productmodel[] | undefined;

  constructor(private productListService:ProductListService) { 
    
    
  }

  ngOnInit(): void {
    this.productListService.getProduct().subscribe(data =>console.log(data));
    console.log(this.products);
  }

}
