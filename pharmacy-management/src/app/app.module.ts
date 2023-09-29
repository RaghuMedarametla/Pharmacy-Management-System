import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
//import { AppRoutingModule } from './app-routing.module';


import { HttpClientModule } from '@angular/common/http';
// import { DropdownModule } from 'primeng/dropdown';
// import {MultiSelectModule} from 'primeng/multiselect';
import { AppComponent } from './app.component';
import { OutputpageComponent } from './outputpage/outputpage.component';

@NgModule({
  declarations: [
    AppComponent,
    OutputpageComponent
  ],
  imports: [
    BrowserModule,
    // DropdownModule,
    // MultiSelectModule,
    //AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }




