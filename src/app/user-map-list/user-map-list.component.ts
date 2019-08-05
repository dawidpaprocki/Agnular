import {Component, OnInit} from '@angular/core';
import {User} from '../model/user';
import {UserService} from '../service/user/user.service';

@Component({
  selector: 'app-user-map-list',
  templateUrl: './user-map-list.component.html',
  styleUrls: ['./user-map-list.component.css']
})
export class UserMapListComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.userService.findAllMap().subscribe(data => {
      this.users = data;
    });
  }

}
