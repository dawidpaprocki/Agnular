package com.contact;

import com.exception.EntityNotFoundException;
import com.exception.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {
  private ContactRepository contactRepository;

  public ContactController(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }

  @GetMapping("/contacts")
  public List<Contact> getContacts() {
    return contactRepository.findAll();
  }

  @GetMapping("/contacts-for-patient/{id}")
  public List<Contact> getContactsForPatient(@PathVariable Long id) {
    return contactRepository.findContactByPatientId(id);
  }

  @GetMapping("/contact/{id}")
  public Contact getContacts(@PathVariable Long id) {
    Contact.class.getSimpleName();
    return contactRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("There is not Contact with id: " + id));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/contact/add")
  void addContact(@RequestBody Contact contact) {
    try{
      contactRepository.save(contact);
    }catch (Exception exception){
     throw new InvalidEntityException(Contact.class);
    }
  }


  @PutMapping("/contact/change")
  void changeContact(@RequestBody Contact contact) {
    contactRepository.save(contact);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping("/contacts/{id}")
  void deleteContact(@PathVariable Long id) {
    contactRepository.deleteById(id);
  }
}
