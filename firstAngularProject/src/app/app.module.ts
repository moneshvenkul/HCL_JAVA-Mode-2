import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeeTitlePipe } from './employee-title.pipe';
import { HomeComponent } from './home/home.component';
import { HomepipePipe } from './homepipe.pipe';
import { ExampleComponent } from './example/example.component';
import { EmployeelistComponent } from './employeelist/employeelist.component';
import { EmployeecountComponent } from './employeecount/employeecount.component';
import { FormsModule } from '@angular/forms';
import { LifecycleComponent } from './lifecycle/lifecycle.component';
import { ViewEmpComponent } from './view-emp/view-emp.component';
import { EditEmpComponent } from './edit-emp/edit-emp.component';
import { QuantityIncrementComponent } from './quantity-increment/quantity-increment.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    EmployeeTitlePipe,
    HomeComponent,
    HomepipePipe,
    ExampleComponent,
    EmployeelistComponent,
    EmployeecountComponent,
    LifecycleComponent,
    ViewEmpComponent,
    EditEmpComponent,
    QuantityIncrementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
