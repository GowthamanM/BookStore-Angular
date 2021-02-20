import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  errorMessage = "";
  constructor(public router:Router) { }

  ngOnInit(): void {
  }

  test(email:String,pass1:String,pass2:String,username:String,number:String){
    if(pass1 !== pass2){
      this.errorMessage = "Password does not match";
    }else{
      this.errorMessage = "";
      this.router.navigate(['']);
    }
  }
}
