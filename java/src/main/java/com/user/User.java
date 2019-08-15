package com.user;

import com.BaseModel;
import com.privileges.Privileges;
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
public class User extends BaseModel {
  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "privilegesId")
  private Privileges privileges;
}
