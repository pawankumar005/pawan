import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {

  message: string;
  constructor(private clientService: ClientService) { }
  addClient(form: NgForm) {
    (this.clientService.postData(form.value)).subscribe(data => {
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
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
