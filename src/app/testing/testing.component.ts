import { Component, OnInit } from '@angular/core';
import { Test } from '../model/test';
import { HomeServiceService } from '../services/home-service.service';
@Component({
  selector: 'app-testing',
  templateUrl: './testing.component.html',
  styleUrls: ['./testing.component.css']
})
export class TestingComponent implements OnInit {

  name: Test[] = [];
  constructor(private homeService:HomeServiceService) { 
    
  }

  ngOnInit(){
    this.loadString();
  }

  loadString(){
    this.homeService.getString().subscribe(data => {
      this.name = data;});
  }
}
