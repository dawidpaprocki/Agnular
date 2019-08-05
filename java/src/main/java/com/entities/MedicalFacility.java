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
public class MedicalFacility extends BaseModel {
   private String Street;
   private String City;
   private String Number;
   private String PostalCode;
   @ManyToOne(cascade = {CascadeType.ALL})
   @JoinColumn(name = "userId")
   private User user;
}
