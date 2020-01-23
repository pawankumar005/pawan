import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ClientInfoService } from '../client-info.service';
import { Router } from '@angular/router';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-edit-account',
  templateUrl: './edit-account.component.html',
  styleUrls: ['./edit-account.component.css']
})
export class EditAccountComponent implements OnInit {

  message: string;
  constructor(private clientInfoService: ClientInfoService, 
    private router: Router) { }

  ngOnInit() {
  }
  updateClient(form: NgForm) {
    this.clientInfoService.updateData(form.value).subscribe(data => {
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
