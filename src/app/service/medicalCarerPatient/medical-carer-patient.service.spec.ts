import { TestBed } from '@angular/core/testing';

import { MedicalCarerPatientService } from './medical-carer-patient.service';

describe('MedicalCarerPatientService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MedicalCarerPatientService = TestBed.get(MedicalCarerPatientService);
    expect(service).toBeTruthy();
  });
});
