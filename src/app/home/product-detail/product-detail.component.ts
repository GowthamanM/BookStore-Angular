import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Productmodel } from 'src/app/model/productmodel';
import { map } from 'rxjs/operators';
import { ProductListService } from 'src/app/services/product-list.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  products : Productmodel[] | undefined;
  // products:any;
  id: string | undefined;

  constructor(private productListService: ProductListService, private route: ActivatedRoute) { 
    this.getAllProducts(); 
  }

  ngOnInit() {
    this.route.params
      .subscribe(
        (params: Params) => {
          this.id = params['id'];
          // console.log(this.id);
        }
      );
  }

  public getAllProducts() {
    this.productListService.getProduct()
    // .pipe(map(responseData => {
    //   const productsArray = [];
    //   for(const key in responseData) {
    //     if(responseData.hasOwnProperty(key)) {
    //       productsArray.push( { responseData[key],id: key })
    //     }
    //   }
    //   return productsArray;
    // }))
    .subscribe(data => {
      
      this.products = data;
      // console.log(this.products);
    });
  }

}
