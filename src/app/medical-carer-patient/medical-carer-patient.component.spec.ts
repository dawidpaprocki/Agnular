import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalCarerPatientComponent } from './medical-carer-patient.component';

describe('MedicalCarerPatientComponent', () => {
  let component: MedicalCarerPatientComponent;
  let fixture: ComponentFixture<MedicalCarerPatientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalCarerPatientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalCarerPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
