import { Component, OnInit } from '@angular/core';
import { ContractService } from '../contract.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { OrdersService } from '../orders.service';

@Component({
  selector: 'app-add-contract',
  templateUrl: './add-contract.component.html',
  styleUrls: ['./add-contract.component.css']
})
export class AddContractComponent implements OnInit {

  message: string;
  constructor(private contractService: ContractService,private router: Router, private orderService: OrdersService) { }
  addContract(form: NgForm) {
    (this.contractService.postData(form.value)).subscribe(data => {
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

  ngOnInit() {
  }

}
