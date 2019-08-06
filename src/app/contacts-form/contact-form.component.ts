import {Component, OnInit} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact/contact.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Patient} from '../model/patient';
import {PatientService} from '../service/patient/patient.service';
import {NgForm} from '@angular/forms';
import {ContactReason} from '../model/contactReason';

@Component({
  selector: 'app-contacts-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  contact: Contact;
  contactReason: ContactReason[];
  patients: Patient[];

  constructor(private route: ActivatedRoute, private router: Router, private contactService: ContactService,
              private patientService: PatientService,  ) {
    this.contact = new Contact();
  }

  onSubmit() {
    console.log(this.contact);
    this.contactService.save(this.contact).subscribe(
      result => this.goToContactList());
  }

  goToContactList() {
    this.router.navigate(['/contacts']);
  }

  ngOnInit() {
    this.patientService.findAll().subscribe(data => {
      this.patients = data;
    });

  }
}
