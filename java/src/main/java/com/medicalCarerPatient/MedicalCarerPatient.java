package com.medicalCarerPatient;

import com.BaseModel;
import com.medicalCarer.MedicalCarer;
import com.patient.Patient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class MedicalCarerPatient extends BaseModel {
  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "patientId")
  private Patient patient;

  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "medicalCarerId")
  private MedicalCarer medicalCarer;

  private boolean active;
}
