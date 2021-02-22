import { Component, OnInit } from '@angular/core';
import { Productmodel } from 'src/app/model/productmodel';
import { ProductListService } from './product-list.service';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products:Productmodel[] | undefined;

  constructor(private productListService:ProductListService) { 
    this.getAllProducts();
    
  }

  ngOnInit(): void {
    
  }

  public getAllProducts() {
    this.productListService.getProduct()
    .pipe(map(responseData => {
      const productsArray = [];
      for(const key in responseData) {
        if(responseData.hasOwnProperty(key)) {
          productsArray.push( { ...responseData[key] })
        }
      }
      return productsArray;
    }))
    .subscribe(data => {
      console.log(data);
      this.products = data;
    });

    // console.log(this.products[0].productName);
  }

}
