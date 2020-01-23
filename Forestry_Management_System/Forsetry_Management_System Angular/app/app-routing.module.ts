import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AddClientComponent } from './add-client/add-client.component';
import { ClientsComponent } from './clients/clients.component';
import { AddContractComponent } from './add-contract/add-contract.component';
import { ContractsComponent } from './contracts/contracts.component';
import { AddOrderComponent } from './add-order/add-order.component';
import { OrdersComponent } from './orders/orders.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ProductsComponent } from './products/products.component';
import { AuthGuard } from './auth.guard';
import { EditAccountComponent } from './edit-account/edit-account.component';
import { ClientInfoComponent } from './client-info/client-info.component';
import { EditOrderComponent } from './edit-order/edit-order.component';
import { GetOrderComponent } from './get-order/get-order.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


const routes: Route[] = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'add-client', component: AddClientComponent, canActivate: [AuthGuard], data: { expectedRoles: ['admin'] } },
  { path: 'clients', component: ClientsComponent,  canActivate: [AuthGuard], data: { expectedRoles: ['admin,scheduler'] } },
  { path: 'add-contract', component: AddContractComponent,  canActivate: [AuthGuard], data: { expectedRoles: ['scheduler'] } },
  { path: 'contracts', component: ContractsComponent, canActivate: [AuthGuard], data: { expectedRoles: ['admin','scheduler'] } },
  { path: 'add-order', component: AddOrderComponent , canActivate: [AuthGuard], data: { expectedRoles: ['client'] }},
  { path: 'orders', component: OrdersComponent,  canActivate: [AuthGuard], data: { expectedRoles: ['scheduler'] }},
  { path: 'add-product', component: AddProductComponent,  canActivate: [AuthGuard], data: { expectedRoles: ['admin'] }},
  { path: 'products', component: ProductsComponent},
  { path: 'edit-account', component: EditAccountComponent, canActivate: [AuthGuard], data: { expectedRoles: ['client'] }},
  { path: 'client-info', component: ClientInfoComponent },
  { path: 'edit-order', component: EditOrderComponent },
  { path: 'get-order', component: GetOrderComponent },
  {path: '**', component: PageNotFoundComponent}
]



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
