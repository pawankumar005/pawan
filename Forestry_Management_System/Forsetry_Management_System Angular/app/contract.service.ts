import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  api = 'http://localhost:8080/forestmanagementsystemspringrest';
  constructor(private http: HttpClient) { }
  postData(contract): Observable<any> {
    return this.http.post<any>(`${this.api}/add-contract`, contract);
  }
  getData(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-contracts`);
  }
  deleteData(contract: Contracts): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-contract/${contract.contractNo}`);
  }
}
