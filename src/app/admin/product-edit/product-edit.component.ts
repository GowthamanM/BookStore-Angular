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
  constructor(private producteditService:ProducteditService) { 
    
  }
  dataStore(){
    this.producteditService.getProduct().subscribe((data) => {
      this.product = data;
    });
  }
  ngOnInit(): void {
    this.dataStore();
    
    // console.log(this.getProduct);
    // console.log(this.getProduct[0]);
  }


}
