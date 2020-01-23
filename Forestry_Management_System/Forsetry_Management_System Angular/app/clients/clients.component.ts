import { Component, OnInit } from '@angular/core';
import { ClientService } from '../client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  message: string;
  clients: Clients[];
  constructor(private clientService: ClientService,
    private router: Router) { 
      this.getClients();
    }
   

  getClients() {
    this.clientService.getData().subscribe(data => {
      console.log(data);
      this.clients = data.clientBeans;
    }, err => {
      console.log(err);
    });
  }

  isAdmin() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.loginBeans[0].role === 'admin') {
      return true;
    } else {
      return false;
    }
  }
  deleteClient(client: Clients){
    this.clientService.deleteData(client).subscribe(response =>{ 
      console.log(response);
      if(response.message === 'success'){
        this.clients.splice(this.clients.indexOf(client), 1);
        this.message = response.message;
      }
    })
  }

  ngOnInit() {
  }

}
