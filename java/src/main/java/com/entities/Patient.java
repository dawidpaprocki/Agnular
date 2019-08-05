package com.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Patient extends BaseModel {
  private String lastName;
  private Long pesel;
  private Long phoneNumber;
  private String email;
  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "contactFormId")
  private ContactForm contactForm;
  private Date startContact;
  private Date endContact;
  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "medicalCarerId")
  private MedicalCarer medicalCarer;
  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "medicalFacilityId")
  private MedicalFacility medicalFacility;

}
