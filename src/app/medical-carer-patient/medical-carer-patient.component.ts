import { Component, OnInit } from '@angular/core';
import {MedicalCarerPatientService} from '../service/medicalCarerPatient/medical-carer-patient.service';
import {MedicalCarerPatient} from '../model/medicalCarerPatient';

@Component({
  selector: 'app-medical-carer-patient',
  templateUrl: './medical-carer-patient.component.html',
  styleUrls: ['./medical-carer-patient.component.css']
})
export class MedicalCarerPatientComponent implements OnInit {

  private medicalCarerPatient: MedicalCarerPatient[]

  constructor(private medicalCarerPatientService: MedicalCarerPatientService) {
  }

  delete(medicalCarerPatient) {
    this.medicalCarerPatientService.delete(medicalCarerPatient.id).subscribe(
      () => console.log('medicalCarerPatient deleted with id: ' + medicalCarerPatient.id),
      (err) => console.log('error: ' + err)
    );
    const index = this.medicalCarerPatient.indexOf(medicalCarerPatient);
    this.medicalCarerPatient.splice(index, 1);
  }
  ngOnInit() {
  }

}
