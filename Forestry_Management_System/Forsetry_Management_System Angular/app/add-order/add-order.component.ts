import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { OrdersService } from '../orders.service';
import { ProductsService } from '../products.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit {

  message: string;
  loginedEmail: string;
  constructor(private productService: ProductsService,private router: Router) { 
    this.getUserDetails();
  }
  addOrder(form: NgForm) {
    (this.productService.placeOrder(form.value)).subscribe(data => {
      console.log(data);
      if (data.statusCode === 200) {
        this.message = data.description;
        setTimeout(() => {
          this.message = null;
        }, 5000);
        form.reset();
      } else {
        this.message = data.description;
        setTimeout(() => {
          this.message = null;
        }, 5000);
      }
    }, err => {
      console.log(err);
    });
  }
  getUserDetails() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails) {
      this.loginedEmail = userDetails.loginBeans[0].email;
    } else {
      this.message = null;
    }
  }

  ngOnInit() {
  }

}
