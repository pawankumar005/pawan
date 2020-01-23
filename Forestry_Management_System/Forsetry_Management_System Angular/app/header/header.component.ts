import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) { }

  isAdmin() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.loginBeans[0].role === 'admin') {
      return true;
    } else {
      return false;
    }
  }
  isScheduler() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.loginBeans[0].role === 'scheduler') {
      return true;
    } else {
      return false;
    }
  }
  isClient() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.loginBeans[0].role === 'client') {
      return true;
    } else {
      return false;
    }
  }
  isLoggedIn() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }

  logout() {
    localStorage.removeItem('userDetails');
    this.router.navigateByUrl('/login');
  }

  ngOnInit() {
  }

}
