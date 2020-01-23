import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message: string;
  constructor(private auth: AuthenticationService,
              private router: Router) { }

  ngOnInit() {
  }
  login(form: NgForm) {
    this.auth.loginUser(form.value).subscribe(response => {

      if (response.statusCode === 201) {
        console.log(response);
        localStorage.setItem('userDetails', JSON.stringify(response));
        console.log('User details stored in local storage');
        this.message = response.message;
        this.router.navigateByUrl('/');
        setTimeout(() => {
          this.message = null;
        }, 3000);
      } else {
        console.log(response);
        this.message = response.description;
        setTimeout(() => {
          this.message = null;
        }, 3000);
      }


    });
  }
}






