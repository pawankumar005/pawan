import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ProductsComponent } from './products/products.component';
import { AddContractComponent } from './add-contract/add-contract.component';
import { AddProductComponent } from './add-product/add-product.component';
import { AddClientComponent } from './add-client/add-client.component';
import { ClientsComponent } from './clients/clients.component';
import { ContractsComponent } from './contracts/contracts.component';
import { OrdersComponent } from './orders/orders.component';
import { AddOrderComponent } from './add-order/add-order.component';
import { EditAccountComponent } from './edit-account/edit-account.component';
import { ClientInfoComponent } from './client-info/client-info.component';
import { EditOrderComponent } from './edit-order/edit-order.component';
import { GetOrderComponent } from './get-order/get-order.component';
import { FilterProductPipe } from './filter-product.pipe';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    HomeComponent,
    ProductsComponent,
    AddContractComponent,
    AddProductComponent,
    AddClientComponent,
    ClientsComponent,
    ContractsComponent,
    OrdersComponent,
    AddOrderComponent,
    EditAccountComponent,
    ClientInfoComponent,
    EditOrderComponent,
    GetOrderComponent,
    FilterProductPipe,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
   
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
