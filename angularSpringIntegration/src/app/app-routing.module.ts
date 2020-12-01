import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { SearchCustomersComponent } from './search-customers/search-customers.component';

const routes: Routes = [
  {path: 'add', component: CreateCustomerComponent},
  {path: 'customer', component: CustomersListComponent},
  {path: 'edit', component: EditCustomerComponent},
  {path:'findbyage',component:SearchCustomersComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
