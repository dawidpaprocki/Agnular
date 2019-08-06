import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserMapListComponent } from './user-map-list/user-map-list.component';
import {ContactComponent} from './contact/contact.component';
import {ContactFormComponent} from './contacts-form/contact-form.component';

const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent },
  { path: 'users/map', component: UserMapListComponent },
  { path: 'contacts', component: ContactComponent },
  { path: 'addcontact', component: ContactFormComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
