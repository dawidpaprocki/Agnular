import { Component, OnInit } from '@angular/core';
import {Contact} from '../model/contact';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  contacts: Contact[];

  constructor() { }

  ngOnInit() {
  }

}
