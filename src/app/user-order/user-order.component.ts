import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ordermodel } from '../model/ordermodel';
import { LoginService } from '../services/login.service';
import { UserOrderService } from './user-order.service';

@Component({
  selector: 'app-user-order',
  templateUrl: './user-order.component.html',
  styleUrls: ['./user-order.component.css']
})
export class UserOrderComponent implements OnInit {

  orders:Ordermodel[] = [];

  constructor(private userOrderService:UserOrderService,private loginService:LoginService
    ,private router:Router) { 
        this.userOrderService.getProducts(this.loginService.userId).subscribe((data)=>{
          this.orders = data;
        });
        console.log(this.orders);
    }

  ngOnInit(): void {
  }


}
