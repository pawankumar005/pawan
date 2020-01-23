import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  api = 'http://localhost:8080/forestmanagementsystemspringrest';
  constructor(private http: HttpClient) { }
  postData(client): Observable<any> {
    return this.http.post<any>(`${this.api}/client-register`, client);
  }
  getData(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-clients`);
  }
  deleteData(client: Clients): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-client?email=${client.email}`);
  }
}
