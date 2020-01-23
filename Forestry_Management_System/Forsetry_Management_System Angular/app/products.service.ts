import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  selectedProductToOrder: Products;
  api = 'http://localhost:8080/forestmanagementsystemspringrest';
  constructor(private http: HttpClient) { }
  postData(product): Observable<any> {
    return this.http.post<any>(`${this.api}/add-product`, product);
  }
  getData(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-products`);
  }
  deleteData(product: Products): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-product/${product.productId}`);
  }
  placeOrder(product): Observable<any> {
    return this.http.post<any>(`${this.api}/add-order`, product);
  }
}
