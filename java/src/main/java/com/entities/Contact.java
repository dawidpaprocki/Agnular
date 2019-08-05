package com.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Contact extends BaseModel{

  @ManyToOne
  @JoinColumn(name = "ContactReasonId", nullable = false)
  private ContactReason contactReason;

  @ManyToOne
  @JoinColumn(name = "PatientId", nullable = false)
  private Patient patient;
}
