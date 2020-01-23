import { Component, OnInit } from '@angular/core';
import { ClientService } from '../client.service';
import { Router } from '@angular/router';
import { ClientInfoService } from '../client-info.service';
import { OrdersService } from '../orders.service';

@Component({
  selector: 'app-client-info',
  templateUrl: './client-info.component.html',
  styleUrls: ['./client-info.component.css']
})
export class ClientInfoComponent implements OnInit {

  client: Clients[];
  
  

  constructor(private clientInfoService: ClientInfoService, private clientService: ClientService, private orderService: OrdersService,
    private router: Router) {
    this.getClientInfo();
    
  }
  getClientInfo() {
    this.clientInfoService.getData().subscribe(data => {
      console.log(data);
      this.client = data.clientBean;
    }, err => {
      console.log(err);
    });
  }
  modifyClientInfo(client: Clients) {
    this.clientInfoService.selectedClient = client;
    this.router.navigateByUrl('/edit-account');

  }
  deleteClient(client: Clients) {
    confirm('Do you want to delete account Permanently')
    this.clientService.deleteData(client).subscribe(response => {
      console.log(response);
      if (response.message === 'success') {


        localStorage.removeItem('userDetails');
        this.router.navigateByUrl('/login');
      }
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
