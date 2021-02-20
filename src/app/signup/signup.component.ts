import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  errorMessage = "";
  constructor() { }

  ngOnInit(): void {
  }

  test(data:String,pass1:String,pass2:String){
    if(pass1 !== pass2){
      this.errorMessage = "Password does not match";
    }else{
      this.errorMessage = "";
    }
  }
}
