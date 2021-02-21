import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Productmodel } from 'src/app/model/productmodel';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  productList:Productmodel[]=[];
  constructor(private productService:ProductService,public router:Router) { }

  ngOnInit(): void {
      this.productService.getProduct().subscribe(data=>this.productList=data);
  }

  

}
