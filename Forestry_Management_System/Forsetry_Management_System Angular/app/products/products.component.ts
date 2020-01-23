import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../products.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  message: string;
  products: Products[];
  constructor(private productService: ProductsService,
              private router: Router) {
    this.getProducts();
  }
  getProducts() {
    this.productService.getData().subscribe(data => {
      console.log(data);
      this.products = data.productBeans;
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
  isScheduler() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if(userDetails && userDetails.loginBeans[0].role ==='scheduler'){
      return true;
    }else{
      return false;
    }
  }
  isClient() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if(userDetails && userDetails.loginBeans[0].role==='client'){
      return true;
    }else{
      return false;
    }
  }
  deleteProduct(product: Products){
    this.productService.deleteData(product).subscribe(response =>{ 
      console.log(response);
      if(response.message === 'success'){
        this.products.splice(this.products.indexOf(product), 1);
        this.message = response.message;
      }
    })
  }
  selectProduct(product){
    this.productService.selectedProductToOrder=product;
    this.router.navigateByUrl('/add-order');
  }


  ngOnInit() {
  }

}
