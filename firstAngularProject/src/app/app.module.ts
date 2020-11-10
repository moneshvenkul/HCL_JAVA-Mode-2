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

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    EmployeeTitlePipe,
    HomeComponent,
    HomepipePipe,
    ExampleComponent,
    EmployeelistComponent,
    EmployeecountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
