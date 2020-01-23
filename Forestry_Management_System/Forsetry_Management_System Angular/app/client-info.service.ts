import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientInfoService {
  selectedClient: Clients;

  api = 'http://localhost:8080/forestmanagementsystemspringrest';
  constructor(private http: HttpClient) { }
  getData(): Observable<any> {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    return this.http.get<any>(`${this.api}/get-clientInfo?email=${userDetails.loginBeans[0].email}`);
  }
  updateData(client): Observable<any> {
    return this.http.put<any>(`${this.api}/modify-account`, client);
  }
 
}
