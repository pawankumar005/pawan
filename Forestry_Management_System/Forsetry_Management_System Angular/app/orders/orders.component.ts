import { Component, OnInit } from '@angular/core';
import { OrdersService } from '../orders.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  message: string;
  orders: Orders[];
  constructor(private orderService: OrdersService,
              private router: Router) {
    this.getOrders();
  }
  getOrders() {
    this.orderService.getData().subscribe(data => {
      console.log(data);
      this.orders = data.orderBeans;
    }, err => {
      console.log(err);
    });
  }
  addcontract(order: Orders){
    this.orderService.selectedOrder=order;
    this.router.navigateByUrl('/add-contract');
  }
 


  ngOnInit() {
  }

}
