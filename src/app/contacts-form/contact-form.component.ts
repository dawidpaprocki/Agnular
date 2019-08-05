import { Component, OnInit } from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact/contact.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-contacts-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent  {

  contact: Contact;

  constructor(private route: ActivatedRoute, private router: Router, private contactService: ContactService) {
    this.contact = new Contact();
  }

  onSubmit() {
    this.contactService.save(this.contact).subscribe(
      result => this.goToContactList());
  }

  goToContactList() {
    this.router.navigate(['/contacts']);
  }
}
