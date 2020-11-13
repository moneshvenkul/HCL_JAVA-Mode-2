import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TemplatedrivenComponent } from './templatedriven/templatedriven.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegsuccessComponent } from './regsuccess/regsuccess.component';
import { ReactivedrivenComponent } from './reactivedriven/reactivedriven.component';

@NgModule({
  declarations: [
    AppComponent,
    TemplatedrivenComponent,
    RegsuccessComponent,
    ReactivedrivenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
