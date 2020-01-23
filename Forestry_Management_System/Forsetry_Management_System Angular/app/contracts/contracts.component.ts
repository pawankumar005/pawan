import { Component, OnInit } from '@angular/core';
import { ContractService } from '../contract.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contracts',
  templateUrl: './contracts.component.html',
  styleUrls: ['./contracts.component.css']
})
export class ContractsComponent implements OnInit {

  message: string;
  contracts: Contracts[];
  constructor(private contractService: ContractService,
    private router: Router) {
    this.getContracts();
  }
  isScheduler() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.loginBeans[0].role === 'scheduler') {
      return true;
    } else {
      return false;
    }
  }
  getContracts() {
    this.contractService.getData().subscribe(data => {
      console.log(data);
      this.contracts = data.contractBeans;
    }, err => {
      console.log(err);
    });
  }
  deleteContract(contract) {
    this.contractService.deleteData(contract).subscribe(response => {
      console.log(response);
      if (response.message === 'success') {
        this.contracts.splice(this.contracts.indexOf(contract), 1);
        this.message = response.message;
      }
    })
  }



  ngOnInit() {
  }

}
