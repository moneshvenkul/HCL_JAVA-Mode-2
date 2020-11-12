import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditEmpTemplateDrivenComponent } from './edit-emp-template-driven/edit-emp-template-driven.component';
import { EditEmpComponent } from './edit-emp/edit-emp.component';
import { QuantityIncrementComponent } from './quantity-increment/quantity-increment.component';
import { ViewEmpComponent } from './view-emp/view-emp.component';

const routes: Routes = [
  {path:'view',component:ViewEmpComponent},
  {path:'edit',component:EditEmpComponent},
  {path:'increment',component:QuantityIncrementComponent},
  {path:'edit_emp',component:EditEmpTemplateDrivenComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
