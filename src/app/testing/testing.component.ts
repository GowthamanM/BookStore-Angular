import { Component, OnInit } from '@angular/core';
import { HomeServiceService } from '../services/home-service.service';
@Component({
  selector: 'app-testing',
  templateUrl: './testing.component.html',
  styleUrls: ['./testing.component.css']
})
export class TestingComponent implements OnInit {

  name:any ="";
  constructor(private homeService:HomeServiceService) { 
    
  }

  ngOnInit(){
    this.loadString();
  }

  loadString(){
    this.homeService.getString()
    .subscribe(this.name) 
  }
}
