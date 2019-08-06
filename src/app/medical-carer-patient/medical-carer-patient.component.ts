import { Component, OnInit } from '@angular/core';
import {MedicalCarerPatientService} from '../service/medicalCarerPatient/medical-carer-patient.service';

@Component({
  selector: 'app-medical-carer-patient',
  templateUrl: './medical-carer-patient.component.html',
  styleUrls: ['./medical-carer-patient.component.css']
})
export class MedicalCarerPatientComponent implements OnInit {

  constructor(private medicalCarerPatientService: MedicalCarerPatientService) {
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
  }

}
