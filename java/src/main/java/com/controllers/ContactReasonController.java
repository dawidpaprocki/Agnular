package com.controllers;

import com.entities.Contact;
import com.entities.ContactReason;
import com.repositories.ContactReasonRepository;
import com.repositories.ContactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactReasonController {
    private ContactRepository contactRepository;
    private ContactReasonRepository contactReasonRepository;

  public ContactReasonController(ContactRepository contactRepository, ContactReasonRepository contactReasonRepository) {
    this.contactRepository = contactRepository;
    this.contactReasonRepository = contactReasonRepository;
  }
  @GetMapping("/contactsReason")
  public List<Contact> getContacts(){
   return contactReasonRepository.findAll();
  }
  @GetMapping("/contactsReason/{id}")
  public List<ContactReason> getContactReasonForPatient(@PathVariable Long id){
    List<Contact> contactByPatientId = contactRepository.findContactByPatientId(id);
    return contactByPatientId.stream().map(Contact::getContactReason).collect(Collectors.toList());
  }
  @PostMapping("/contactsReason")
  void  addContact(@RequestBody Contact contact){
    contactReasonRepository.save(contact);
  }
  @DeleteMapping("/contactsReason/{id}")
  void  addContact(@PathVariable Long id){
    contactReasonRepository.deleteById(id);
  }
}
