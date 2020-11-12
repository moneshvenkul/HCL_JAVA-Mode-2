import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TemplatedrivenComponent } from './templatedriven/templatedriven.component';
import { FormsModule } from '@angular/forms';
import { RegsuccessComponent } from './regsuccess/regsuccess.component';

@NgModule({
  declarations: [
    AppComponent,
    TemplatedrivenComponent,
    RegsuccessComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
