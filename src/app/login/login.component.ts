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

  constructor(private router:Router,private loginService:LoginService) { }

  ngOnInit(): void {
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
    this.loginService.checkUser(this.userData).subscribe(Logindata=> {
      if(Logindata) {
        this.status = true;
      }
      console.log(this.status);
    });

  }

  gotoAdmin(){
    this.router.navigate(['signup']);
  }
}
