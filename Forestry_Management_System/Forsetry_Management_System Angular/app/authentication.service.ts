import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  api = `http://localhost:8080`;

  constructor(private http: HttpClient) { }
  loginUser(userCredentials): Observable<any>{
    return this.http.post(`${this.api}/forestmanagementsystemspringrest/login`, userCredentials)
  }
}
