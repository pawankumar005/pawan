import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { OrdersService } from '../orders.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-order',
  templateUrl: './edit-order.component.html',
  styleUrls: ['./edit-order.component.css']
})
export class EditOrderComponent implements OnInit {

  message:string;
  constructor(private orderService: OrdersService, 
    private router: Router) { }

  ngOnInit() {
  }
  updateOrder(form: NgForm) {
    this.orderService.updateData(form.value).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.message = data.description;
        setTimeout(() => {
          this.message = null;
        }, 2000);
        form.reset();
      } else {
        this.message = data.description;
        setTimeout(() => {
          this.message = null;
        }, 2000);
        form.reset();

      }
    })
  }

}
