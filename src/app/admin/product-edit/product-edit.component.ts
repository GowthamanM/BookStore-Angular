import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Productmodel } from 'src/app/model/productmodel';
import { ProducteditService } from 'src/app/services/productedit.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

  // getProduct:Productmodel;
  // product:Productmodel=new Productmodel;
  product: any;
  productname:String=this.getNames();
  price='s';
  constructor(private producteditService:ProducteditService) { 
  }
  dataStore(){
    this.producteditService.getProduct().subscribe((data) => {
      this.product = data;
      // this.price = data.price;
    });
    console.log(this.productname);
    // this.productname=this.product.productName;
    console.log(this.productname);
    
  }
  submitForm(){
    // console.log(this.productname);
  }
  a:any;
  getNames(){
    this.producteditService.getProduct().subscribe((data) => {
      this.a = data.productName;
      // this.price = data.price;
    });
    return this.a;
  }
  ngOnInit(): void {
    this.dataStore();

  }

}
