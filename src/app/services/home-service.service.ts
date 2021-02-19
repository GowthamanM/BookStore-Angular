import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Test} from '../model/test'
@Injectable({
  providedIn: 'root'
})
export class HomeServiceService {

  apiUrl = 'http://localhost:8080/';
  httpOptions = {
    headers :new HttpHeaders({
      'Content-Type':'application/json'
    })    
  }

  constructor(private _http: HttpClient) {}

  getString(){
    return this._http.get<Test>(this.apiUrl);
  }
}
