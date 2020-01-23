import { Component, OnInit } from '@angular/core';
import { OrdersService } from '../orders.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-order',
  templateUrl: './get-order.component.html',
  styleUrls: ['./get-order.component.css']
})
export class GetOrderComponent implements OnInit {

  orders: Orders[];
  message: string;
  constructor(private orderService: OrdersService, private router: Router) {
    this.getOrderInfo();
   }
  getOrderInfo() {
    this.orderService.getData().subscribe(data => {
      console.log(data);
      this.orders = data.orderBeans;
    }, err => {
      console.log(err);
    });
  }
  delete(order) {
    this.orderService.deleteData(order).subscribe(response => {
      console.log(response);
      if (response.message === 'success') {
        this.orders.splice(this.orders.indexOf(order), 1);
        this.message = response.description;
      }else{
        this.message=response.description;
      }
      setTimeout(() => {
        this.message = null;
      }, 3000);
    })
  }
  isClient() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.loginBeans[0].role === 'client') {
      return true;
    } else {
      return false;
    }
  }

  ngOnInit() {
  }

}
