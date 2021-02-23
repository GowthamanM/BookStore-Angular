import { Component, OnInit } from '@angular/core';
import { Cart } from '../model/cart';
import { LoginService } from '../services/login.service';
import { CartService } from './cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartItems:Cart[]=[];
  constructor(private cartService:CartService,private loginService:LoginService) { }

  ngOnInit(): void {
      this.cartService.setid(this.loginService.userId);
      this.cartService.getCart().subscribe(data => {
        this.cartItems = data;
        console.log(this.cartItems);
      })
  }

}
