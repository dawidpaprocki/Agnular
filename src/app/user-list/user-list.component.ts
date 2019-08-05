import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) {

  }

  delete(user) {
    this.userService.delete(user.id).subscribe(
      () => console.log('employee deleted with id: ' + user.id),
      (err) => console.log('error: ' + err)
    );
    const index = this.users.indexOf(user);
    this.users.splice(index, 1);
  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }
}
