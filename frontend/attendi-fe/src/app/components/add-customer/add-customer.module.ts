import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AddCustomerComponent} from "./add-customer.component";
import {FormsModule} from "@angular/forms";
import {MatCardModule} from "@angular/material/card";
import {MatIconModule} from "@angular/material/icon";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatOptionModule} from "@angular/material/core";
import {MatSelectModule} from "@angular/material/select";
import {NoopAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";



@NgModule({
  declarations: [AddCustomerComponent],
  exports: [
    AddCustomerComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    MatCardModule,
    MatIconModule,
    MatSlideToggleModule,
    MatFormFieldModule,
    MatOptionModule,
    MatSelectModule,
    NoopAnimationsModule,
    MatButtonModule,
    MatInputModule
  ]
})
export class AddCustomerModule { }
