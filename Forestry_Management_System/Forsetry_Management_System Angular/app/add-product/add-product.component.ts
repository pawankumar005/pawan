import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../products.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  message: string;
  constructor(private productService: ProductsService) { }
  addOrder(form: NgForm) {
    (this.productService.postData(form.value)).subscribe(data => {
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
