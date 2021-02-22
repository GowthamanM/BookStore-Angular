import { Component, OnInit } from '@angular/core';
import { ProducteditService } from 'src/app/services/productedit.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

  constructor(private producteditService:ProducteditService) { 
    this.producteditService.getProduct().subscribe(data => console.log(data));
  }

  ngOnInit(): void {
  }



}
