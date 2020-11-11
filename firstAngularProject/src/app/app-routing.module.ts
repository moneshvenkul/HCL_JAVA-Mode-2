import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditEmpComponent } from './edit-emp/edit-emp.component';
import { QuantityIncrementComponent } from './quantity-increment/quantity-increment.component';
import { ViewEmpComponent } from './view-emp/view-emp.component';

const routes: Routes = [
  {path:'view',component:ViewEmpComponent},
  {path:'edit',component:EditEmpComponent},
  {path:'increment',component:QuantityIncrementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
