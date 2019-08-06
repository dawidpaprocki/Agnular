package com.entities;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MedicalCarerPatient extends BaseModel {
  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "patientId")
  private Patient patient;

  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "medicalCarerId")
  private MedicalCarer medicalCarer;

  private boolean active;
}
