import {Component, OnInit} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact/contact.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  contacts: Contact[];

  constructor(private contactService: ContactService) {
  }

  ngOnInit() {
    this.contactService.findAll().subscribe(
      data => {
        this.contacts = data;
      }
    );
  }

  delete(contact) {
    this.contactService.delete(contact.id).subscribe(
      () => console.log('contact deleted with id: ' + contact.id),
      (err) => console.log('error: ' + err)
    );
    const index = this.contacts.indexOf(contact);
    this.contacts.splice(index, 1);
  }
}
