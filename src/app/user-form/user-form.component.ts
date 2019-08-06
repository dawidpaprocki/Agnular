import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user/user.service';
import { User } from '../model/user';
import {MatDatepickerInputEvent} from '@angular/material';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  user: User;
  events: string[] = [];

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService, private datePipe: DatePipe) {
    this.user = new User();
  }

  onSubmit() {
   this.user.startContact = this.datePipe.transform(this.user.startContact, 'dd-MM-yyyy');
   this.userService.save(this.user).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }

  addEvent(type: string, event: MatDatepickerInputEvent<Date>) {
    this.events.push(`${type}: ${event.value}`);
  }
}
