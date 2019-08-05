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
public class Scenario extends BaseModel {
   private String Content;
   @ManyToOne(cascade = {CascadeType.ALL})
   @JoinColumn(name = "actionId")
   private Action action;
}
