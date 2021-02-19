import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Test} from '../model/test'
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class HomeServiceService {

  private apiUrl: string;

  constructor(private http: HttpClient) {
    this.apiUrl = 'http://localhost:8080/';
  }


  public getString(): Observable<Test[]> {
    return this.http.get<Test[]>(this.apiUrl);
  }
}
