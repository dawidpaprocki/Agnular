package application.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class User extends BaseModel {
   private String LastName;
   private Long PESEL;
   private Long PhoneNumber;
   private String Email;
   private Date StartContact;
   private Date EndContact;
}
