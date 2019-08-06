import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {UserListComponent} from './user-list/user-list.component';
import {UserFormComponent} from './user-form/user-form.component';
import {UserService} from './service/user/user.service';
import {UserMapListComponent} from './user-map-list/user-map-list.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule, MatInputModule, MatNativeDateModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { DatePipe } from '@angular/common';
import { ContactComponent } from './contact/contact.component';
import { ContactFormComponent } from './contacts-form/contact-form.component';
import { MedicalCarerPatientComponent } from './medical-carer-patient/medical-carer-patient.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserMapListComponent,
    UserFormComponent,
    UserMapListComponent,
    ContactComponent,
    ContactFormComponent,
    MedicalCarerPatientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatInputModule,
    MatNativeDateModule,
    BrowserAnimationsModule
  ],
  providers: [UserService, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule {
}
