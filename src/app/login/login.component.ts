import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {LoginService} from '../services/login.service';
import {Login} from '../model/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  status: boolean = false; 

  errorMessage:String="";

  constructor(private route:Router,private loginService:LoginService) { 
    // this.loginService.loginStatus = false;
  }

  ngOnInit(){
    if(this.loginService.loginStatus) {
      this.route.navigate(['home']);
    }
  }

  userData : Login = new Login;
  users: Login[] = [];
  result: Boolean | undefined;
  login(email:String,password:String){
    
    this.userData.email = email;
    this.userData.password = password;
    // console.log(this.userData);
    // this.loginService.checkUser(this.userData).subscribe(data=>{
    //   this.users = data;
    // });
    this.loginService.checkUser(this.userData).subscribe(
      loginData=> {
      if(loginData) {
        this.loginService.loginStatus = true;
        this.loginService.setId(email);
        this.route.navigate(['home']);
      }
      // console.log(this.status);
      console.log(this.loginService.loginStatus);
    });

  }

  gotoAdmin(){
    this.route.navigate(['signup']);
  }
}
