package application.entities;

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
public class Patient extends BaseModel{
   private String lastName;
   private Long pesel;
   private Long phoneNumber;
   private String email;
   @ManyToOne(cascade = {CascadeType.ALL})
   @JoinColumn(name = "contactFormId")
   private ContactForm contactForm;
   private String startContact;
   private String endContact;

}
