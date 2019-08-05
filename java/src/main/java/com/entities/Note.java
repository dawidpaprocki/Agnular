package com.entities;

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
public class Note extends BaseModel{
   @ManyToOne(cascade = {CascadeType.ALL})
   @JoinColumn(name = "medicalCarerId")
   private MedicalCarer medicalCarer;
   @ManyToOne(cascade = {CascadeType.ALL})
   @JoinColumn(name = "actionId")
   private Action action;
   private String Content;
}
