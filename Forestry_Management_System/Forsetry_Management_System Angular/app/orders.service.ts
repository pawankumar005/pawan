import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  selectedOrder: Orders;
  selectedOrderToModify: Orders;
  api = 'http://localhost:8080/forestmanagementsystemspringrest';
  constructor(private http: HttpClient) { }
  postData(order): Observable<any> {
    return this.http.post<any>(`${this.api}/add-order`, order);
  }
  getData(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-orders`);
  }
  updateData(order): Observable<any> {
    return this.http.put<any>(`${this.api}/modify-order`, order);
  }
  getorder(): Observable<any> {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    return this.http.get<any>(`${this.api}/get-orderInfo?email=${userDetails.loginBeans[0].email}`);
  }
  deleteData(order: Orders): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-order/${order.orderNo}`);
  }
}
